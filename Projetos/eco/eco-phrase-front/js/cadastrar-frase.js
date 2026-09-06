const form = document.getElementById("phrase-form");

const successMessage = document.getElementById("success-message");
const errorMessage = document.getElementById("error-message");


form.addEventListener("submit", async function (event) {

    event.preventDefault();

    const text = document.getElementById("text").value;
    const author = document.getElementById("author").value;
    const origin = document.getElementById("origin").value;


    const token = localStorage.getItem("authToken");

    if (!token) {

        errorMessage.textContent =
            "Você precisa estar logado para cadastrar uma frase.";

        errorMessage.style.display = "block";

        return;
    }


    try {

        const response = await fetch(
            API_CONFIG.BASE_URL + "/frase",
            {
                method: "POST",

                headers: {
                    "Content-Type": "application/json",
                    "Authorization": "Bearer " + token
                },

                body: JSON.stringify({
                    text: text,
                    author: author,
                    origin: origin
                })
            }
        );

        console.log("STATUS:", response.status);
        console.log("STATUS TEXT:", response.statusText);

        const responseText = await response.text();

        console.log("RESPOSTA DO BACKEND:", responseText);


        if (!response.ok) {
            throw new Error(
                `Erro HTTP ${response.status}: ${responseText}`
            );
        }


        successMessage.style.display = "block";
        errorMessage.style.display = "none";

        form.reset();


    } catch (error) {

        console.error("ERRO:", error);

        errorMessage.textContent =
            "Não foi possível cadastrar a frase.";

        errorMessage.style.display = "block";
        successMessage.style.display = "none";
    }

});