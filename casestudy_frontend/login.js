document.addEventListener("DOMContentLoaded", function () {
    const loginForm = document.querySelector("form[action='/login']");
    const errorMessageBox = document.querySelector(".error-message");

    loginForm.addEventListener("submit", function (event) {
        event.preventDefault();

        const formData = new FormData(loginForm);
        const username = formData.get("username");
        const password = formData.get("password");

        // Send a POST request to the /login endpoint
        fetch(`http://localhost:8090/user/${username}`, {
            method: "GET"
        })
        .then(response => response.json())
        .then(user => {
            if (username==user.username && password==user.password) {
                // Authentication successful, redirect to the product-listing page
                window.location.href = "products.html"; 
            } else {
                // Authentication failed, display an error message
                window.alert("Incorrect password!");
            }
        })
        .catch(error => {
            window.alert("Invalid username!")
            console.error("Error during login:", error)});
        
    });
});
