function tPlus(cId,max){
	var nowCount = parseInt(document.getElementById(cId).innerHTML);
	if(nowCount != parseInt(max))
		document.getElementById(cId).innerHTML = nowCount + 1;
	else
		document.getElementById(cId).innerHTML = max;
	//count();
}


function tMinus(cId){
	var nowCount = parseInt(document.getElementById(cId).innerHTML);
	if( nowCount > 0)
		document.getElementById(cId).innerHTML = nowCount - 1;
	else
		document.getElementById(cId).innerHTML = 0;
	//count();
}
//
//function count(){
//	var num = document.getElementById("num").value;
//	
//}

function checkNum(){
	var json = [];
	var carts = document.getElementById("cartlist").value.split(",");
	for( i=0 ;i<carts.length-1 ;i++){
		var selected = document.getElementById("T"+carts[i]).innerHTML;
		var row = {};
		row.id=""+carts[i];
		row.select=""+selected;
		json.push(row);
	}
	document.getElementById("params").value = JSON.stringify(json);
	document.getElementById("myForm").submit();
}