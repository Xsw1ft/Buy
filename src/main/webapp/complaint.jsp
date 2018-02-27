<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/index.css">
<script src="js/jquery-3.2.1.js"></script>
<script src="js/bootstrap.min.js"></script>
<title></title>
</head>
<body>
	<div >
				<div class="" style="width: 90%;position:absolute;left: 5%;top: 15px;">
					<form action="complaint.do?cid=${commodity.commodityId }" method="post">
						<div class="" style="height: 100%;">
							<span style="color: red; font-size: 16px;">投诉&举报：</span>
							<hr />
							<h5>商品名：</h5>
								<div class="">
									<input type="text"
										class="form-control" disabled="true" value="${commodity.commodityName }">
								</div>
							<h5>商家名：</h5>
								<div class="">
									<input type="text"
										class="form-control" disabled="true" value="${seller.sellerName }">
								</div>
								<h5>举报理由：</h5>
								<div class="">
									<textarea type="text" name="content"
										class="form-control" placeholder="可以简短一些..."  id="cdescribe" rows="5"></textarea>
								</div>
							</table>
							<hr />
							<input type="submit" class="btn btn-block btn-success" value="提交举报信息"/>
							<a href="index.do" class="btn btn-block btn-danger">退出举报</a>
						</div>
					</form>
				</div>

	</div>
	
</body>

</html>