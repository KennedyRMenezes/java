let phraseToDelete = null;


document.addEventListener('DOMContentLoaded', function () {

    carregarFrases();

    document
        .getElementById('cancel-delete')
        .addEventListener('click', function () {

            phraseToDelete = null;

            document
                .getElementById('delete-modal')
                .classList.remove('active');

        });


    document
        .getElementById('confirm-delete')
        .addEventListener('click', async function () {

            if (!phraseToDelete) {
                return;
            }

            const token = localStorage.getItem('authToken');

            if (!token) {
                window.location.href = 'login.html';
                return;
            }

            try {

                const response = await fetch(
                    `${API_CONFIG.BASE_URL}/frase/${phraseToDelete}`,
                    {
                        method: 'DELETE',

                        headers: {
                            'Authorization': `Bearer ${token}`
                        }
                    }
                );

                console.log('STATUS DELETE:', response.status);

                if (response.status === 401) {

                    localStorage.removeItem('authToken');

                    window.location.href = 'login.html';

                    return;
                }

                if (!response.ok) {

                    throw new Error(
                        `Erro HTTP: ${response.status}`
                    );

                }

                // Fecha o popup
                document
                    .getElementById('delete-modal')
                    .classList.remove('active');

                // Limpa o ID da frase
                phraseToDelete = null;

                // Recarrega as frases
                await carregarFrases();

            } catch (error) {

                console.error(
                    'Erro ao excluir frase:',
                    error
                );

                alert(
                    'Não foi possível excluir a frase.'
                );

            }

        });

});


async function carregarFrases() {

    const token = localStorage.getItem('authToken');

    if (!token) {
        window.location.href = 'login.html';
        return;
    }

    try {

        const response = await fetch(
            `${API_CONFIG.BASE_URL}/frases/minhas`,
            {
                method: 'GET',

                headers: {
                    'Authorization': `Bearer ${token}`,
                    'Content-Type': 'application/json'
                }
            }
        );

        if (response.status === 401) {

            localStorage.removeItem('authToken');

            window.location.href = 'login.html';

            return;
        }

        if (!response.ok) {
            throw new Error(`Erro HTTP: ${response.status}`);
        }

        const frases = await response.json();

        renderPhrases(frases);

    } catch (error) {

        console.error('Erro ao buscar frases:', error);

    }
}


function renderPhrases(frases) {

    const container = document.getElementById('phrases-container');

    container.innerHTML = '';

    if (frases.length === 0) {

        container.innerHTML = `
            <div class="card">
                <p>Você ainda não possui nenhuma frase.</p>
            </div>
        `;

        return;
    }

    frases.forEach(frase => {

        const card = document.createElement('div');

        card.classList.add('card-phrase');

        card.innerHTML = `

            <div class="phrase-header">

                <div class="phrase-text">
                    "${frase.text}"
                </div>

                <button
                    class="btn-delete"
                    data-id="${frase.id}"
                    title="Excluir frase"
                    aria-label="Excluir frase">

                    <svg
                        width="18"
                        height="18"
                        viewBox="0 0 24 24"
                        fill="none"
                        stroke="currentColor"
                        stroke-width="2"
                        stroke-linecap="round"
                        stroke-linejoin="round">

                        <path d="M3 6h18"/>
                        <path d="M8 6V4h8v2"/>
                        <path d="M19 6l-1 14H6L5 6"/>
                        <path d="M10 11v5"/>
                        <path d="M14 11v5"/>

                    </svg>

                </button>

            </div>

            <div class="phrase-author">
                ${frase.author || 'Autor desconhecido'}
            </div>

            <div class="phrase-origin">
                ${frase.origin || 'Origem desconhecida'}
            </div>

            <div class="phrase-actions">

                <span class="phrase-label">
                    Próxima revisão:
                </span>

                <div class="interval-buttons">

                    <button
                        class="btn-interval"
                        data-id="${frase.id}"
                        data-days="3">
                        3 dias
                    </button>

                    <button
                        class="btn-interval"
                        data-id="${frase.id}"
                        data-days="5">
                        5 dias
                    </button>

                    <button
                        class="btn-interval"
                        data-id="${frase.id}"
                        data-days="15">
                        15 dias
                    </button>

                </div>

            </div>
        `;

        container.appendChild(card);
    });

    addDeleteListeners();
    addIntervalListeners();
}


function addDeleteListeners() {

    const deleteButtons =
        document.querySelectorAll('.btn-delete');

    deleteButtons.forEach(button => {

        button.addEventListener('click', function () {

            const phraseId = this.dataset.id;

            showDeleteConfirmation(phraseId);

        });

    });
}


function showDeleteConfirmation(phraseId) {

    phraseToDelete = phraseId;

    const modal =
        document.getElementById('delete-modal');

    modal.classList.add('active');
}

function addIntervalListeners() {

    const intervalButtons =
        document.querySelectorAll('.btn-interval');

    intervalButtons.forEach(button => {

        button.addEventListener('click', async function () {

            const phraseId = this.dataset.id;
            const days = this.dataset.days;

            const token = localStorage.getItem('authToken');

            if (!token) {
                window.location.href = 'login.html';
                return;
            }

            try {

                const response = await fetch(
                    `${API_CONFIG.BASE_URL}/frase/${phraseId}/revisao`,
                    {
                        method: 'PUT',

                        headers: {
                            'Authorization': `Bearer ${token}`,
                            'Content-Type': 'application/json'
                        },

                        body: JSON.stringify({
                            days: Number(days)
                        })
                    }
                );

                console.log('STATUS REVISÃO:', response.status);

                if (response.status === 401) {

                    localStorage.removeItem('authToken');

                    window.location.href = 'login.html';

                    return;
                }

                if (!response.ok) {
                    throw new Error(
                        `Erro HTTP: ${response.status}`
                    );
                }

                console.log(
                    `Revisão definida para ${days} dias.`
                );

            } catch (error) {

                console.error(
                    'Erro ao definir revisão:',
                    error
                );

                alert(
                    'Não foi possível definir a próxima revisão.'
                );
            }
        });
    });
}