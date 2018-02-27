$(document).ready(function() {
	$("#paysubmit").click(function() {
		var bool = confirm("确定订单？");
		if(bool == true) {
			var list = $("#paylist").val().split(",");
			var json =[];
			for(var i = 0; i < list.length - 1; i++) {
				var row = {};
				var selected = $("#selected" + list[i]).html();
				var mode = $("#mode" + list[i]).val();
				var words = $("#words" + list[i]).val();
				row.id = list[i] + "";
				row.selected = selected + "";
				row.mode = mode + "";
				row.words = words + "";
				json.push(row);
			}
			$("#paylistjson").val(JSON.stringify(json));
			$("#myForm").submit();
		}
	});
});