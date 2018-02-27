<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width,initial-scale=1,user-scalable=no">
<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="css/quan.min.css" />
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript" src="js/admin-ajax.js"></script>
<title>BUY Demo</title>
</head>

<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">管理员</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">

				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">待审核商家</a></li>

				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>


	<table class="table table-striped">
		<thead>
			<tr>
				<th>ID</th>
				<th>商家名</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${applyerList }" var="a">
				<tr>
					<td>${a.sellerId }</td>
					<td>${a.sellerName }</td>
					<td>
						<button type="button" id="verify" class="btn btn-primary"
							data-toggle="modal" data-target="#applyModal"
							onclick="getListAjax('${a.sellerId }');">审核</button>

					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<!-- -->
	<div class="modal fade" id="applyModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">商户详情</h4>
				</div>
				<div class="modal-body">
					<div class="row-fluid">
						<div class="col-xs-12">
							<span>商户名：</span>
						</div>
						<div class="col-xs-12">
							<input type="text" id="name" class="form-control"/>
						</div>
						<div class="col-xs-12">
							<span>经营范围：</span>
						</div>
						<div class="col-xs-12">
							<input type="text" id="sellinfo" class="form-control" />
						</div>
						<div class="col-xs-12">
							<span>地址：</span>
						</div>
						<div class="col-xs-12">
							<input type="text" id="addr" class="form-control" />
						</div>
						<div class="col-xs-12">
							<span>联系方式：</span>
						</div>
						<div class="col-xs-12">
							<input type="text" id="contactinfo" class="form-control" />
						</div>
						<div class="col-xs-12">
							<span>头像：</span>
						</div>
						<div class="col-xs-12">
							<br> <img src="" id="headimg" class="img-responsive"
								alt="Responsive image" />
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<a href="" id="disagree" class="btn btn-danger">审核不通过</a>
					<a type="" id="agree" class="btn btn-primary">审核通过</a>
				</div>
			</div>
		</div>
	</div>
</body>

</html>