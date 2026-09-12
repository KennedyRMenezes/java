let phraseToDelete = null;


document.addEventListener('DOMContentLoaded', function () {

    carregarFrases('/frases/minhas');

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