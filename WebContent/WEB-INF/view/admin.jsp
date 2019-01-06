<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="./particle/top.jsp"></jsp:include>
<style>
.custom-table {
	border: 1px solid #000;
	box-shadow: 0px 1.2px 1px 1.4px rgba(0, 0, 0, 0.1), 0px 1.4px 2px 1.8px rgba(0, 0, 0, 0.1), 0px 1.8px 3px 2.2px rgba(0, 0, 0, 0.1);
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

.view-select-user .select2-selection, .action-select-user .select2-selection {
	height: 38px;
	border-top-left-radius: 0px;
	border-bottom-left-radius: 0px;
	border-color: #ced4da;
}

.view-select-user .select2-selection__rendered, .action-select-user .select2-selection__rendered {
	line-height: 38px !important;
}

.view-select-user .select2-selection__arrow, .action-select-user .select2-selection__arrow {
	height: 38px !important;
}
</style>
<div class="container-fluid">
	<ol class="breadcrumb">
		<li class="breadcrumb-item"><a href="./main.html">Dashboard</a></li>
		<li class="breadcrumb-item active">Admin</li>
	</ol>
	<div class="card mb-3">
		<div class="card-header">
			<i class="fas fa-table"></i> User management
		</div>
		<div class="card-body">
			<div class="custom-table user-table">
				<div class="custom-table-row row">
					<div class="custom-table-col col-12 col-sm-6 col-md-4">Email</div>
					<div class="custom-table-col col-12 col-sm-6 col-md-4">Name</div>
					<div class="custom-table-col col-12 col-sm-4 col-md-2">Country</div>
					<div class="custom-table-col col-12 col-sm-4 col-md-1"></div>
					<div class="custom-table-col col-12 col-sm-4 col-md-1"></div>
				</div>
			</div>
		</div>
		<div class="card-footer small text-muted">&nbsp;</div>
	</div>
	<div class="card mb-3">
		<div class="card-header" style="padding-top: 5px; padding-bottom: 5px;">
			<span style="float: left; padding-top: 8px;"><i class="fas fa-table"></i> View-role management</span>
			<button type="button" class="btn btn-success view-role-save-btn" style="float: right;" disabled>SAVE</button>
		</div>
		<div class="card-body">
			<div class="row">
				<div class="col-12 col-md-5 col-xl-3 mb-3">
					<div class="input-group">
						<div class="input-group-prepend">
							<div class="input-group-text">
								<input type="radio" name="searchTypeView" value="0" checked>
							</div>
							<span class="input-group-text">Group</span>
						</div>
						<select class="form-control" id="groupViewSelect">
							<c:forEach items="${group}" var="item">
								<option value="${item.value}">${item.name}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="col-12 col-md-5 col-xl-5 mb-3">
					<div class="input-group view-select-user">
						<div class="input-group-prepend">
							<div class="input-group-text">
								<input type="radio" name="searchTypeView" value="1">
							</div>
							<span class="input-group-text">User</span>
						</div>
						<select class="form-control view-role-user" id="userViewSelect"></select>
					</div>
				</div>
				<div class="col-4 col-md-1 col-xl-1 mb-3">
					<button type="button" class="btn btn-primary view-role-btn">SEARCH</button>
				</div>
			</div>
			<div class="custom-table view-role-result hide">
				<div class="custom-table-row row">
					<div class="custom-table-col col-12 col-sm-10">Role</div>
					<div class="custom-table-col col-12 col-sm-2">Delete</div>
				</div>
				<div class="view-role-list-result"></div>
				<div class="custom-table-row row" style="padding: 5px;">
					<div class="custom-table-col col-12 no-padding">
						<button type="button" class="btn btn-success view-role-add-btn" style="width: 100%">ADD</button>
					</div>
				</div>
			</div>
		</div>
		<div class="card-footer small text-muted">&nbsp;</div>
	</div>
	<div class="card mb-3">
		<div class="card-header" style="padding-top: 5px; padding-bottom: 5px;">
			<span style="float: left; padding-top: 8px;"><i class="fas fa-table"></i> Action-role management</span>
			<button type="button" class="btn btn-success action-role-save-btn" style="float: right;" disabled>SAVE</button>
		</div>
		<div class="card-body">
			<div class="row">
				<div class="col-12 col-md-5 col-xl-3 mb-3">
					<div class="input-group">
						<div class="input-group-prepend">
							<div class="input-group-text">
								<input type="radio" name="searchTypeAction" value="0" checked>
							</div>
							<span class="input-group-text">Group</span>
						</div>
						<select class="form-control" id="groupActionSelect">
							<c:forEach items="${group}" var="item">
								<option value="${item.value}">${item.name}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="col-12 col-md-5 col-xl-5 mb-3">
					<div class="input-group action-select-user">
						<div class="input-group-prepend">
							<div class="input-group-text">
								<input type="radio" name="searchTypeAction" value="1">
							</div>
							<span class="input-group-text">User</span>
						</div>
						<select class="form-control action-role-user" id="userActionSelect"></select>
					</div>
				</div>
				<div class="col-3 col-md-1 col-xl-1 mb-3">
					<button type="button" class="btn btn-primary action-role-btn">SEARCH</button>
				</div>
			</div>
			<div class="custom-table action-role-result hide">
				<div class="custom-table-row row">
					<div class="custom-table-col col-12 col-sm-10">View</div>
					<div class="custom-table-col col-12 col-sm-2">Delete</div>
				</div>
				<div class="action-role-list-result"></div>
				<div class="custom-table-row row" style="padding: 5px;">
					<div class="custom-table-col col-12 no-padding">
						<button type="button" class="btn btn-success action-role-add-btn" style="width: 100%">ADD</button>
					</div>
				</div>
			</div>
		</div>
		<div class="card-footer small text-muted">&nbsp;</div>
	</div>
	<div class="card mb-3">
		<div class="card-header" style="padding-top: 5px; padding-bottom: 5px;">
			<span style="float: left; padding-top: 8px;"><i class="fa fa-refresh fa-spin" style="font-size: 14px"></i> Master refresh</span>
		</div>
		<div class="card-body">
			<button type="button" class="btn btn-success master-refresh">Refresh</button>
		</div>
		<div class="card-footer small text-muted">&nbsp;</div>
	</div>
</div>
<template class="countrySelect"> <select class="form-control">
	<c:forEach items="${country}" var="item">
		<option value="${item.value}">${item.name}</option>
	</c:forEach>
</select> </template>
<template class="viewrole-list-item">
<div class="custom-table-row row">
	<div class="custom-table-col col-12 col-sm-10 no-padding">
		<select class="form-control view-role-selection">
			<option value="">Please select item</option>
			<c:forEach items="${viewrole}" var="item">
				<option value="${item.value}">${item.name}</option>
			</c:forEach>
		</select>
	</div>
	<div class="custom-table-col col-12 col-sm-2 no-padding btn-col">
		<button type='button' class='btn btn-outline-danger btn-sm view-role-delete-btn user-btn role-delete-btn'>DELETE</button>
	</div>
</div>
</template>
<template class="actionrole-list-item">
<div class="custom-table-row row">
	<div class="custom-table-col col-12 col-sm-10 no-padding">
		<select class="form-control action-role-selection">
			<option value="">Please select item</option>
			<c:forEach items="${actionrole}" var="item">
				<option value="${item.value}">${item.name}</option>
			</c:forEach>
		</select>
	</div>
	<div class="custom-table-col col-12 col-sm-2 no-padding btn-col">
		<button type='button' class='btn btn-outline-danger btn-sm action-role-delete-btn user-btn role-delete-btn'>DELETE</button>
	</div>
</div>
</template>
<jsp:include page="./particle/bottom.jsp"></jsp:include>
<script>
	var _admin = (function(obj) {
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

				},
				complete : function(jqXHR, textStatus) {

				}
			});
		},
		createUserRow : function(user) {
			var $row = $("<div></div>").addClass("row custom-table-row");
			var $col1 = $("<div></div>").addClass("custom-table-col col-12 col-sm-6 col-md-4").text(user.email);
			$col1.append($("<input type='hidden' class='user-id'>").val(user.id));
			var $col2 = $("<div></div>").addClass("custom-table-col col-12 col-sm-6 col-md-4 no-padding")
										.append($("<input type='text' class='form-control user-name'>").val(user.name));
			var $col3 = $("<div></div>").addClass("custom-table-col col-12 col-sm-4 col-md-2 no-padding");
			$col3.append($($(".countrySelect").html()).addClass("user-country").val(user.country));
			var $col4 = $("<div></div>").addClass("custom-table-col col-12 col-sm-4 col-md-1 no-padding btn-col").append(
					$("<button type='button' class='btn btn-outline-primary btn-sm user-btn modify-btn'>MODIFY</button>"));
			var $col5 = $("<div></div>").addClass("custom-table-col col-12 col-sm-4 col-md-1 no-padding btn-col");
			if (user.deleted) {
				$col5.append("<button type='button' class='btn btn-outline-success btn-sm user-btn active-btn'>ACTIVE</button>");
			} else {
				$col5.append("<button type='button' class='btn btn-outline-danger btn-sm user-btn delete-btn'>DELETE</button>");
			}
			$row.append($col1);
			$row.append($col2);
			$row.append($col3);
			$row.append($col4);
			$row.append($col5);
			$(".user-table").append($row);
		},
		selectionResize : function() {
			var width = $(".view-select-user").width();
			$(".view-select-user").find(".select2-container").css("width", width - 110);
			$(".action-select-user").find(".select2-container").css("width", width - 110);
		},
		onLoad : function() {
			$(window).resize(function() {
				_admin.selectionResize();
			});
			_admin.ajax("./getUserList.ajax", null, function(data) {
				for (var i = 0; i < data.length; i++) {
					_admin.createUserRow(data[i]);
				}
			});
			$(".view-role-user").select2({
				placeholder : 'Search for user',
				minimumInputLength : 2,
				ajax : {
					url : './getUser.ajax',
					dataType : 'json'
				},
				width : $(".view-select-user").width() - 110
			});
			$(".action-role-user").select2({
				placeholder : 'Search for user',
				minimumInputLength : 2,
				ajax : {
					url : './getUser.ajax',
					dataType : 'json'
				},
				width : $(".view-select-user").width() - 110
			});
			
			//TODO: Dynamic view role add button
			$(document).on("click", ".view-role-add-btn", function() {
				$dom = $($(".viewrole-list-item").html());
				$(".view-role-list-result").append($dom);
			});
			
			//TODO: Dynamic action role add button
			$(document).on("click", ".action-role-add-btn", function() {
				$dom = $($(".actionrole-list-item").html());
				$(".action-role-list-result").append($dom);
			});
			
			//TODO: Dynamic delete button.
			$(document).on("click", ".role-delete-btn", function() {
				$(this).parent().parent().remove();
			});
			
			//TODO: View role save button
			$(".view-role-save-btn").on("click", function() {
				var data = {
					type : $("input[name=searchTypeView]:checked").val(),
					name : null,
					data : null
				}
				if (data.type === "0") {
					data.name = $("#groupViewSelect").val();
				} else {
					data.name = $("#userViewSelect").val();
				}
				var buffer = new Array;
				$(".view-role-result").find(".view-role-selection").each(function() {
					var val = $(this).find("option:selected").val();
					if ($.trim(val) !== "") {
						buffer.push($.trim(val));
					}
				});
				data.data = JSON.stringify(buffer);
				_admin.ajax("./saveViewRole.ajax", data, function(data) {
					if (data.ret) {
						toastr.success("View-role save ok!");
						return;
					}
					toastr.error("View-role save error");
				});
			});
			
			//TODO: Action role save button
			$(".action-role-save-btn").on("click", function() {
				var data = {
					type : $("input[name=searchTypeAction]:checked").val(),
					name : null,
					data : null
				}
				if (data.type === "0") {
					data.name = $("#groupActionSelect").val();
				} else {
					data.name = $("#userActionSelect").val();
				}
				var buffer = new Array;
				$(".action-role-result").find(".action-role-selection").each(function() {
					var val = $(this).find("option:selected").val();
					if ($.trim(val) !== "") {
						buffer.push($.trim(val));
					}
				});
				data.data = JSON.stringify(buffer);
				_admin.ajax("./saveActionRole.ajax", data, function(data) {
					if (data.ret) {
						toastr.success("Action-role save ok!");
						return;
					}
					toastr.error("Action-role save error");
				});
			});
			
			//TODO: View role radio button event
			$("input[name=searchTypeView]").on("click", function(){
				$(".view-role-list-result").html("");
				$(".view-role-result").addClass("hide");
				$(".view-role-save-btn").attr("disabled", true);
			});
			
			//TODO: Action role radio button event
			$("input[name=searchTypeAction]").on("click", function(){
				$(".action-role-list-result").html("");
				$(".action-role-result").addClass("hide");
				$(".action-role-save-btn").attr("disabled", true);
			});
			
			//TODO: View role search button
			$(".view-role-btn").on("click", function() {
				var data = {
					type : $("input[name=searchTypeView]:checked").val(),
					name : null
				};
				if (data.type === "0") {
					data.name = $("#groupViewSelect").val();
				} else {
					data.name = $("#userViewSelect").val();
				}
				_admin.ajax("./getViewRole.ajax", data, function(data) {
					if (data.isSearch) {
						$(".view-role-list-result").html("");
						$(".view-role-result").removeClass("hide");
						for (var i = 0; i < data.beanlist.length; i++) {
							$dom = $($(".viewrole-list-item").html());
							$dom.find(".view-role-selection").val(data.beanlist[i].code);
							$(".view-role-list-result").append($dom);
						}
						$(".view-role-save-btn").attr("disabled", false);
					} else {
						$(".view-role-result").addClass("hide");
						$(".view-role-save-btn").attr("disabled", true);
					}
				});
			});
			
			//TODO: Action role search button
			$(".action-role-btn").on("click", function() {
				var data = {
					type : $("input[name=searchTypeAction]:checked").val(),
					name : null
				};
				if (data.type === "0") {
					data.name = $("#groupActionSelect").val();
				} else {
					data.name = $("#userActionSelect").val();
				}
				_admin.ajax("./getActionRole.ajax", data, function(data) {
					if (data.isSearch) {
						$(".action-role-list-result").html("");
						$(".action-role-result").removeClass("hide");
						for (var i = 0; i < data.beanlist.length; i++) {
							$dom = $($(".actionrole-list-item").html());
							$dom.find(".action-role-selection").val(data.beanlist[i].code);
							$(".action-role-list-result").append($dom);
						}
						$(".action-role-save-btn").attr("disabled", false);
					} else {
						$(".action-role-result").addClass("hide");
						$(".action-role-save-btn").attr("disabled", true);
					}
				});
			});

			$(".master-refresh").on("click", function() {
				_admin.ajax("./resetMaster.ajax", null, function(data) {
					if (data.ret) {
						toastr.success("Master reset!");
					}
				});
			});
			
			$(document).on("click", ".modify-btn", function() {
				var $obj = $(this).parent().parent();
				var data = {
					id:$obj.find(".user-id").val(),
					name:$obj.find(".user-name").val(),
					country:$obj.find(".user-country").val()
				}
				_admin.ajax("./modifyUser.ajax", data, function(data) {
					if (data.ret) {
						toastr.success("Master reset!");
					}
				});
			});
		}
	});
</script>
<jsp:include page="./particle/bottom2.jsp"></jsp:include>