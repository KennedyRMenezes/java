// js/perfil.js

console.log("CONFIG:", API_CONFIG);
console.log("BASE:", API_CONFIG.BASE_URL);
console.log("PERFIL:", API_CONFIG.ENDPOINTS.PERFIL);

document.addEventListener('DOMContentLoaded', async function() {
    // 1. Captura o token vindo na URL após o redirecionamento do Java (Google OAuth2)
    const urlParams = new URLSearchParams(window.location.search);
    const tokenURL = urlParams.get('token');

    if (tokenURL) {
        localStorage.setItem('authToken', tokenURL);
        // Limpa o parâmetro da URL para não expor o token no navegador
        window.history.replaceState({}, document.title, window.location.pathname);
    }

    // 2. Busca o token armazenado
    const token = localStorage.getItem('authToken');

    if (!token) {
        window.location.href = 'login.html';
        return;
    }

    try {
        // Busca os dados do perfil atualizado na API Java
        const response = await fetch(`${API_CONFIG.BASE_URL}${API_CONFIG.ENDPOINTS.PERFIL}`, {
            method: 'GET',
            headers: {
                'Authorization': `Bearer ${token}`,
                'Content-Type': 'application/json'
            }
        });

        if (!response.ok) {
            throw new Error('Sessão expirada. Faça login novamente.');
        }

        const user = await response.json();
        renderUserProfile(user);

    } catch (error) {
        // console.error('Erro na requisição /perfil:', error);
        
        // const localUser = JSON.parse(localStorage.getItem('userData') || '{}');
        // if (localUser.nome || localUser.email || localUser.name) {
        //     renderUserProfile(localUser);
        // } else {
        //     alert('Sessão expirada. Redirecionando para login.');
        //     localStorage.clear();
        //     window.location.href = 'login.html';
        // }

        console.error('Erro na requisição /perfil:', error);

    }
});

function renderUserProfile(user) {
    const nome = user.nome || user.name || 'Usuário';
    const email = user.email || 'email@naoinformado.com';
    const foto = user.foto || user.photo || user.picture;

    document.getElementById('userName').innerText = nome;
    document.getElementById('userEmail').innerText = email;

    const avatarElement = document.getElementById('userInitial');

    // Se houver URL de foto, renderiza a imagem; caso contrário, exibe a inicial
    if (foto) {
        avatarElement.innerHTML = `<img src="${foto}" alt="${nome}" style="width: 100%; height: 100%; border-radius: 50%; object-fit: cover;">`;
    } else {
        avatarElement.innerText = nome.charAt(0).toUpperCase();
    }
}

// Botão de Logout
document.getElementById('logoutBtn').addEventListener('click', function() {
    localStorage.clear();
    window.location.href = 'login.html';
});