document.addEventListener("DOMContentLoaded", function () {
    loadCartItems();
});

// Display all cart items
function loadCartItems() {
    fetch("http://localhost:8090/cart")
        .then(response => response.json())
        .then(cartItems => {
            const cartItemsContainer = document.getElementById("cart-items");

            cartItemsContainer.innerHTML = ""; // Clear existing items

            cartItems.forEach(cartItem => {
                const product = cartItem.product;
                const row = document.createElement("tr");
                row.innerHTML = `
                    <td >${product.productName}</td>
                    <td >$${product.productPrice.toFixed(2)}</td>
                    <td id="quantity-${cartItem.productId}">${cartItem.quantity}</td>
                    <td >$${(product.productPrice * cartItem.quantity).toFixed(2)}</td>
                    <td ><button onclick="increaseQuantity(${cartItem.productId})">+</button>
                    <button  onclick="decreaseQuantity(${cartItem.productId})">-</button>
                    <button  onclick="removeProductFromCart(${cartItem.productId})">Remove</button></td>
                `;
                row.setAttribute("id",`row-${cartItem.productId}`)
                cartItemsContainer.appendChild(row);
            });

        })
        .catch(error => console.error("Error fetching cart items:", error));
}

// Increase the quantity of an item
function increaseQuantity(cartItemId) {
        // Send a request to increase the quantity of the specified item in the cart
        // Update the UI with the new quantity
        const quantitySpan = document.getElementById(`quantity-${cartItemId}`);
        console.log(quantitySpan);
        const currentQuantity = parseInt(quantitySpan.textContent);
        console.log(currentQuantity);
        const newQuantity = currentQuantity + 1;
        quantitySpan.textContent = newQuantity;
    
        var requestOptions = {
            method: 'PUT',
            redirect: 'follow'
          };
          
          fetch(`http://localhost:8090/cart/increase/${cartItemId}`, requestOptions)
            .then(response => response.text())
            .then(result => console.log(result))
            .catch(error => console.log('error', error));
}

// Decrease the quantity of an item
function decreaseQuantity(cartItemId) {
        // // Send a request to decrease the quantity of the specified item in the cart
        // // Update the UI with the new quantity (ensure it doesn't go below 1)
        const quantitySpan = document.getElementById(`quantity-${cartItemId}`);
        const currentQuantity = parseInt(quantitySpan.textContent);
        const newQuantity = Math.max(currentQuantity - 1, 1);
        quantitySpan.textContent = newQuantity;
    
        var requestOptions = {
            method: 'PUT',
            redirect: 'follow'
          };
          
          fetch(`http://localhost:8090/cart/decrease/${cartItemId}`, requestOptions)
            .then(response => response.text())
            .then(result => console.log(result))
            .catch(error => console.log('error', error));
}


function removeProductFromCart(productId){
    const cartItemDiv = document.getElementById(`row-${productId}`);
    cartItemDiv.remove();

    var myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    var raw = "";

    var requestOptions = {
        method: 'DELETE',
        headers: myHeaders,
        body: raw,
        redirect: 'follow'
    };

    fetch(`http://localhost:8090/cart/${productId}`, requestOptions)
        .then(response => response.text())
        .then(result => console.log(result))
        .catch(error => console.log('error', error));   
    
    // add delete success message
}






