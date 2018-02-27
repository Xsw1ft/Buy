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
				$("#tran"+id).animate({height:'130px'},300);
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
			
		</script>
		<title>BUY Demo</title>
	</head>

	<body>
		
		
		<div class="row-fluid">
						<div class="span12 quan_header">
							<span class="quan_title">
								在售商品
							</span>
						</div>
					</div>
			<div class="quan_tran_main">
				<c:forEach items="${commodityList }" var="c">
				<div class="quan_tran_div" id="tran${c.commodityId }">
					<div class="quan_tran_commodity">
							<img src="${c.commodityImgsrc }" class="quan_tran_commodity_img"/>
							<span class="quan_tran_commodity_name">
								商品名:${c.commodityName }
							</span>
							<span class="quan_tran_commodity_describe">
								描述:${fn:substring(c.commodityDescribe,0,10) }
							</span>
							<span class="quan_tran_commodity_price">
								单价:${c.commodityPrice }
							</span>
							<a href="${c.commodityHtmlsrc }" class="quan_tran_commodity_href">
								<font color="#1E90FF">进入商品页</font>
							</a>
							<span class="quan_tran_commodity_detail" id="tosee${c.commodityId }" onclick="see(${c.commodityId });">
								查看详细
							</span><span class="quan_tran_commodity_detail" id="tonosee${c.commodityId }" onclick="nosee(${c.commodityId });" hidden="true">
								收起详细
							</span>
					</div>
					<div class="quan_edit_bot" id="bot${c.commodityId }" hidden="true">
					<span class="quan_edit_stock">
						库存：${c.commodityStock }件
					</span>
					
					<a href="editpage.do?cid=${c.commodityId }" class="btn btn-sm bg-success quan_edit_edit">编辑商品</a>
					<a href="cdown.do?cid=${c.commodityId }" class="btn btn-sm bg-danger quan_edit_cancel">商品下架</a>
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