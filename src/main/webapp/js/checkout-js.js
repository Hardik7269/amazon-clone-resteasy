// Define urlParams as a global variable
var urlParams;

function generateDivOnLoad(){
    // Parse the URL to get the query parameters
    const queryString = window.location.search;
    urlParams = new URLSearchParams(queryString);

    // Get the values of q1, q2, and q3 from the query parameters
    const q1 = urlParams.get('q1');
    const q2 = urlParams.get('q2');
    const q3 = urlParams.get('q3');

    // Use the values as needed
    console.log(q1, q2, q3);
    if(q1 != 0){
        var pName = "Samsung Galaxy S23 Ultra 5G (12GB, 512GB Storage)";
        var pPrice = "₹1,40,000";
        var image = "Images/box2_image.jpg";

        genDiv(q1 , pName , pPrice , image);
    }
    if(q2 != 0){
        var pName = "Curved Ultragear™ Dual QHD Gaming Monitor";
        var pPrice = "₹ 90,000";
        var image = "Images/box3_image.jpg";

        genDiv(q2 , pName , pPrice , image);
    }
    if(q3 != 0){
        var pName = "Apple iPhone 14 Pro Max (256 GB) - Deep Purple";
        var pPrice = "₹1,43,990";
        var image = "Images/box4_image.jpg";

        genDiv(q3 , pName , pPrice , image);
    }
 
}

function genDiv(quantity , name , price , image){
    console.log("hello");
    // Create a new div element
    var container = document.getElementById("generateOrderSummary");

    var newDiv = document.createElement("div");
    //newDiv.className = "cart-item-container";

    // Construct the inner HTML of the new div
    newDiv.innerHTML = `<div class="cart-item-container">
    <div class="delivery-date">
        Delivery date: Tuesday, June 21
    </div>
    <div class="cart-item-details-grid">
        <img class="product-image" src=${image}>

        <div class="cart-item-details" id="cartItemDetailsContainer">
            <div class="product-name" id = "product-samsung-mobile">
            ${name}
            </div>
            <div class="product-price">
            ${price}
            </div>
            <div class="product-quantity">
                <span>
                    Quantity: <span class="quantity-label">${quantity}</span>
                </span>
                <span class="update-quantity-link link-primary">
                    Update
                </span>
                <span class="delete-quantity-link link-primary">
                    Delete
                </span>
            </div>
        </div>
    </div>
</div>
`;

    // Append the new div to the order-summary div
    if (container !== null) {
        container.appendChild(newDiv);
    }
    
}

function buyAllProducts() {
    var q11 = urlParams.get('q1');
    var q21 = urlParams.get('q2');
    var q31 = urlParams.get('q3');

    const url = `http://localhost:8080/Amazon.com/p/addAllProduct?q1=${q11}&q2=${q21}&q3=${q31}`;
    window.location.href = url;
}



