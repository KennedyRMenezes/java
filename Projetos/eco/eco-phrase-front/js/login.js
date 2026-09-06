// js/login.js

document.getElementById('loginForm').addEventListener('submit', async function(e) {
    e.preventDefault();

    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;
    const errorMessage = document.getElementById('errorMessage');

    errorMessage.style.display = 'none';

    try {
        // Chamada Fetch utilizando as rotas centralizadas do config.js
        const response = await fetch(`${API_CONFIG.BASE_URL}${API_CONFIG.ENDPOINTS.LOGIN}`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ email: email, password: password })
        });

        if (!response.ok) {
            throw new Error('Falha no login. Verifique suas credenciais.');
        }

        const data = await response.json();

        // Armazena o Token / Dados retornados do Java
        localStorage.setItem('authToken', data.token);
        localStorage.setItem('userData', JSON.stringify(data.user || data));

        // Redireciona para a página de perfil após sucesso
        window.location.href = 'perfil.html';

    } catch (error) {
        // Trata erro de conexão ou credenciais inválidas
        errorMessage.innerText = error.message || 'Erro ao conectar ao servidor Java.';
        errorMessage.style.display = 'block';
    }
});
