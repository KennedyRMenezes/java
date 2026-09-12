document.addEventListener('DOMContentLoaded', function () {

    const token = localStorage.getItem('authToken');

    // Usuário não está logado
    if (!token) {
        return;
    }

    // Mostra a seção de frases para revisão
    document
        .getElementById('review-section')
        .style.display = 'block';

    // Informa que estamos na página inicial
    window.isHomePage = true;

    // Busca somente as frases que precisam ser revisadas
    carregarFrases('/frases/para_revisar');

});
