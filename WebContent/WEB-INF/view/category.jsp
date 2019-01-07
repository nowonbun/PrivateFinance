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
		<li class="breadcrumb-item active">Category</li>
	</ol>
	<div class="card mb-3">
		<div class="card-header">
			<i class="fas fa-book"></i> Income category
		</div>
		<div class="card-body">
			<div class="custom-table income-table">
				<div class="custom-table-row row">
					<div class="custom-table-col col-12 col-sm-10">Name</div>
					<div class="custom-table-col col-12 col-sm-2"></div>
				</div>
				<div class="income-list-result list-result">
					<c:forEach items="${income}" var="item">
						<div class="custom-table-row row">
							<input type="hidden" class="item-id" value="${item.id }">
							<div class="custom-table-col col-12 col-sm-10 no-padding">
								<input type="text" class="form-control item-name" value="${item.name }">
							</div>
							<div class="custom-table-col col-12 col-sm-2 no-padding btn-col">
								<select class="form-control type-selection">
									<c:if test="${item.del eq 1}">
										<option value="1" selected>Active</option>
										<option value="2">Delete</option>    
									</c:if>
									<c:if test="${item.del eq 2}">
										<option value="1">Active</option>
										<option value="2" selected>Delete</option>    
									</c:if>
								</select>
							</div>
						</div>
					</c:forEach>
				</div>
				<div class="custom-table-row row" style="padding: 5px;">
					<div class="custom-table-col col-12 no-padding">
						<button type="button" class="btn btn-success add-btn" style="width: 100%">ADD</button>
					</div>
				</div>
			</div>
		</div>
		<div class="card-footer small text-muted">&nbsp;</div>
	</div>

	<div class="card mb-3">
		<div class="card-header">
			<i class="fas fa-book-dead"></i> Expenditure category
		</div>
		<div class="card-body">
			<div class="custom-table income-table">
				<div class="custom-table-row row">
					<div class="custom-table-col col-12 col-sm-10">Name</div>
					<div class="custom-table-col col-12 col-sm-2"></div>
				</div>
				<div class="expenditure-list-result list-result">
					<c:forEach items="${expenditure}" var="item">
						<div class="custom-table-row row">
							<input type="hidden" class="item-id" value="${item.id }">
							<div class="custom-table-col col-12 col-sm-10 no-padding">
								<input type="text" class="form-control item-name" value="${item.name }">
							</div>
							<div class="custom-table-col col-12 col-sm-2 no-padding btn-col">
								<select class="form-control type-selection">
									<c:if test="${item.del eq 1}">
										<option value="1" selected>Active</option>
										<option value="2">Delete</option>    
									</c:if>
									<c:if test="${item.del eq 2}">
										<option value="1">Active</option>
										<option value="2" selected>Delete</option>    
									</c:if>
								</select>
							</div>
						</div>
					</c:forEach>
				</div>
				<div class="custom-table-row row" style="padding: 5px;">
					<div class="custom-table-col col-12 no-padding">
						<button type="button" class="btn btn-success add-btn" style="width: 100%">ADD</button>
					</div>
				</div>
			</div>
		</div>
		<div class="card-footer small text-muted">&nbsp;</div>
	</div>

	<div class="card mb-3">
		<div class="card-header">
			<i class="fas fa-piggy-bank"></i> Saving category
		</div>
		<div class="card-body">
			<div class="custom-table income-table">
				<div class="custom-table-row row">
					<div class="custom-table-col col-12 col-sm-10">Name</div>
					<div class="custom-table-col col-12 col-sm-2"></div>
				</div>
				<div class="saving-list-result list-result">
					<c:forEach items="${saving}" var="item">
						<div class="custom-table-row row">
							<input type="hidden" class="item-id" value="${item.id }">
							<div class="custom-table-col col-12 col-sm-10 no-padding">
								<input type="text" class="form-control item-name" value="${item.name }">
							</div>
							<div class="custom-table-col col-12 col-sm-2 no-padding btn-col">
								<select class="form-control type-selection">
									<c:if test="${item.del eq 1}">
										<option value="1" selected>Active</option>
										<option value="2">Delete</option>    
									</c:if>
									<c:if test="${item.del eq 2}">
										<option value="1">Active</option>
										<option value="2" selected>Delete</option>    
									</c:if>
								</select>
							</div>
						</div>
					</c:forEach>
				</div>
				<div class="custom-table-row row" style="padding: 5px;">
					<div class="custom-table-col col-12 no-padding">
						<button type="button" class="btn btn-success add-btn" style="width: 100%">ADD</button>
					</div>
				</div>
			</div>
		</div>
		<div class="card-footer small text-muted">&nbsp;</div>
	</div>
	<div class="row mr-0">
		<div class="ml-auto">
			<button type="button" class="btn btn-success save-button">SAVE</button>
		</div>
	</div>
</div>
<template class="list-item">
<div class="custom-table-row row">
	<input type="hidden" class="item-id" value="0">
	<div class="custom-table-col col-12 col-sm-10 no-padding">
		<input type="text" class="form-control item-name">
	</div>
	<div class="custom-table-col col-12 col-sm-2 no-padding btn-col">
		<select class="form-control type-selection add-selection">
			<option value="0">Add</option>
			<option value="3">Delete</option>
		</select>
	</div>
</div>
</template>
<form method="POST" action="saveCategory.html">
	<input type="hidden" name="income">
	<input type="hidden" name="expenditure"> 
	<input type="hidden" name="saving">
</form>
<jsp:include page="./particle/bottom.jsp"></jsp:include>
<script>
	var _category = (function(obj) {
		$(obj.onLoad);
		return obj;
	})({
		onLoad : function() {
			$(".add-btn").on("click", function() {
				$result = $(this).parent().parent().parent().find(".list-result");
				$dom = $($(".list-item").html());
				$result.append($dom);
			});
			$(".save-button").on("click", function() {
				var data = new Array;
				$(".income-list-result .custom-table-row").each(function() {
					data.push({
						id : $(this).find(".item-id").val(),
						name : $(this).find(".item-name").val(),
						del : $(this).find(".type-selection option:selected").val()
					});
				});
				$("input[name=income]").val(JSON.stringify(data));

				data = new Array;
				$(".expenditure-list-result .custom-table-row").each(function() {
					data.push({
						id : $(this).find(".item-id").val(),
						name : $(this).find(".item-name").val(),
						del : $(this).find(".type-selection option:selected").val()
					});
				});
				$("input[name=expenditure]").val(JSON.stringify(data));

				data = new Array;
				$(".saving-list-result .custom-table-row").each(function() {
					data.push({
						id : $(this).find(".item-id").val(),
						name : $(this).find(".item-name").val(),
						del : $(this).find(".type-selection option:selected").val()
					});
				});
				$("input[name=saving]").val(JSON.stringify(data));
				$("form").submit();
			});
			$(document).on("change", ".add-selection", function() {
				var value = $(this).find(":selected").val();
				if (value === "3") {
					$(this).parent().parent().remove();
				}
			});
		}
	});
</script>
<c:if test="${categoryupdated eq true}">
<script>
$(function(){
	toastr.success("Category save ok!");	
});
</script>
</c:if>
<jsp:include page="./particle/bottom2.jsp"></jsp:include>