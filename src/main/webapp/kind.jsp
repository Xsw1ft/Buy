<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no">
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="css/quan.min.css" />
		<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
		<script type="text/javascript" src="js/bootstrap.js"></script>
		<script type="text/javascript" src="js/cartcount.js"></script>
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

					<!--
                    	作者：1085908971@qq.com
                    	时间：2017-11-30
                    	描述：主页面
                    -->
					<div class="row-fluid quan_main">
						<div class="span12">

							<div class="row-fluid"  style="text-align: center;">
								<div class="span12 quan_header">
									
									<div class="quan_title">"${title }"分类</div>
									
								</div>
								
							</div>
							<!--
                            	作者：1085908971@qq.com
                            	时间：2017-12-05
                            	描述：购物车
                            -->
							<c:forEach items="${commodityList }" var="c">
							<a href="${c.commodityHtmlsrc }">
								<div class="quan_commodity_div row-fluid">
									<div class="span12">
										<div class="col-xs-3">
											<img src="${c.commodityImgsrc }" class="quan_commodity_img" />
										</div>
										<div class="col-xs-9">
											<div class="quan_commodity_detail">
												<span class="quan_commodity_name">${c.commodityName }</span>
												<span class="quan_commodity_price">${c.commodityPrice }￥</span>
												<span class="quan_commodity_describe">${c.commodityDescribe }</span>
												<!-- <span class="quan_commodity_stock">stock:</span> -->
	
											</div>
										</div>
	
									</div>
								</div>
							</a>
							</c:forEach>
						</div>
						<!--
                            	作者：1085908971@qq.com
                            	时间：2017-12-05
                            	描述：购物车footer
                            -->

					</div>
				</div>
				<!--
                    	作者：1085908971@qq.com
                    	时间：2017-11-30
                    	描述：footer
                    -->
					<div class="row-fluid quan_footer">
						<div class="span12">
							<a href="index.do">
								<div class="quan_footer_home quan_footer_top_border">
									<img src="img/home2.png" height="28px" width="28px" /><br> 首页
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