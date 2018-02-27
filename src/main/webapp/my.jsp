<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
								个人中心
						</span>
					</div>
				</div>
				<!--
                    	作者：1085908971@qq.com
                    	时间：2017-11-30
                    	描述：主页面
                    -->
				${userInfo}
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
							<div class="quan_footer_shopping_cart">
								<img src="img/cart1.png" height="28px" width="28px" /><br>
								购物车
							</div>
						</a> <a href="my.do">
							<div class="quan_footer_my quan_footer_top_border">
								<img src="img/my2.png" height="28px" width="28px" /><br>
								我的
							</div>
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Login -->
	<div class="modal fade" id="loginModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">登录</h4>
				</div>
				<form action="login.do" method="post">
					<div class="modal-body">
						<div class="row-fluid">
							<div class="col-xs-3">
								<span>学号：</span>
							</div>
							<div class="col-xs-9">
								<input type="text" name="uid" placeholder="请输入学号..."
									class="form-control" />
							</div>
							<br> <br>
							<div class="col-xs-3">
								<span>密码：</span>
							</div>
							<div class="col-xs-9">
								<input type="password" name="upw"
									placeholder="请输入密码..." class="form-control" />
							</div>
						</div>
						<br> <br>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<input type="submit" class="btn btn-primary" value="登录">
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- sellerLogin -->
		<div class="modal fade" id="sellerLoginModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h4 class="modal-title" id="myModalLabel">登录</h4>
					</div>
					<form action="sellerlogin.do" method="post">
					<div class="modal-body">
						<div class="row-fluid">
							<div class>
								<span>商家名：</span>
							</div>
							<div>
								<input type="text" name="sn" placeholder="请输入商家名..." class="form-control" />
							</div>
							<div>
								<span>密码：</span>
							</div>
							<div>
								<input type="password" name="spwd"placeholder="请输入密码..." class="form-control"/>
							</div>
						</div>
						<br><br>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<input type="submit" class="btn btn-primary" value="登录"/>
					</div>
					</form>
				</div>
			</div>
		</div>
	<!-- regist -->
	<div class="modal fade" id="registModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">注册商户</h4>
				</div>
				<form action="sellerregist.do" method="post" enctype="multipart/form-data">
					<div class="modal-body">
						<div class="row-fluid">
							<div>
								<span>商户名：</span>
							</div>
							<div>
								<input type="text" name="sname"
									placeholder="请输入商家名..." class="form-control" />
							</div>
							<div>
								<span>密码：</span>
							</div>
							<div>
								<input type="password" name="spwd"
									placeholder="请输入密码..." class="form-control" />
							</div>
							<div>
								<span>确认密码：</span>
							</div>
							<div>
								<input type="password" name=""
									placeholder="请再次确认密码..." class="form-control" />
							</div>
							<div>
								<span>经营范围：</span>
							</div>
							<div>
								<input type="text" name="ssell"
									placeholder="经营范围..." class="form-control" />
							</div>
							<div>
								<span>地址：</span>
							</div>
							<div>
								<input type="text" name="saddr"
									placeholder="店铺地址..." class="form-control" />
							</div>
							<div>
								<span>联系方式：</span>
							</div>
							<div>
								<input type="text" name="scontact" id="userName"
									placeholder="手机或微信等等..." class="form-control" />
							</div>
							<div>
								<span>上传头像：</span>
							</div>
							<div>
								<input name="sellerimg" type="file" accept="image" />
							</div>
						</div>

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<input type="submit" class="btn btn-primary" value="点击注册">
					</div>
				</form>
			</div>
		</div>
	</div>
</body>

</html>