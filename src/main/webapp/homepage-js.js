function upPrItems() {
    let pName = removeWhitespace(prompt("Enter New Product Name:", ""));
    let pPrice = parseFloat(prompt("Updated Price:", ""));
    const pid = parseInt(prompt("Enter Pid:", ""));
    let q = parseInt(prompt("Updated Quantity:", ""));
    console.log(pName + "-" + pPrice + "-" + pid + "-" + q);
	console.log("");
    const url = "http://localhost:8080/RestProject02/p/updateData?id="+pid+"&name="+pName+"&price="+pPrice+"&quantity="+q;
    console.log(url);
    window.open(url);
 
}

function removeProduct(){
	const pid = parseInt(prompt("Enter Pid to delete:", ""));
	const url = "http://localhost:8080/RestProject02/p/removeProduct?id="+pid;
	console.log(url);
	window.open(url);
}





function cartQuantity(){
    let q1 = JSON.parse (document.querySelector('.quantity1').value);
    let q2 = JSON.parse ( document.querySelector('.quantity2').value);
    let q3 = JSON.parse ( document.querySelector('.quantity3').value);

    let total = (q1+q2+q3);
    console.log(typeof(total));
    document.querySelector('.cart-quantity-num').innerHTML = `${total}`;
}


function product1(){
	let pName = document.querySelector('.samsungMobile').innerHTML;
	let pPrice =document.querySelector('.p1Price').innerHTML;
    let q = JSON.parse (document.querySelector('.quantity1').value);
    
    
    pName = removeWhitespace(pName);
    pPrice = removeWhitespace(pPrice);
	let price = convertPrice(pPrice);
 
   const url = "http://localhost:8080/RestProject02/p/addToCart?name="+pName+"&price="+price+"&quantity="+q;
   
	window.open(url);       
}

function product2(){
	
	let pName = document.querySelector('.lgTv').innerHTML;
	let pPrice =document.querySelector('.p2Price').innerHTML;
    let q = JSON.parse (document.querySelector('.quantity2').value);
    
    
    pName = removeWhitespace(pName);
    pPrice = removeWhitespace(pPrice);
	let price = convertPrice(pPrice);
 
   const url = "http://localhost:8080/RestProject02/p/addToCart?name="+pName+"&price="+price+"&quantity="+q;

	window.open(url);  
}


function product3(){
	
	let pName = document.querySelector('.iphoneMobile').innerHTML;
	let pPrice =document.querySelector('.p3Price').innerHTML;
    let q = JSON.parse (document.querySelector('.quantity3').value);
    
    
    pName = removeWhitespace(pName);
    pPrice = removeWhitespace(pPrice);
	let price = convertPrice(pPrice);
 
    const url = "http://localhost:8080/RestProject02/addToCart?name="+pName+"&price="+price+"&quantity="+q;

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





