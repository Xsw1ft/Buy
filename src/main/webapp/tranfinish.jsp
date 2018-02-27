<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no">
		<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
		<link rel="stylesheet" type="text/css" href="css/quan.min.css" />
		<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
		<script type="text/javascript" src="js/bootstrap.js"></script>
		<script type="text/javascript">
			function see(id){
				$("#tran"+id).animate({height:'270px'},300);
				$("#tosee"+id).hide();
				$("#bot"+id).fadeIn(250);
				$("#tonosee"+id).show();
			}
					
			function nosee(id){
				$("#tran"+id).animate({height:'60px'},300);
				$("#tosee"+id).show();
				$("#bot"+id).fadeOut(250);
				$("#tonosee"+id).hide();
			}
			function finish(id){
				var x = confirm("确定要完成订单吗？");
				if(x==true){
					$("#F"+id).attr("href","finishtran.do?tid="+id);
				}
			}
		</script>
		<title>BUY Demo</title>
	</head>

	<body>
		
		
		<div class="row-fluid">
						<div class="span12 quan_header">
							<span class="quan_title">
								未完成的订单
							</span>
						</div>
					</div>
			<div class="quan_tran_main">
				<c:forEach items="${transactionList }" var="t">
				<div class="quan_tran_div" id="tran${t.transactionId }">
					<div class="quan_tran_commodity">
						
							<img src="${t.commodity.commodityImgsrc }" class="quan_tran_commodity_img"/>
							<span class="quan_tran_commodity_name">
								${t.commodity.commodityName }
							</span>
							<span class="quan_tran_commodity_describe">
								${fn:substring(t.commodity.commodityDescribe,0,10) }￥
							</span>
							<span class="quan_tran_commodity_price">
								${t.commodity.commodityPrice }
							</span>
							<a href="${t.commodity.commodityHtmlsrc }" class="quan_tran_commodity_href">
								<font color="#1E90FF">进入商品页</font>
							</a>
							<span class="quan_tran_commodity_detail" id="tosee${t.transactionId }" onclick="see(${t.transactionId });">
								查看详细
							</span><span class="quan_tran_commodity_detail" id="tonosee${t.transactionId }" onclick="nosee(${t.transactionId });" hidden="true">
								收起详细
							</span>
					</div>
					<div class="quan_tran_bot" id="bot${t.transactionId }" hidden="true">
						<span class="quan_tran_id">
						交易流水ID:${t.transactionId }
					</span>
					<span class="quan_tran_seller">
						卖家：${t.transactionSellerName }
					</span>
					<span class="quan_tran_money">
						交易金额：${t.transactionMoney }￥
					</span>
					<span class="quan_tran_num">
						交易个数：${t.transactionNum }
					</span>
					<span class="quan_tran_mode">
						交易方式：${t.transactionMode }
					</span>
					<span class="quan_tran_words">
						买家留言：${fn:substring(t.transactionWords, 0, 28) }
					</span>
					<span class="quan_tran_paytime">
						付款时间：${t.transactionPaytime }
					</span>
					
					<a class="btn btn-sm bg-success quan_tran_finish" onclick="finish(${t.transactionId })" id="F${t.transactionId }">完成订单</a>
					<a href="" class="btn btn-sm bg-danger quan_tran_tui">申请退款(暂不可用)</a>
					</div>
				</div>
				</c:forEach>
				
				<br /><br />
				<br />
			</div>
			<div class="row-fluid quan_footer">
						<div class="span12">
							<a href="index.do">
								<div class="quan_footer_home">
									<img src="img/home1.png" height="28px" width="28px" /><br> 首页
								</div>
							</a>
							<a href="shop.do">
								<div class="quan_footer_shop">
									<img src="img/shop1.png" height="28px" width="28px" /><br> 商家
								</div>
							</a>
							<a href="shoppingcart.do">
								<div class="quan_footer_shopping_cart">
									<img src="img/cart1.png" height="28px" width="28px" /><br> 购物车
								</div>
							</a>
							<a href="my.do">
								<div class="quan_footer_my quan_footer_top_border">
									<img src="img/my2.png" height="28px" width="28px" /><br> 我的
								</div>
							</a>
						</div>
					</div>
		
	</body>

</html>