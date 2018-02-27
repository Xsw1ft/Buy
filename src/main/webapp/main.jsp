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
					<div class="row-fluid quan_header">
						<a href="search.html" class="quan_header_search">搜索</a>
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
                            	时间：2017-11-30
                            	描述：banner
                           -->
							<!-- 轮播（Carousel）容器 -->
							<div id="myCarousel" class="carousel slide quan_banner_slider">
								<!-- 轮播（Carousel）指标 -->
								<ol class="carousel-indicators">
									<li style="margin-left:20px;" data-target="#myCarousel" data-slide-to="0" class="active"></li>
									<li style="margin-left:20px;" data-target="#myCarousel" data-slide-to="1"></li>
									<li style="margin-left:20px;" data-target="#myCarousel" data-slide-to="2"></li>
								</ol>
								<!-- 轮播（Carousel）项目 -->
								<div class="carousel-inner">
									<div class="item active banner_div">
										<img class="carouselimg" src="img/banner1.jpg" alt="First slide" width="100%">
									</div>
									<div class="item banner_div">
										<img class="carouselimg" src="img/banner2.jpg" alt="Second slide" width="100%">
									</div>
									<div class="item banner_div">
										<img class="carouselimg" src="img/banner3.jpg" alt="Third slide" width="100%">
									</div>
								</div>
								<!-- 轮播（Carousel）导航 -->

								<a class="carousel-control left" href="#myCarousel" data-slide="prev">
									<img src="img/left.png" style="position:absolute;top: 60px;"/>
								</a>

								<a class="carousel-control right" href="#myCarousel" data-slide="next">
									<img src="img/right.png" style="position:absolute;top: 60px;"/>
								</a>
							</div>
							<!--
                            	作者：1085908971@qq.com
                            	时间：2017-12-01
                            	描述：新发布的商品
                            -->
							<div class="quan_classify_div">
								<div class="quan_classify">
									<ul class="quan_ul">
									<a href="kind.do?kind=1"><li class="quan_li"><img src="img/riyong1.png" class="quan_classify_img" width="32px" height="32px"/><span class="quan_classify_span">日用</span></li></a>
									<a href="kind.do?kind=2"><li class="quan_li"><img src="img/yundong1.png" class="quan_classify_img" width="32px" height="32px"/><span class="quan_classify_span">运动</span></li></a>
									<a href="kind.do?kind=3"><li class="quan_li"><img src="img/food1.png" class="quan_classify_img" width="32px" height="32px"/><span class="quan_classify_span">外卖</span></li></a>
									<a href="kind.do?kind=4"><li class="quan_li"><img src="img/shuma1.png" class="quan_classify_img" width="32px" height="32px"/><span class="quan_classify_span">数码</span></li></a>
									<a href="kind.do?kind=5"><li class="quan_li"><img src="img/book1.png" class="quan_classify_img" width="32px" height="32px"/><span class="quan_classify_span">图书</span></li></a>
									<a href="kind.do?kind=6"><li class="quan_li"><img src="img/more1.png" class="quan_classify_img" width="32px" height="32px"/><span class="quan_classify_span">其他</span></li></a>
								</ul>
								</div>
							</div>
							<br/>
							<div class="quan_index_main">
								<div style="text-align: center;">
								<span class="quan_new_publish_span">新品上架</span>
							</div>
							<div class="quan_commodity">
								<c:forEach items="${commodityList }" var="c">
									<a href="${c.commodityHtmlsrc }">
										<div class="quan_commodity_div row-fluid">
											<div class="col-xs-3">
												<img src="${c.commodityImgsrc }" class="quan_commodity_img" />
											</div>
											<div class="quan_commodity_detail col-xs-9">
												<span class="quan_commodity_name">${c.commodityName }</span>
												<span class="quan_commodity_price">${c.commodityPrice }￥</span>
												<span class="quan_commodity_describe">${fn:substring(c.commodityDescribe, 0, 28) }...</span>
												<span class="quan_commodity_seller">卖家：${c.sellerName}</span>
												<div class="quan_commodity_count"></div>
											</div>
										</div>
									</a>
								</c:forEach>
							</div>
							<div class="quan_hot">

							</div>
							<div class="quan_main_bottom"></div>
						</div>
					</div>
					<br/><br/><br/>
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