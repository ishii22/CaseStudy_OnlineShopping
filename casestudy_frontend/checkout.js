document.addEventListener("DOMContentLoaded", function () {
    const checkoutForm = document.getElementById("checkout-form");
    const totalAmountSpan = document.getElementById("total-amount");

    // Fetch the total order amount from the server when the page loads
    fetch("http://localhost:8090/cart/getTotalAmount")
        .then(response => response.json())
        .then(totalAmount => {
            totalAmountSpan.textContent = totalAmount.toFixed(2);
        })
        .catch(error => console.error("Error fetching total order amount:", error));
});


// When the user confirms the order, create an order record in the database and clear the cart.
function placeOrder() {
    const username = document.getElementById("username").value;
    const email = document.getElementById("email").value;
    const address = document.getElementById("address").value;
    const totalAmount = document.getElementById("total-amount").textContent;

    console.log(username);
    console.log(email);
    console.log(address);
    console.log(totalAmount);
    var raw = JSON.stringify({
        "username": username,
        "email": email,
        "address": address,
        "totalAmount": totalAmount
      });
      console.log(raw);

    

    // Send a request to the server to place the order
    fetch("http://localhost:8090/orders", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: raw
    })
    .then(response => {
        if (response.ok) {
            window.alert("Order Successful!");
            // Order placed successfully, clear the cart 
            clearCart();
        } else {
            console.error("Error placing order:", response.statusText);
        }
    })
    .catch(error => console.error("Error placing order:", error));
}

function clearCart() {
    // Send a request to the server to clear the cart
    fetch("http://localhost:8090/cart", {
        method: "DELETE"
    })
    .then(response => {
        if (!response.ok) {
            console.error("Error clearing the cart:", response.statusText);
        }
    })
    .catch(error => console.error("Error clearing the cart:", error));
}
