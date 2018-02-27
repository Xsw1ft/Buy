<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no">
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="css/quan.min.css" />
		<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
		<script type="text/javascript" src="js/bootstrap.js"></script>
		<script type="text/javascript" src="js/shoppingcart.js"></script>
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
								商家列表
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
                            <c:forEach items="${ sellerList}" var="s">
                            <a href="/buy/intoshop.do?id=${s.sellerId }">
								<div class="quan_shop">
									<div class="quan_shop_div">
										<img class="quan_shop_img" src="${s.sellerImgsrc }"/>
										<div class="quan_shop_right">
											<span class="quan_shop_shopname">
												${s.sellerName }
											</span>
											<span class="quan_shop_mainsell">
												主营：${s.sellerSellInfo }
											</span>
										</div>
									</div>
								</div>
							</a>
							</c:forEach>
							<br><br><br><br>
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
									<img src="img/home1.png" height="28px" width="28px" /><br> 首页
								</div>
							</a>
							<a href="shop.do">
								<div class="quan_footer_shop quan_footer_top_border">
									<img src="img/shop2.png" height="28px" width="28px" /><br> 商家
								</div>
							</a>
							<a href="shoppingcart.do">
								<div class="quan_footer_shopping_cart">
									<img src="img/cart1.png" height="28px" width="28px" /><br> 购物车
								</div>
							</a>
							<a href="my.do">
								<div class="quan_footer_my">
									<img src="img/my1.png" height="28px" width="28px" /><br> 我的
								</div>
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>

</html>