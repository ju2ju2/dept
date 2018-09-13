<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main</title>
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
</style>
<script type="text/javascript">
$(function(){
	$('#btnS').click(function(){
		$('#search').modal('show');
	});
	
	/* $('#searchbtn').click(function(){
		if($('#deptnoS').val()==""){
			alert("id입력");
			$('#deptnoS').focus();
		}else{
			$.ajax({
				data:{
					"deptno":$('#deptnoS').val(),
					"type":"search"
				},
				type:"get",
				url:"search",
				dataType:"json", //point = xml,json,script,text,html
				success:function(data){
						console.log(data);
						$.each(data,function(index, obj){
						$('td').remove();
						$('#tr2').after('<td>'+obj.deptno+'</td><td>'
								+obj.dname+'</td><td>'
								+obj.loc+'</td>');
						
						$('.modal-backdrop').hide();
						$('#search').modal('hide');
						});

					},
				erro:function(xhr){
					console.log(xhr);
				}
			});
		}
		
	}); */
});
</script>
</head>
<body>
	<h3>부서 리스트</h3><br/><br/>
	<div class="row">
		<div class="col-sm-4 col-md-12">
			<div class="container">
				<c:set var="deptlist" value="${dtoList}"></c:set>
				<table class="table" id="table">
					<tr class="active" id="tr2">
						<th>부서번호</th>
						<th>부서명</th>
						<th>근무위치</th>
					</tr>
					<c:forEach var="deptitem" items="${deptlist}">
						<tr id="tr">
							<td id="tdno">${deptitem.deptno}</td>
							<td id="tdname">${deptitem.dname}</td>
							<td id="tdloc">${deptitem.loc}</td>
						</tr>
					</c:forEach>
				</table>
				<div class="row">
					<div class="col-xs-12">
						<div class="btn-group btn-group-md">
							<a href="list.do" class="btn btn-success" role="button">전체조회</a>
							<button type="button" class="btn btn-success" id="btnS">조건조회</button>
							<a href="insert.do?type=page" class="btn btn-success" role="button">부서추가</a>
							<button type="button" class="btn btn-success" data-toggle="modal"
								data-target="#update">부서수정</button>
							<button type="button" class="btn btn-success" data-toggle="modal"
								data-target="#delete">부서삭제</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Modal update-->
	<div class="modal fade" id="update" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">수정 번호</h4>
				</div>
				<div class="modal-body">
					<form action="update.do">
						<!-- <input type="hidden" name="type" value="update"/> -->
						수정할 부서번호: <input type="text" name="deptno" /><input type="submit"
							value="검색" />
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
	<!-- Modal delete-->
	<div class="modal fade" id="delete" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">삭제 번호</h4>
				</div>
				<div class="modal-body">
					<form action="delete.do">
						<!-- <input type="hidden" name="type" value="delete"/> -->
						삭제할 부서번호: <input type="text" name="deptno" /><input type="submit"
							value="삭제" />
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
	<!-- Modal search-->
	<div class="modal fade" id="search" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">조건 검색 번호</h4>
				</div>
				<div class="modal-body">
					<form action="search.do">
						<!-- <input type="hidden" name="type" value="search"/> -->
						검색할 부서번호: <input type="text" name="deptno" id="deptnoS" />
						<input type="submit" id="searchbtn" value="검색" />
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>