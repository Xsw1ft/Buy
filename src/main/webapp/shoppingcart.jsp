<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width,initial-scale=1,user-scalable=no">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="css/quan.min.css" />
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript" src="js/cartcount.js"></script>
<script type="text/javascript" >
	function remove(id){
		var b = confirm("确定移除该物品吗？");
		if(b==true){
			$("#R"+id).attr('href',"/buy/removeFromCart.do?cid="+id);
		}
	}
	
</script>
<title>BUY Demo</title>
</head>

<body>
	<div class="container-fluid">
		<div class="row">
			<div class="span12">
				<!--
                    	作者：1085908971@qq.com
                    	时间：2017-11-30
                    	描述：header
                    -->
				<div class="row-fluid">
					<div class="span12 quan_header">
						<span class="quan_title">
								购物车
						</span>
					</div>
				</div>
				<!--
                    	作者：1085908971@qq.com
                    	时间：2017-11-30
                    	描述：主页面
                    -->
				<div class="row-fluid quan_main">
					<div class="span12">

						<!--
                            	作者：1085908971@qq.com
                            	时间：2017-12-05
                            	描述：购物车
                            -->
						<div class="quan_commodity">
							<c:forEach items="${cart }" var="c">
								<div class="quan_commodity_div row-fluid">
									<div class="span12">
										<div class="col-xs-3">
											<img src="${c.commodityImgsrc }" class="quan_commodity_img" />
										</div>
										<div class="col-xs-9">
											<div class="quan_commodity_detail">
												<span class="quan_commodity_name">${c.commodityName }</span>
												<span class="quan_commodity_price">${c.commodityPrice }￥</span>
												<span class="quan_commodity_describe">${fn:substring(c.commodityDescribe, 0, 12) }...</span>
												<span class="quan_commodity_stock">库存:${c.commodityStock }</span>
												<span class="quan_commodity_seller">卖家：${c.sellerName}</span>
												<div class="quan_commodity_count">
													<a> <img src="img/pluss.png"
														class="quan_commodity_plus"
														onclick="tPlus('T${c.commodityId}','${c.commodityStock}')" />
													</a> <span class="quan_commodity_count_span"
														id="T${c.commodityId }">0</span> <a> <img
														src="img/minuss.png" class="quan_commodity_minus"
														onclick="tMinus('T${c.commodityId}')" />
													</a>
												</div>
												<a  class="btn btn-default btn-sm quan_commodity_delete" onclick="remove('${c.commodityId }')" id="R${c.commodityId }">移除</a>
											</div>
										</div>
									</div>
								</div>
							</c:forEach>
							<br><br><br><br>
						</div>
						<!--
                            	作者：1085908971@qq.com
                            	时间：2017-12-05
                            	描述：购物车footer
                            -->
						<div class="quan_cart_footer">
							<input type="button" class="quan_cart_pay" onclick="checkNum();" value="付款">
							<input type="hidden" id="cartlist" value="${cartIds }" />
							<form action="payconfirm.do" method="post" id="myForm">
								<input type="hidden" name="params" id="params" value="" />
								<input type="submit" value="" hidden="true"/>
							</form>
						</div>
					</div>
					<div class="quan_main_bottom"></div>
				</div>
				<!--
                    	作者：1085908971@qq.com
                    	时间：2017-11-30
                    	描述：footer
                    -->
				<div class="row-fluid quan_footer">
					<div class="span12">
						<a href="index.do">
							<div class="quan_footer_home">
								<img src="img/home1.png" height="28px" width="28px" /><br>
								首页
							</div>
						</a> <a href="shop.do">
							<div class="quan_footer_shop">
								<img src="img/shop1.png" height="28px" width="28px" /><br>
								商家
							</div>
						</a> <a href="shoppingcart.do">
							<div class="quan_footer_shopping_cart quan_footer_top_border">
								<img src="img/cart2.png" height="28px" width="28px" /><br>
								购物车
							</div>
						</a> <a href="my.do">
							<div class="quan_footer_my">
								<img src="img/my1.png" height="28px" width="28px" /><br>
								我的
							</div>
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>