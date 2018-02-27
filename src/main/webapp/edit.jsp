<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/quan.min.css">
<script src="js/jquery-3.2.1.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/makesure.js"></script>
<title></title>
</head>

<body style="background-color: white;">
	<div >
				<div class="" style="width: 90%;position:absolute;left: 5%;top: 15px;">
					<form action="edit.do?cid=${commodity.commodityId }" method="post" enctype="multipart/form-data">
						<div class="" style="height: 100%;">
							<span style="color: red; font-size: 16px;">商品编辑：</span>
							<hr />
								<h5>商品名：</h5>
								<div class="">
									<input type="text" name="cname"
										class="form-control" placeholder="16位字符以内" id="cname" value="${commodity.commodityName }">
								</div>
								<h5>价格</h5>
								<div class="">
									
										<input type="text" name="cprice"
										class="form-control" placeholder="最高9999.99" id="cprice" value="${commodity.commodityPrice }">
									
								</div>
								<h5>商品描述</h5>
								<div class="">
									<input type="text" name="cdescribe"
										class="form-control" placeholder="64位字符以内" id="cdescribe" value="${commodity.commodityDescribe }">
								</div>
								<h5>库存：</h5>
								<div class="">
									<input type="text" name="cstock"
										class="form-control" placeholder="最高9999" id="cstock" value="${commodity.commodityStock }">
								</div>
								<h5>类型：</h5>
								<select name="ckind" class="form-control">
									<option value="日用">日用</option>
									<option value="运动">运动</option>
									<option value="外卖">外卖</option>
									<option value="数码">数码</option>
									<option value="图书">图书</option>
									<option value="其他">其他</option>
								</select>
								<h5>图片：</h5>
								<div class=""><input name="commodityImg" type="file" accept="image" /></div>
							</table>
							<hr />
							<input type="hidden" name="cid" value="${commodity.commodityId }" />
							<input type="submit" class="btn btn-block btn-success" value="确认更改"/>
							<a href="editlist.do" class="btn btn-block btn-danger">取消更改</a>
						</div>
					</form>
				</div>
		
		<div class="alert alert-danger quan_err" id="err" hidden="true">错误！请进行一些更改。</div>
	</div>

</body>

</html>