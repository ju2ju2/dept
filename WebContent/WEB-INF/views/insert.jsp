<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서 추가</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
h3 {
	text-align: center;
}

div {
	text-align: left;
}
#dd {
	text-align: center;
}

.a {
	margin: 10px;
}
</style>
<script type="text/javascript">
	$(function(){
		$('#btnck').click(function(){
			$.ajax({
						data:{
							"deptno":$('#deptno').val(),
							"type":"search1"
						},
						type:"get",
						url:"search",
						dataType:"text", //point
						success:function(data){
								console.log(data);
								if(data=="true"){
									$('#ck').html("중복");
									$('#deptno').val("");
									$('#deptno').focus();
								}else{
									$('#ck').html("사용가능");
									$('#dname').focus();
								}
							},
						erro:function(xhr){
							console.log(xhr);
						}
					});
		});
	});
</script>
</head>
<body>
	<div>
		<h3>부서 등록</h3>
		<hr>
	</div>
	<br />
	<div class="container">
		<div class="row">
			<div class="col-md-4">&nbsp;</div>
			<div class="col-md-4">
				<form class="content" action="insert" method="post">
					<input type="hidden" name="type" value="insert"/>
					<div>
						부서번호 :&nbsp;<input type="text" name="deptno" id="deptno" class="a" />
						<input type="button" name="btnck" id="btnck" value="중복체크"/>
						<div id="ck"></div>
					</div>
					<div>
						부서명 :&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" id="dname" name="dname"
							class="a" />
					</div>
					<div>
						부서번호 :&nbsp;<input type="text" name="loc" class="a" />
					</div>
					<div id="dd">
						<input class="btn btn-success btn-xs" role="button" id="submit" type="submit"
							value="등록" /> <a href="list" class="btn btn-success btn-xs"
							role="button">취소</a>
					</div>
				</form>
			</div>
			<div class="col-md-4">&nbsp;</div>
		</div>
	</div>
</body>
</html>