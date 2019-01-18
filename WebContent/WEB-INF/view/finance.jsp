<%@page import="Common.Util"%>
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
</style>
<link rel="stylesheet" href="./css/finance.css" />
<link rel="stylesheet" media="screen and (max-width:768px)" href="./css/finance_mobile.css" />
<link rel="stylesheet" media="screen and (min-width:769px)" href="./css/finance_pc.css" />
<link rel="stylesheet" type="text/css" href="./css/loading.css" />
<div class="container-fluid">
	<ol class="breadcrumb">
		<li class="breadcrumb-item"><a href="./main.html">Dashboard</a></li>
		<li class="breadcrumb-item active">Finance</li>
	</ol>
	<!-- from household copy -->
	<div class="finance">
		<div class="container">
			<form id="applyPc">
				<div class="main-date">
					<span class="fa fa-chevron-circle-left"></span>
					<div class="selectDiv household-date year">
						<span class="bp2">${year}</span> <select class="household-date year" id="householdYear">
							<c:forEach items="${yearlist}" var="item">
								<option value="${item.value}">${item.name}</option>
							</c:forEach>
						</select>
					</div>
					<label class="household-date"><%=Util.localization("year", session)%></label>
					<div class="selectDiv household-date month">
						<span class="bp2">${month}</span> <select class="household-date month" id="householdMonth">
							<c:forEach items="${monthlist}" var="item">
								<option value="${item.value}">${item.name}</option>
							</c:forEach>
						</select>
					</div>
					<label class="household-date"><%=Util.localization("month", session)%></label> <span class="fa fa-chevron-circle-right"></span>
				</div>
				<div class="space"></div>
				<div class="main-input">
					<table class="table-input">
						<thead>
							<tr>
								<th><%=Util.localization("day", session)%></th>
								<th><%=Util.localization("type", session)%></th>
								<th><%=Util.localization("category", session)%></th>
								<th><%=Util.localization("contents", session)%></th>
								<th><%=Util.localization("money", session)%></th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><input type="hidden" id="householdIdx">
									<div class="selectDiv household-date day">
										<span></span> <select class="household-date day" id="householdDay">
											<c:forEach items="${daylist}" var="item">
												<option value="${item.value}">${item.name}</option>
											</c:forEach>
										</select>
									</div></td>
								<td>
									<div class="selectDiv household-category">
										<span></span> <select class="household-type" id="householdType">
											<c:forEach items="${lowcategory}" var="item">
												<option value="${item.value}">${item.name}</option>
											</c:forEach>
										</select>
									</div>
								</td>
								<td>
									<div class="selectDiv household-category">
										<span></span> <select class="household-category" id="householdCategory"></select>
									</div>
								</td>
								<td><input type="text" id="householdContent" autocomplete="off" maxlength="40"></td>
								<td><input type="number" id="householdPrice" autocomplete="off" maxlength="8"></td>
							</tr>
							<tr>
								<td colspan="5">
									<div class="apply-area">
										<input type="button" value=<%=Util.localization("Save", session)%> id="applySubmit">
									</div>
									<div class="modify-area off">
										<input type="button" value="取消" id="cancelSubmit"> 
										<input type="button" value="修正" id="modifySubmit"> 
										<input type="button" value="削除" id="deleteSubmit">
									</div>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</form>
			<div class="space"></div>
			<div class="main-data">
				<div class="total-data data-income">
					<label><%=Util.localization("Income", session)%></label> <span class="income-total money-plus"></span>
				</div>
				<div class="total-data data-expend">
					<label><%=Util.localization("Expenditure", session)%></label> <span class="expenditure-total money-minus"></span>
				</div>
				<div class="total-data data-saving">
					<label><%=Util.localization("Saving", session)%></label> <span class="saving-full-total"></span>
				</div>
				<div class="search-data">
					<input type="button" id="searchInit" value="検索初期"> <label><%=Util.localization("day", session)%> : </label>
					<div class="selectDiv searchDaySelect">
						<span class="bp2"></span> <select id="searchDaySelect">
							<option value="">=全体=</option>
							<c:forEach items="${daylist}" var="item">
								<option value="${item.value}">${item.name}</option>
							</c:forEach>
						</select>
					</div>
					<label><%=Util.localization("type", session)%> : </label>
					<div class="selectDiv searchTypeSelect">
						<span class="bp2"></span> <select id="searchTypeSelect">
							<option value="">=全体=</option>
							<c:forEach items="${lowcategory}" var="item">
								<option value="${item.value}">${item.name}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="normal-data title-data">
					<label class="mobile-private"> <span class="fa fa-square fa-plus-square"></span> <span class="fa fa-square fa-minus-square off"></span>
					</label> <label><%=Util.localization("Finence", session)%></label> <label>TOTAL : <span class="payment-total"></span></label>
				</div>
				<table class="table-data table-data1 payment-list mobile-off">
					<thead>
						<tr>
							<th><%=Util.localization("day", session)%></th>
							<th><%=Util.localization("type", session)%></th>
							<th><%=Util.localization("category", session)%></th>
							<th><%=Util.localization("contents", session)%></th>
							<th><%=Util.localization("money", session)%></th>
						</tr>
					</thead>
					<tbody></tbody>
				</table>
				<div class="caption">
					<sup>&nbsp;</sup>
				</div>
				<div class="account-data title-data">
					<label class="mobile-private"> <span class="fa fa-square fa-plus-square"></span> <span class="fa fa-square fa-minus-square off"></span>
					</label> <label><%=Util.localization("Saving", session)%></label> <label>TOTAL : <span class="saving-total"></span></label>
				</div>
				<table class="table-data table-data2 saving-list mobile-off">
					<thead>
						<tr>
							<th><%=Util.localization("day", session)%></th>
							<th><%=Util.localization("category", session)%></th>
							<th><%=Util.localization("contents", session)%></th>
							<th><%=Util.localization("money", session)%></th>
						</tr>
					</thead>
					<tbody></tbody>
				</table>
				<div class="caption">
					<sup>「貯蓄のTotal」は現在まで金額の合算である。</sup>
				</div>
			</div>
		</div>
		<div class="lodding lodding-off">
			<div class="lodding-background"></div>
			<div class="uil-battery-demo-css" style="-webkit-transform: scale(0.6)">
				<div class="outer"></div>
				<div class="inner"></div>
				<div class="inner"></div>
				<div class="inner"></div>
				<div class="inner"></div>
			</div>
		</div>
	</div>
	<!-- from household copy -->
	<!-- calculation -->
	<!-- https://www.desmos.com/scientific -->
