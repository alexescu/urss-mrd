var hours = ["8", "9", "10"];

function highlightRow(){
	var size = document.getElementById("myTable").rows.length;
	for (var i=0; i< size; i++){
		if (hours[i] == h){
			document.getElementById("myTable").rows[i].style.backgroundColor = "#D93600";
		}
	}
}