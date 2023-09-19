
$(document).ready(function() {
    $.ajax({
        url: 'http://localhost:8090/products',
        type: 'GET',
        dataType: 'json',
        success: function(products) {
            // Iterate through the products and display them
            products.forEach(function(product) {
                $('#product-list').append(
                    '<div class="product">' +
                    '<h2>' + product.productName + '</h2>' +
                    '<p>Price: $' + product.productPrice + '</p>' +
                    '<p>Description: ' + product.productDesc + '</p>' +
                    '<p>Category: ' + product.productCategory + '</p>' +
                    '<p>Rating: ' + product.productRating + '</p>' +
                    '<button onclick="addToCart(' + product.productId + ')">Add to Cart</button>' +
                    '</div>'
                );
            });
        }
    });
});

// document.addEventListener("DOMContentLoaded", function () {
//     // Fetch product data from the backend using RESTful API
//     fetch("http://localhost:8090/products")
//         .then(response => response.json())
//         .then(products => {
//             const productList = document.getElementById("product-list");
//             products.forEach(product => {
//                 const productDiv = document.createElement("div");
//                 productDiv.className = "product";
//                 productDiv.innerHTML = `
//                 <h2>${product.productName}</h2>
//                 <p>Price: $${product.productPrice}</p>
//                 <p>Category: ${product.productCategory}</p>
//                 <p>Rating: ${product.productRating}</p>
//                 <button onclick="addToCart(${product.id})">Add to Cart</button>
//                 `;
//                 productList.appendChild(productDiv);
//             });
//         })
//         .catch(error => console.error("Error fetching product data:", error));
// });

// function addProduct(productId){
    
//     let options = {
//         method: "POST",
//         headers: {
//             "Content-type": "application/json"
//         },
//         body: JSON.stringify({
//             prodId:productId,
//             quantity:1
//         }),
//     }

//     fetch('http://localhost:4040/cart',options)
//     .then((response) => response.json())
//     .then((json) => console.log(json));
// }

// function removeProduct(productId){
    
//     const pId = productId;
//     let options = {
//         method: "DELETE",
//         headers: {
//             "Content-type": "application/json"
//         },
//     }
//     fetch(`http://localhost:4040/cart/${pId}`,options)
//     .then((response) => response.json())
//     .then((json) => console.log(json));
// }