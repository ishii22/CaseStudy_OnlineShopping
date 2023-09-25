// To display the list of products
document.addEventListener("DOMContentLoaded", function () {
    // Fetch product data from the backend using RESTful API
    fetch("http://localhost:8090/products")
        .then(response => response.json())
        .then(products => {
            const productList = document.getElementById("product-list");
            products.forEach(product => {
                const productDiv = document.createElement("div");
                productDiv.className = "product";
                productDiv.innerHTML = `
                <h2>${product.productName}</h2>
                <p>Price: $${product.productPrice}</p>
                <p>Category: ${product.productCategory}</p>
                <p>Rating: ${product.productRating}</p>
                <button onclick="addProductToCart(${product.productId})">Add</button>
                <button onclick="removeProductFromCart(${product.productId})">Remove</button>
                `;
                productList.appendChild(productDiv);
            });
        })
        .catch(error => console.error("Error fetching product data:", error));
});

// Add a product into the cart
function addProductToCart(productId){

    var myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    var raw = JSON.stringify({
        "productId": productId,
        "quantity": 1
    });

    var requestOptions = {
        method: 'POST',
        headers: myHeaders,
        body: raw,
        redirect: 'follow'
    };

    fetch("http://localhost:8090/cart", requestOptions)
        .then(response => response.text())
        .then(result => console.log(result))
        .catch(error => console.log('error', error));

        // add success message
}

function removeProductFromCart(productId){

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

// -----------------------------------------------------------
// Search Functionality

function searchProducts(event){
    event.preventDefault();
    const searchQueryInput = document.getElementById("search-query");
    const query = searchQueryInput.value.trim();

    // Send a request to the server to perform the search
    fetch(`http://localhost:8090/products/${query}`)
        .then(response => response.json())
        .then(products => {
            console.log("searching");
            console.log(products);
            displaySearchResults(products);
            
        })
        .catch(error => console.error("Error performing search:", error));
}



    function displaySearchResults(products) {
        const searchResultsDiv = document.getElementById("search-results");
        const productListing = document.getElementById("product-listing");
        const productList = document.getElementById("product-list");
        productListing.remove();
        productList.remove();
        searchResultsDiv.innerHTML = "";
        

        if (products.length === 0) {
            searchResultsDiv.innerHTML = "<p>No products found.</p>";
        } else {


            // const productList = document.getElementById("product-list");
            products.forEach(product => {
                const productDiv = document.createElement("div");
                productDiv.className = "product";
                productDiv.innerHTML = `
                <h2>${product.productName}</h2>
                <p>Price: $${product.productPrice}</p>
                <p>Category: ${product.productCategory}</p>
                <p>Rating: ${product.productRating}</p>
                <button onclick="addProductToCart(${product.productId})">Add</button>
                <button onclick="removeProductFromCart(${product.productId})">Remove</button>
                `;
                searchResultsDiv.appendChild(productDiv);
        
            });
            
        }
    }
