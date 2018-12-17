<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	${test} <br />
	ajax : <input type="text" class="ajax-text">
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script>
		/*$(function() {
			$.ajax({
				url : "test.ajax",
				type : "GET",
				success : function(data, textStatus, jqXHR) {
					$(".ajax-text").val(data);
				},
				error : function(jqXHR, textStatus, errorThrown) {

				},
				complete : function(jqXHR, textStatus) {

				}
			});
		});*/
	</script>
</body>
</html>