</div>
<c:forEach items="${categorykey}" var="key">
	<template class="categorymap" data-type="${key}"> <c:forEach items="${categorymap.get(key)}" var="item">
		<option value="${item.value}">${item.name}</option>
	</c:forEach> </template>
</c:forEach>
<template class="payment-item">
<tr class="payment-row">
	<td class="payment-day"></span><input type="hidden" class="payment-value" value=""></td>
	<td class="payment-type"></td>
	<td class="payment-category"></td>
	<td class="payment-contents"></td>
	<td><span class="payment-money"></span></td>
</tr>
</template>
<template class="search-no-result">
<tr class="nothing">
	<td>データがありません。</td>
</tr>
</template>
<input type="hidden" class="day-mark" value="<%=Util.localization("day", session)%>">
<input type="hidden" class="sign-mark" value="￥">
<jsp:include page="./particle/bottom.jsp"></jsp:include>
<script>
	var _finance = (function(obj) {
		$(obj.onLoad);
		return obj;
	})({
		ajax : function(url, data, cb) {
			_finance.loading.show();
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
					_finance.loading.hide();
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
		numberWithCommas : function(x) {
			return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
		},
		onLoad : function() {
			$("select").on("change", function() {
				$(this).parent().find("span").html($(this).find("option:selected").html());
			});
			_finance.search.init();
			_finance.inputForm.init();
		},
		loading : {
			show : function() {
				$(".lodding").removeClass("lodding-off");
			},
			hide : function() {
				$(".lodding").addClass("lodding-off");
			}
		},
		inputForm : {
			init : function() {
				//this.initVal();
				this.setting();
			},
			clear : function(){
				$("table.table-data1 > tbody > tr.click").each(function () {
	                $(this).removeClass("click");
	            });
				$("table.table-input div.apply-area").removeClass("off");
	            $("table.table-input div.modify-area").addClass("off");
	            $("#householdIdx").val("");
	            $("#householdContent").val("");
	            $("#householdPrice").val("");
			},
			setting : function() {
				$("#applySubmit").on("click", function() {
					if (!_finance.inputForm.validate(false)) {
						return;
					}
					let data = {
						date : _finance.inputForm.getDateFormat(_finance.inputForm.getHouseholdDate()),
						type : $("#householdType>option:selected").val(),
						category : $("#householdCategory>option:selected").val(),
						contents : $("#householdContent").val(),
						price : $("#householdPrice").val()
					};
					_finance.ajax("./setPaymentItem.ajax", data, function(data) {
						if (data.ret) {
							_finance.inputForm.clear();
							_finance.search.search();
							toastr.success("格納しました。");
						}
					});
				});
				$("#cancelSubmit").on("click", function(){
					_finance.inputForm.clear();
				});
				$("#deleteSubmit").on("click", function(){
					if (!_finance.inputForm.validate(true)) {
						return;
					}
					let data = {
						idx : $("#householdIdx").val()
					};
					_finance.ajax("./deletePaymentItem.ajax", data, function(data) {
						if (data.ret) {
							_finance.inputForm.clear();
							_finance.search.search();
							toastr.success("削除しました。");
						}
					});
				});
				$(".payment-list>tbody").on("click", ".payment-row", function() {
					_finance.inputForm.clear();
					let payment = $(this).find("input.payment-value").val();
					let data = JSON.parse(payment);
					$(this).addClass("click");
					$("table.table-input div.apply-area").addClass("off");
		            $("table.table-input div.modify-area").removeClass("off");
		            $("#householdIdx").val(data.idx);
		            $("#householdDay").val(data.day);
		            $("#householdDay").trigger("change");
		            $("#householdType").val(data.type_code);
		            $("#householdType").trigger("change");
		            $("#householdCategory").val(data.category_code);
		            $("#householdCategory").trigger("change");
		            $("#householdContent").val(data.contents);
		            $("#householdPrice").val(data.money_disp);
				});
			},
			getHouseholdDate : function() {
				let year = parseInt($("#householdYear>option:selected").val());
				let month = parseInt($("#householdMonth>option:selected").val()) - 1;
				let day = parseInt($("#householdDay>option:selected").val());
				return new Date(year, month, day);
			},
			getDateFormat : function(date) {
				let ret = date.getFullYear() + "/";
				if (date.getMonth() + 1 < 10) {
					ret += "0" + (date.getMonth() + 1);
				} else {
					ret += (date.getMonth() + 1);
				}
				ret += "/"
				if (date.getDate() < 10) {
					ret += "0" + date.getDate();
				} else {
					ret += date.getDate();
				}
				return ret;
			},
			validate : function(isIdx) {
				let date = _finance.inputForm.getHouseholdDate();
				if(isIdx){
					let idx = $("#householdIdx").val();
					if (idx === null || idx.trim() === "") {
						toastr.error("Itemを選択してください。");
						return false;
					}	
				}
				let contents = $("#householdContent").val();
				if (contents === null || contents.trim() === "") {
					toastr.error("内容を入力してください。");
					return false;
				}
				let price = $("#householdPrice").val();
				if (price === null || price.trim() === "") {
					toastr.error("金額を入力をしてください。");
					return false;
				}
				if (parseInt(price) < 0) {
					toastr.error("金額を０円以上に入力してください。");
					return false;
				}
				return true;
			}
		},
		search : {
			isSelect : false,
			init : function() {
				this.setting();
				this.initVal();
				this.search();
			},
			initVal : function() {
				let date = new Date();
				$("#householdYear").val(date.getFullYear());
				$("#householdMonth").val(date.getMonth() + 1);
				$("#householdDay").val(date.getDate());
				$("#householdDay_mobile").val(date.getDate());

				$("div.selectDiv").children("span").each(function() {
					$(this).html($(this).parent().find("select").find("option:selected").html());
				});
			},
			setting : function() {
				$("span.fa.fa-chevron-circle-left").on("click", function() {
					_finance.search.addMonth(-1);
				});
				$("span.fa.fa-chevron-circle-right").on("click", function() {
					_finance.search.addMonth(1);
				});
				$("div.main-date select, select#searchDaySelect, select#searchTypeSelect").on("change", function() {
					_finance.search.search();
				});
				$("#householdYear").on("change", function() {
					$("#householdYearView").html($("#householdYear").val());
				});
				$("#householdMonth").on("change", function() {
					$("#householdMonthView").html($("#householdMonth").val());
				});
				$("input[type=button]#searchInit").on("click", function() {
					$("select#searchDaySelect,select#searchTypeSelect").val("");
					$("div.selectDiv.searchDaySelect").find("span").html($("select#searchDaySelect").find("option:selected").html());
					$("div.selectDiv.searchTypeSelect").find("span").html($("select#searchTypeSelect").find("option:selected").html());
					_finance.search.search();
				});

				function changeCategory() {
					let type = $("#householdType").find("option:selected").val();
					let dom = $(".categorymap[data-type=" + type + "]").html();
					$("#householdCategory").html(dom);
					$("#householdCategory").trigger("change");
				}
				$("#householdType").on("change", function() {
					changeCategory();
				});
				changeCategory();
			},
			search : function() {
				$(".payment-list>tbody").html("");
				$(".saving-list>tbody").html("");
				$(".income-total").html("");
				$(".expenditure-total").html("");
				$(".saving-full-total").html("");
				$(".saving-full-total").removeClass("money-plus");
				$(".saving-full-total").removeClass("money-minus");
				$(".saving-full-total").removeClass("money-zero");
				$(".payment-total").html("");
				$(".payment-total").removeClass("money-plus");
				$(".payment-total").removeClass("money-minus");
				$(".payment-total").removeClass("money-zero");
				$(".saving-total").html("");
				$(".saving-total").removeClass("money-plus");
				$(".saving-total").removeClass("money-minus");
				$(".saving-total").removeClass("money-zero");
				let data = {
					date : _finance.inputForm.getDateFormat(_finance.inputForm.getHouseholdDate()),
					day : $("#searchDaySelect>option:selected").val(),
					type : $("#searchTypeSelect>option:selected").val()
				};
				_finance.ajax("./getPaymentItem.ajax", data, function(data) {
					for (let i = 0; i < data.financelist.length; i++) {
						let node = data.financelist[i];
						let $dom = $($(".payment-item").html());
						$dom.find(".payment-value").val(JSON.stringify(node));
						$dom.find(".payment-day").append(node.day + $(".day-mark").val());
						$dom.find(".payment-type").append(node.type_disp);
						$dom.find(".payment-category").append(node.category_disp);
						$dom.find(".payment-contents").append(node.contents);
						$dom.find(".payment-money").append($(".sign-mark").val() + _finance.numberWithCommas(node.money_disp));
						if (node.sign > 0) {
							$dom.find(".payment-money").addClass("money-plus");
						} else if (node.sign < 0) {
							$dom.find(".payment-money").addClass("money-minus");
						} else {
							$dom.find(".payment-money").addClass("money-zero");
						}
						$(".payment-list>tbody").append($dom);
					}
					if (data.financelist.length <= 0) {
						let $dom = $($(".search-no-result").html());
						$dom.find("td").attr("colspan", 5);
						$(".payment-list>tbody").append($dom);
					}
					for (let i = 0; i < data.savinglist.length; i++) {
						let node = data.savinglist[i];
						let $dom = $($(".payment-item").html());
						$dom.find(".payment-day").append(node.day + $(".day-mark").val());
						$dom.find(".payment-type").remove();
						$dom.find(".payment-category").append(node.category_disp);
						$dom.find(".payment-contents").append(node.contents);
						$dom.find(".payment-money").append($(".sign-mark").val() + _finance.numberWithCommas(node.money_disp));
						if (node.sign < 0) {
							$dom.find(".payment-money").addClass("money-plus");
						} else if (node.sign > 0) {
							$dom.find(".payment-money").addClass("money-minus");
						} else {
							$dom.find(".payment-money").addClass("money-zero");
						}
						$(".saving-list>tbody").append($dom);
					}
					if (data.savinglist.length <= 0) {
						let $dom = $($(".search-no-result").html());
						$dom.find("td").attr("colspan", 4);
						$(".saving-list>tbody").append($dom);
					}
					$(".income-total").append($(".sign-mark").val() + _finance.numberWithCommas(data.incomeTotal));
					$(".expenditure-total").append($(".sign-mark").val() + _finance.numberWithCommas(data.expenditureTotal));
					$(".saving-full-total").append($(".sign-mark").val() + _finance.numberWithCommas(data.fullSavingTotal));
					if (data.fullSavingsign > 0) {
						$(".saving-full-total").addClass("money-plus");
					} else if (data.fullSavingsign < 0) {
						$(".saving-full-total").addClass("money-minus");
					} else {
						$(".saving-full-total").addClass("money-zero");
					}
					$(".payment-total").append($(".sign-mark").val() + _finance.numberWithCommas(data.financeTotal));
					if (data.financesign > 0) {
						$(".payment-total").addClass("money-plus");
					} else if (data.financesign < 0) {
						$(".payment-total").addClass("money-minus");
					} else {
						$(".payment-total").addClass("money-zero");
					}
					$(".saving-total").append($(".sign-mark").val() + _finance.numberWithCommas(data.savingTotal));
					if (data.savingsign > 0) {
						$(".saving-total").addClass("money-plus");
					} else if (data.savingsign < 0) {
						$(".saving-total").addClass("money-minus");
					} else {
						$(".saving-total").addClass("money-zero");
					}
				});
			},
			addMonth : function(addmonth) {
				let year = parseInt($("#householdYear").val());
				let month = parseInt($("#householdMonth").val());
				month += addmonth;
				if (month < 1) {
					month += 12;
					year--;
				} else if (month > 12) {
					month -= 12;
					year++;
				}
				$("#householdYear").val(year);
				$("#householdYearView").html($("#householdYear").val());
				$("#householdMonth").val(month);
				$("#householdMonthView").html($("#householdMonth").val());
				_finance.search.search();
			}
		}
	});
</script>
<jsp:include page="./particle/bottom2.jsp"></jsp:include>