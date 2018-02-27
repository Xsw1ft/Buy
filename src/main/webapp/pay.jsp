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
<script type="text/javascript" src="js/pay.js"></script>
<title>BUY Demo</title>
</head>

<body>
	<div class="quan_pay_top">
		<span class="quan_pay_top_buyer"> 联系人：${userInfo.userName } </span> <span
			class="quan_pay_top_addr"> 地址：${userInfo.userAddr } </span> <span
			class="quan_pay_top_contact"> 联系方式：${userInfo.userContactInfo } </span>
	</div>
	<div class="quan_pay_commodity">
		<c:forEach items="${commodityList }" var="c">
			<div class="quan_pay_commodity_div">
				<span class="quan_pay_commodity_div_shopname"> ${ c.sellerName}
				</span>
				<div class="quan_commodity_div_pay row-fluid">
					<div class="span12">
						<div class="col-xs-3">
							<img src="${c.commodityImgsrc }" class="quan_commodity_img_pay" />
						</div>
						<div class="col-xs-9">
							<div class="quan_commodity_detail_pay">
								<span class="quan_commodity_name_pay">${c.commodityName }</span>
								<span class="quan_commodity_price_pay"><span id="P12">${c.commodityPrice }</span>￥</span>
								<span class="quan_commodity_describe_pay">${fn:substring(c.commodityDescribe,0,16) }...</span>
								<span class="quan_commodity_select_pay">已选择：<span id="selected${c.commodityId }">${c.selected }</span>件</span>
							</div>

						</div>

					</div>
				</div>
				<select name="" class="form-control " id="mode${c.commodityId }">
					<option value="1">选择配送方式——默认面提</option>
					<option value="2">邮寄</option>
					<option value="3">当面提货</option>
				</select> <input type="text" id="words${c.commodityId }" value="" placeholder="买家留言"
					class="form-control" /> <span
					class="quan_pay_commodity_div_xiaoji"> 小计：${c.total }￥ </span>
			</div>
		</c:forEach>
		<br /> <br /> <br /> <br /> <br />

	</div>

	<div class="quan_pay_footer">
		<span class="quan_pay_total"> 合计：${alltotal } ￥ </span><a  class="quan_pay_submit" id="paysubmit">
				<font color="white">提交订单</font>
			</a>
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
			</a> <a href="shop.do">
				<div class="quan_footer_shop">
					<img src="img/shop1.png" height="28px" width="28px" /><br> 商家
				</div>
			</a> <a href="shoppingcart.do">
				<div class="quan_footer_shopping_cart quan_footer_top_border">
					<img src="img/cart2.png" height="28px" width="28px" /><br>
					购物车
				</div>
			</a> <a href="my.do">
				<div class="quan_footer_my">
					<img src="img/my1.png" height="28px" width="28px" /><br> 我的
				</div>
			</a>
		</div>
	</div>
	<form action="payfinish.do" method="post" id="myForm">
			<input type="hidden" name="" id="paylist" value="${cArr }" />
			<input type="hidden" name="json" id="paylistjson" value="" />
			<input type="submit" value="" hidden="true"/>
		</form>
</body>

</html>
