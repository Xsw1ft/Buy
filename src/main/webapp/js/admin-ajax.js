function getListAjax(id){
    $.post("getSellerApplyInfo.do",
    {
    	 sellerId:new String(id)
    },
    function(data,status){
    	$("#name").val(data.sellerName);
    	$("#sellinfo").val(data.sellerSellInfo);
    	$("#addr").val(data.sellerAddr);
    	$("#contactinfo").val(data.sellerContactInfo);
    	$("#headimg").attr('src',data.sellerImgsrc);
    	$("#agree").attr('href',"/buy/agreeSeller.do?sellerid="+data.sellerId+"&agree=true");
    	$("#disagree").attr('href',"/buy/agreeSeller.do?sellerid="+data.sellerId+"&agree=false");
    });
}
