<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서 수정</title>

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
	text-align: center;
}

.a {
	margin: 10px;
}


</style>
</head>
<body>
	<div>
	<h3>부서 수정</h3>
	<hr></div>
	<br />
	<div class="container">
		<div class="row">
			<div class="col-md-4">&nbsp;</div>
			<div class="col-md-4">
				<form class="content" action="update.do" method="post">
					<div>
						부서번호 :&nbsp;<input type="text" name="deptno" class="a"
							value="${dto.deptno}" readonly="readonly" />
					</div>
					<div>
						부서명 :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="dname"
							class="a" value="${dto.dname}" />
					</div>
					<div>
						근무위치 : <input type="text" name="loc" class="a"
							value="${dto.loc}" />
					</div>
					<div>
						<input class="btn btn-success btn-xs" role="button" type="submit"
							value="수정" /> <a href="list" class="btn btn-success btn-xs"
							role="button">취소</a>
					</div>

				</form>
			</div>
			<div class="col-md-4">&nbsp;</div>
		</div>
	</div>

</body>
</html>