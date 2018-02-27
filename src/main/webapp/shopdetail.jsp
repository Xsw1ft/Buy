<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		<script type="text/javascript">
		$(document).ready(function(){
			$("#top1").hide();
			
				$("#down").click(function(){
					
					$("#top").animate({height:'140px'},300,hide());
					$("#head").animate({height:'96px',width:'96px'},300);
					$("#simple").hide();
				});
				
				$("#up").click(function(){
					$("#head").animate({height:'50px',width:'50px'},300,show());
					$("#top").animate({height:'50px'},300);
					//$("#top1").hide();
					//$("#simple").show();
				});
		});
		opacity:'0.4'
		function hide(){
			//$("#simple").hide();
			$("#top1").fadeIn(300);
		}
		function show(){
			
			//$("#simple").show();
			$('#top1').fadeOut(300);
			$("#simple").fadeIn(300);
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
                    	描述：主页面
                    -->
					<div class="row-fluid quan_main">
						<div class="span12">
							
							<!--
                            	作者：1085908971@qq.com
                            	时间：2017-12-05
                            	描述：购物车
                            -->
                            <div class="quan_shop_main_top" id="top">
                            	<div class="quan_shop_mamin_top_1" id="top1">
                            		<img src="${sellerInfo.sellerImgsrc }" class="quan_shop_main_img" id="head"/>
                            	<div class="quan_shop_main_detail">
                            		
                            		<span class="quan_shop_main_shopname">
                            			店名：${sellerInfo.sellerName}
                            		</span>
                            		<span class="quan_shop_main_domain">
                            			主营：${sellerInfo.sellerSellInfo}
                            		</span>
                            		<span class="quan_shop_main_addr">
                            			地址：${sellerInfo.sellerAddr}
                            		</span>
                            		<span class="quan_shop_main_tel">
                            			联系方式：${sellerInfo.sellerContactInfo}
                            		</span>
                            		<div id="" style="text-align: center;">
                            			<a id="up" class="quan_shop_main_up">收起</a>
                            		</div>
                            		
                            	</div>
                            	</div>
                            
                            </div>
                            <div class="quan_shop_main_top_simple" id="simple">
                            	${sellerInfo.sellerName}
                            	<a id="down" class="quan_shop_main_down">查看详情</a>
                            </div>
                            <div class="quan_shop_main_commodity">
                            	<div style="text-align: center;">
									<span class="quan_on_sell_span">在售商品</span>
								</div>
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
								<br><br><br><br>
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
