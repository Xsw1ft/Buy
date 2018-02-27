<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no">
		<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
		<link rel="stylesheet" type="text/css" href="css/quan.min.css" />
		<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
		<script type="text/javascript" src="js/bootstrap.js"></script>
		<title>BUY Demo</title>
	</head>

	<body>
		
		
		<table class="table table-striped">
				<thead>
					<tr>
						<th>
							品名
						</th>
						<th>
							${who }
						</th>
						<th>
							当前状态
						</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${transactionSimpleList}" var="t">
					<tr>
						<td>
							${t.commodityName }
						</td>
						<td>
							${t.sellerName} 
						</td>
						<td>
							${t.status} 
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
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