$(document).ready(
	function (){
		var err = $("#err");
		$("#cname").change(function(){
			var x = $("#cname").val();
			if(x.length >0 && x.length<16){
				err.fadeOut(300);
			}else{
				err.fadeIn(300);
				err.html("商品名格式错误！");
			}
		});
		$("#cdescribe").change(function(){
			var x = $("#cdescribe").val();
			if(x.length >0 && x.length<64){
				err.fadeOut(300);
			}else{
				err.fadeIn(300);
				err.html("商品价格格式错误！");
			}
		});
		$("#cprice").change(function(){
			var x = $("#cprice").val();
			if(x >0.01 && x<9999.99){
				err.fadeOut(300);
			}else{
				err.fadeIn(300);
				err.html("商品描述格式错误！");
			}
		});
		$("#cstock").change(function(){
			var y = $("#cstock").val();
			var x = parseInt(y);
			$("#cstock").val(x);
			if(x >0 && x<10000){
				err.fadeOut(300);
			}else{
				err.fadeIn(300);
				err.html("商品库存格式错误！");
			}
		});
	}
);