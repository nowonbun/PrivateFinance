<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="./particle/top.jsp"></jsp:include>
<style>
.custom-table {
	border: 1px solid #000;
	box-shadow: 0px 1.2px 1px 1.4px rgba(0, 0, 0, 0.1), 0px 1.4px 2px 1.8px
		rgba(0, 0, 0, 0.1), 0px 1.8px 3px 2.2px rgba(0, 0, 0, 0.1);
}

.custom-table .custom-table-row {
	margin: 0px;
	border-bottom: 1px solid #000;
}

.custom-table .custom-table-col {
	text-align: center;
	border: 1px dotted #e4e4e4;
	padding: 0.375rem 0.75rem;
}

.custom-table .custom-table-col.no-padding {
	padding: 0px;
}

.custom-table .custom-table-col .user-btn {
	margin-top: 3px;
}

.btn-col button {
	width: 100%;
}

.hide {
	display: none;
}
</style>
<div class="container-fluid">
	<ol class="breadcrumb">
		<li class="breadcrumb-item"><a href="./main.html">Dashboard</a></li>
		<li class="breadcrumb-item active">Finance</li>
	</ol>
	
</div>

<jsp:include page="./particle/bottom.jsp"></jsp:include>
<script>
	var _finance = (function(obj) {
		$(obj.onLoad);
		return obj;
	})({
		ajax : function(url, data, cb) {
			$.ajax({
				url : url,
				type : "POST",
				dataType : "json",
				data : data,
				success : function(data, textStatus, jqXHR) {
					cb.call(this, data);
				},
				error : function(jqXHR, textStatus, errorThrown) {
					console.log(jqXHR);
					console.log(errorThrown);
					toastr.error("system error!");
				},
				complete : function(jqXHR, textStatus) {

				}
			});
		},
		isNullorEmptyOrUndefined : function(val) {
			if (val === null) {
				return true;
			}
			if (val === undefined) {
				return true;
			}
			if ($.trim(val) === "") {
				return true;
			}
			return false;
		},
		onLoad : function() {

		}
	});
</script>
<jsp:include page="./particle/bottom2.jsp"></jsp:include>