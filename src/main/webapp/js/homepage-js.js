function updateProductItem() {
    let pName = removeWhitespace(prompt("Enter New Product Name:", ""));
    let pPrice = parseFloat(prompt("Updated Price:", ""));
    const pid = parseInt(prompt("Enter Pid:", ""));
    let q = parseInt(prompt("Updated Quantity:", ""));
    console.log(pName + "-" + pPrice + "-" + pid + "-" + q);
    const url = "http://localhost:8080/Amazon.com/p/updateData?id="+pid+"&name="+pName+"&price="+pPrice+"&quantity="+q;
    console.log(url);
    window.open(url);
 
}

function removeProduct(){
	const pid = parseInt(prompt("Enter Pid to delete:", ""));
	const url = "http://localhost:8080/Amazon.com/p/removeProduct?id="+pid;
	console.log(url);
	window.open(url);
}

function cartQuantity(){
    let q1 = JSON.parse (document.querySelector('.quantity1').value);
    let q2 = JSON.parse ( document.querySelector('.quantity2').value);
    let q3 = JSON.parse ( document.querySelector('.quantity3').value);

    let total = (q1+q2+q3);
    document.querySelector('.cart-quantity-num').innerHTML = `${total}`;
}

function addToCart(event) {
    let box = event.target.closest('.box-content');
    if (!box) return;

    let pName = box.querySelector('.product-name').innerHTML;
    let pPrice = box.querySelector('.product-price').innerHTML;
    let pQuantity = JSON.parse(box.querySelector('.product-quantity-container select').value);

    pName = removeWhitespace(pName);
    pPrice = removeWhitespace(pPrice);
    let price = convertPrice(pPrice);
    
	callUrl(pName , price , pQuantity);
}
function callUrl(pName ,price , pQuantity){
	const url = "http://localhost:8080/Amazon.com/p/addToCart?name=" + pName + "&price=" + price + "&quantity=" + pQuantity;
    window.open(url);
}

function removeWhitespace(str) {
  return str.split(' ').filter(Boolean).join('');
}

function convertPrice(str){
	const cleanMoney = str.replace(/[₹,]/g,'');
	let price = parseInt(cleanMoney);
	
	return price;
}

function generateDiv() {
    let q1 = document.getElementById("q1").value;
    let q2 = document.getElementById("q2").value;
    let q3 = document.getElementById("q3").value;

    let url = `http://localhost:8080/Amazon.com/checkout.html?q1=${q1}&q2=${q2}&q3=${q3}`;
    window.open(url, "_blank");
}


