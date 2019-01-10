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
	                    <span>${year}</span>
	                    <select class="household-date year" id="householdYear" name="householdYear">
		                    <c:forEach items="${yearlist}" var="item">
								<option value="${item.value}">${item.name}</option>
							</c:forEach>
	                    </select>
	                </div>
	                <label class="household-date">年</label>
	                <div class="selectDiv household-date month">
	                    <span>${month}</span>
	                    <select class="household-date month" id="householdMonth" name="householdMonth">
	                        <c:forEach items="${monthlist}" var="item">
	                        	<option value="${item.value}">${item.name}</option>
							</c:forEach>
	                    </select>
	                </div>
	                <label class="household-date">月</label>
	                <span class="fa fa-chevron-circle-right"></span>
	            </div>
	            <div class="space"></div>
	            <div class="main-input">
	                <table class="table-input pc-private">
	                    <thead>
	                        <tr>
	                            <th>日</th>
	                            <th>区分</th>
	                            <th>カテ</th>
	                            <th>内容</th>
	                            <th>金額</th>
	                        </tr>
	                    </thead>
	                    <tbody>
	                        <tr>
	                            <td>
	                                <input type="hidden" id="householdIdx_pc" name="householdIdx" value="">
	                                <input type="hidden" id="householdPdt_pc" name="householdPdt">
	                                <div class="selectDiv household-date day">
	                                    <span></span>
	                                    <select class="household-date day" id="householdDay" name="householdDay">
	                                        <c:forEach items="${daylist}" var="item">
					                        	<option value="${item.value}">${item.name}</option>
											</c:forEach>
	                                    </select>
	                                </div>
	                            </td>
	                            <td>
	                                <div class="selectDiv household-category">
	                                    <span></span>
	                                    <select class="household-category" id="householdCategory" name="householdCategory">
	                                    	<c:forEach items="${lowcategory}" var="item">
					                        	<option value="${item.value}">${item.name}</option>
											</c:forEach>
	                                    </select>
	                                </div>
	                            </td>
	                            <td>
	                                <div class="selectDiv household-category">
	                                    <span>支出</span>
	                                    <select class="household-type" id="householdType" name="householdType"></select>
	                                </div>
	                            </td>
	                            <td>
	                                <input name="householdContent" id="householdContent_pc" autocomplete="off" maxlength="40">
	                            </td>
	                            <td>
	                                <input type="tel" pattern="[0-9]*" name="householdPrice" id="householdPrice_pc" autocomplete="off" maxlength="8">
	                            </td>
	                        </tr>
	                        <tr>
	                            <td colspan="5">
	                                <div class="apply-area">
	                                    <input type="button" value="登録" id="applySubmit_pc">
	                                </div>
	                                <div class="modify-area off">
	                                    <input type="button" value="取消" id="cancelSubmit_pc">
	                                    <input type="button" value="修正" id="modifySubmit_pc">
	                                    <input type="button" value="削除" id="deleteSubmit_pc">
	                                </div>
	                            </td>
	                        </tr>
	                    </tbody>
	                </table>
	                <div class="table-input mobile-private">
	                    <input type="button" value="登録" id="apply_mobile">
	                </div>
	            </div>
	        </form>
	        <div class="space"></div>
	        <div class="main-data">
	            <div class="total-data data-income">
	                <label>収入</label>
	                <span id="Income" class="money-plus">￥481,619</span>
	            </div>
	            <div class="total-data data-expend">
	                <label>支出</label>
	                <span id="expend" class="money-minus">￥304,562</span>
	            </div>
	            <div class="search-data">
	                <input type="button" id="searchInit" value="検索初期">
	                <label>日 : </label>
	                <div class="selectDiv searchDaySelect">
	                    <span>全体</span>
	                    <select id="searchDaySelect">
	                        <option value="">全体</option>
	                        <option value="1">1</option><option value="2">2</option><option value="3">3</option><option value="4">4</option><option value="5">5</option><option value="6">6</option><option value="7">7</option><option value="8">8</option><option value="9">9</option><option value="10">10</option><option value="11">11</option><option value="12">12</option><option value="13">13</option><option value="14">14</option><option value="15">15</option><option value="16">16</option><option value="17">17</option><option value="18">18</option><option value="19">19</option><option value="20">20</option><option value="21">21</option><option value="22">22</option><option value="23">23</option><option value="24">24</option><option value="25">25</option><option value="26">26</option><option value="27">27</option><option value="28">28</option><option value="29">29</option><option value="30">30</option><option value="31">31</option>
	                    </select>
	                </div>
	                <label>区分 : </label>
	                <div class="selectDiv searchTypeSelect">
	                    <span>=全体=</span>
	                    <select id="searchTypeSelect">
	                        <option value="">=全体=</option>
	                        <option value="001">収入</option><option value="002">支出</option><option value="003">食費</option><option value="004">交通費</option><option value="005">ローン</option><option value="006">お小遣い</option><option value="007">外食</option><option value="008">光熱費</option>
	                    </select>
	                </div>
	            </div>
	            <div class="normal-data title-data">
	                <label class="mobile-private">
	                    <span class="fa fa-square fa-plus-square"></span>
	                    <span class="fa fa-square fa-minus-square off"></span>
	                </label>
	                <label>一般</label>
	                <label>TOTAL : <span id="totalMoney1" class="money-plus">￥177,057</span></label>
	            </div>
	            <table class="table-data table-data1 mobile-off">
	                <thead>
	                    <tr>
	                        <th>日</th>
	                        <th>カテゴリ</th>
	                        <th>区分</th>
	                        <th>内容</th>
	                        <th>金額</th>
	                    </tr>
	                </thead>
	                <tbody>
	                <tr class="">
	                    <td>4日<input type="hidden" value="3687,4,000,002,家賃,-130000,20190104233014000"></td>
	                    <td>一般</td>
	                    <td>支出</td>
	                    <td>家賃</td>
	                    <td><span class="money-minus">￥130,000</span></td>
	                </tr>
	            
	                <tr class="">
	                    <td>4日<input type="hidden" value="3688,4,000,002,交通費,-90000,20190104233040000"></td>
	                    <td>一般</td>
	                    <td>支出</td>
	                    <td>交通費</td>
	                    <td><span class="money-minus">￥90,000</span></td>
	                </tr>
	            
	                <tr class="">
	                    <td>4日<input type="hidden" value="3689,4,000,002,おっつ,-5400,20190104233159000"></td>
	                    <td>一般</td>
	                    <td>支出</td>
	                    <td>おっつ</td>
	                    <td><span class="money-minus">￥5,400</span></td>
	                </tr>
	            
	                <tr class="">
	                    <td>5日<input type="hidden" value="3690,5,000,002,アトリエ,-6000,20190105004403000"></td>
	                    <td>一般</td>
	                    <td>支出</td>
	                    <td>アトリエ</td>
	                    <td><span class="money-minus">￥6,000</span></td>
	                </tr>
	            
	                <tr class="">
	                    <td>5日<input type="hidden" value="3691,5,000,002,保険,-5000,20190105004419000"></td>
	                    <td>一般</td>
	                    <td>支出</td>
	                    <td>保険</td>
	                    <td><span class="money-minus">￥5,000</span></td>
	                </tr>
	            
	                <tr class="">
	                    <td>5日<input type="hidden" value="3692,5,000,002,給食費,-8000,20190105004431000"></td>
	                    <td>一般</td>
	                    <td>支出</td>
	                    <td>給食費</td>
	                    <td><span class="money-minus">￥8,000</span></td>
	                </tr>
	            
	                <tr class="">
	                    <td>5日<input type="hidden" value="3693,5,000,002,ジェーコム,-6664,20190105004451000"></td>
	                    <td>一般</td>
	                    <td>支出</td>
	                    <td>ジェーコム</td>
	                    <td><span class="money-minus">￥6,664</span></td>
	                </tr>
	            
	                <tr class="">
	                    <td>5日<input type="hidden" value="3694,5,000,002,ジェーコム,-756,20190105004500000"></td>
	                    <td>一般</td>
	                    <td>支出</td>
	                    <td>ジェーコム</td>
	                    <td><span class="money-minus">￥756</span></td>
	                </tr>
	            
	                <tr class="">
	                    <td>5日<input type="hidden" value="3695,5,000,002,ファム,-216,20190105004525000"></td>
	                    <td>一般</td>
	                    <td>支出</td>
	                    <td>ファム</td>
	                    <td><span class="money-minus">￥216</span></td>
	                </tr>
	            
	                <tr class="">
	                    <td>5日<input type="hidden" value="3696,5,000,002,アルバ,-540,20190105004625000"></td>
	                    <td>一般</td>
	                    <td>支出</td>
	                    <td>アルバ</td>
	                    <td><span class="money-minus">￥540</span></td>
	                </tr>
	            
	                <tr class="">
	                    <td>5日<input type="hidden" value="3697,5,000,002,アマゾン,-1296,20190105004638000"></td>
	                    <td>一般</td>
	                    <td>支出</td>
	                    <td>アマゾン</td>
	                    <td><span class="money-minus">￥1,296</span></td>
	                </tr>
	            
	                <tr class="">
	                    <td>5日<input type="hidden" value="3698,5,000,002,アマゾン,-690,20190105004647000"></td>
	                    <td>一般</td>
	                    <td>支出</td>
	                    <td>アマゾン</td>
	                    <td><span class="money-minus">￥690</span></td>
	                </tr>
	            
	                <tr class="">
	                    <td>5日<input type="hidden" value="3699,5,000,002,雑誌,-800,20190105004705000"></td>
	                    <td>一般</td>
	                    <td>支出</td>
	                    <td>雑誌</td>
	                    <td><span class="money-minus">￥800</span></td>
	                </tr>
	            
	                <tr class="">
	                    <td>5日<input type="hidden" value="3700,5,000,002,アマゾン,-3900,20190105004723000"></td>
	                    <td>一般</td>
	                    <td>支出</td>
	                    <td>アマゾン</td>
	                    <td><span class="money-minus">￥3,900</span></td>
	                </tr>
	            
	                <tr class="">
	                    <td>5日<input type="hidden" value="3701,5,000,002,お小遣いスンヨプ亜弥,-20000,20190105004957000"></td>
	                    <td>一般</td>
	                    <td>支出</td>
	                    <td>お小遣いスンヨプ亜弥</td>
	                    <td><span class="money-minus">￥20,000</span></td>
	                </tr>
	            
	                <tr class="">
	                    <td>5日<input type="hidden" value="3702,5,000,002,洗濯機,-10000,20190105005635000"></td>
	                    <td>一般</td>
	                    <td>支出</td>
	                    <td>洗濯機</td>
	                    <td><span class="money-minus">￥10,000</span></td>
	                </tr>
	            
	                <tr class="">
	                    <td>5日<input type="hidden" value="3703,5,000,002,太陽光,-15300,20190105010944000"></td>
	                    <td>一般</td>
	                    <td>支出</td>
	                    <td>太陽光</td>
	                    <td><span class="money-minus">￥15,300</span></td>
	                </tr>
	            
	                <tr class="">
	                    <td>31日<input type="hidden" value="3686,31,000,001,お給料,481619,20190104232949000"></td>
	                    <td>一般</td>
	                    <td>収入</td>
	                    <td>お給料</td>
	                    <td><span class="money-plus">￥481,619</span></td>
	                </tr>
	            </tbody>
	            </table>
	            <div class="caption"><sup>&nbsp;</sup></div>
	            <div class="account-data title-data">
	                <label class="mobile-private">
	                    <span class="fa fa-square fa-plus-square"></span>
	                    <span class="fa fa-square fa-minus-square off"></span>
	                </label>
	                <label>貯蓄</label>
	                <label>TOTAL : <span id="totalMoney2" class="money-plus">￥568,411</span></label>
	            </div>
	            <table class="table-data table-data2 mobile-off">
	                <thead>
	                    <tr>
	                        <th>日</th>
	                        <th>区分</th>
	                        <th>内容</th>
	                        <th>金額</th>
	                    </tr>
	                </thead>
	                <tbody>
	                <tr class="nothing result-data2">
	                    <td colspan="4">データがありません。</td>
	                </tr>
	            </tbody>
	            </table>
	            <div class="caption"><sup>「貯蓄のTotal」は現在まで金額の合算である。</sup></div>
	        </div>
	    </div>
	    <div class="template">
	        <table class="template-data1">
	            <tbody>
	                <tr class="##HOVER##">
	                    <td>##DATE##日<input type="hidden" value="##DATA##"></td>
	                    <td>##CATEGORY##</td>
	                    <td>##TYPE##</td>
	                    <td>##CONTENTS##</td>
	                    <td><span class="##CLASS##">##PRICE##</span></td>
	                </tr>
	            </tbody>
	        </table>
	        <table class="template-data1-nothing">
	            <tbody>
	                <tr class="nothing result-data1">
	                    <td colspan="5">データがありません。</td>
	                </tr>
	            </tbody>
	        </table>
	        <table class="template-data2">
	            <tbody>
	                <tr>
	                    <td>##DATE##日</td>
	                    <td>##TYPE##</td>
	                    <td>##CONTENTS##</td>
	                    <td><span class="##CLASS##">##PRICE##</span></td>
	                </tr>
	            </tbody>
	        </table>
	        <table class="template-data2-nothing">
	            <tbody>
	                <tr class="nothing result-data2">
	                    <td colspan="4">データがありません。</td>
	                </tr>
	            </tbody>
	        </table>
	        <table class="template-data3">
	            <tbody>
	                <tr>
	                    <td>##DATE##日</td>
	                    <td>##CONTENTS##</td>
	                    <td><span class="##CLASS##">##PRICE##</span></td>
	                </tr>
	            </tbody>
	        </table>
	        <table class="template-data3-nothing">
	            <tbody>
	                <tr class="nothing result-data3">
	                    <td colspan="3">データがありません。</td>
	                </tr>
	            </tbody>
	        </table>
	        <select id="select_000"><option value="001">収入</option><option value="002">支出</option><option value="003">食費</option><option value="004">交通費</option><option value="005">ローン</option><option value="006">お小遣い</option><option value="007">外食</option><option value="008">光熱費</option></select><select id="select_010"><option value="011">入金</option><option value="012">出金</option></select><select id="select_020"><option value="022">支出</option></select>
	    </div>
	    <div class="layout off">
	        <div class="apply off">
	            <div class="title">
	                <label>登録</label>
	                <span class="remove fa fa-close" aria-hidden="true"></span>
	            </div>
	            <div class="layout-main">
	                <form id="apply_form_mobile">
	                    <table>
	                        <tbody>
	                            <tr>
	                                <th>日</th>
	                                <td>
	                                    <input type="hidden" id="householdYear_mobile" name="householdYear" value="">
	                                    <input type="hidden" id="householdMonth_mobile" name="householdMonth" value="">
	                                    <input type="hidden" id="householdIdx_mobile" name="householdIdx" value="">
	                                    <input type="hidden" id="householdPdt_mobile" name="householdPdt" value="">
	                                    <div class="selectDiv householdDay_mobile">
	                                        <span>8</span>
	                                        <select class="household-date day" id="householdDay_mobile" name="householdDay">
	                                            <option value="1">1</option><option value="2">2</option><option value="3">3</option><option value="4">4</option><option value="5">5</option><option value="6">6</option><option value="7">7</option><option value="8">8</option><option value="9">9</option><option value="10">10</option><option value="11">11</option><option value="12">12</option><option value="13">13</option><option value="14">14</option><option value="15">15</option><option value="16">16</option><option value="17">17</option><option value="18">18</option><option value="19">19</option><option value="20">20</option><option value="21">21</option><option value="22">22</option><option value="23">23</option><option value="24">24</option><option value="25">25</option><option value="26">26</option><option value="27">27</option><option value="28">28</option><option value="29">29</option><option value="30">30</option><option value="31">31</option>
	                                        </select>
	                                    </div>
	                                </td>
	                            </tr>
	                            <tr>
	                                <th>カテゴリ</th>
	                                <td>
	                                    <div class="selectDiv householdCategory_mobile">
	                                        <span>一般</span>
	                                        <select class="household-category" id="householdCategory_mobile" name="householdCategory">
	                                            <option value="000">一般</option><option value="010">貯蓄</option><option value="020">クレジット</option>
	                                        </select>
	                                    </div>
	                                </td>
	                            </tr>
	                            <tr>
	                                <th>区分</th>
	                                <td>
	                                    <div class="selectDiv householdType_mobile">
	                                        <span>支出</span>
	                                        <select class="household-type" id="householdType_mobile" name="householdType"><option value="001">収入</option><option value="002">支出</option><option value="003">食費</option><option value="004">交通費</option><option value="005">ローン</option><option value="006">お小遣い</option><option value="007">外食</option><option value="008">光熱費</option></select>
	                                    </div>
	                                    
	                                </td>
	                            </tr>
	                            <tr>
	                                <th>内容</th>
	                                <td>
	                                    <input type="text" name="householdContent" id="householdContent_mobile" autocomplete="off" maxlength="40">
	                                </td>
	                            </tr>
	                            <tr>
	                                <th>金額</th>
	                                <td>
	                                    <input type="tel" pattern="[0-9]*" name="householdPrice" id="householdPrice_mobile" autocomplete="off" maxlength="9">
	                                    <input type="button" value="計算機" id="calc_mobile">
	                                </td>
	                            </tr>
	                            <tr>
	                                <td colspan="2">
	                                    <label class="error_mobile"></label>
	                                </td>
	                            </tr>
	                            <tr>
	                                <td colspan="2">
	                                    <div class="apply-area mobile-private">
	                                        <input type="button" value="登録" id="applySubmit_mobile">
	                                    </div>
	                                    <div class="modify-area mobile-private">
	                                        <input type="button" value="修正" id="modifySubmit_mobile">
	                                        <input type="button" value="削除" id="deleteSubmit_mobile">
	                                    </div>
	                                </td>
	                            </tr>
	                        </tbody>
	                    </table>
	                </form>
	            </div>
	        </div>
	        <div class="calc off">
	            <div class="calcmain">
	                <div class="title">
	                    <label>計算機</label>
	                    <span class="remove fa fa-close" aria-hidden="true"></span>
	                </div>
	                <table>
	                    <tbody>
	                        <tr>
	                            <td colspan="2" class="calc-txt">
	                                <input type="tel" pattern="[0-9]*" id="calc" autocomplete="off">
	                            </td>
	                        </tr>
	                        <tr>
	                            <td colspan="2" class="calc-sum">
	                                <span id="operation"></span>
	                                S : <input type="tel" pattern="[0-9]*" id="calc_sum" autocomplete="off" readonly="" disabled="disabled" maxlength="8">
	                            </td>
	                        </tr>
	                        <tr>
	                            <td>
	                                <input type="button" id="calc_add" value="+">
	                            </td>
	                            <td>
	                                <input type="button" id="calc_subtract" value="-">
	                            </td>
	                        </tr>
	                        <tr>
	                            <td>
	                                <input type="button" id="calc_multiply" value="*">
	                            </td>
	                            <td>
	                                <input type="button" id="calc_division" value="/">
	                            </td>
	                        </tr>
	                        <tr>
	                            <td>
	                                <input type="button" id="calc_clear" value="C">
	                            </td>
	                            <td>
	                                <input type="button" id="calc_result" value="=">
	                            </td>
	                        </tr>
	                        <tr>
	                            <td colspan="2">
	                                <input type="button" id="calc_input" value="入力">
	                            </td>
	                        </tr>
	                    </tbody>
	                </table>
	            </div>
	        </div>
	    </div>
	    <div class="lodding lodding-off">
	        <div class="lodding-background"></div>
	        <div class="uil-battery-demo-css" style="-webkit-transform:scale(0.6)">
	            <div class="outer"></div>
	            <div class="inner"></div>
	            <div class="inner"></div>
	            <div class="inner"></div>
	            <div class="inner"></div>
	        </div>
	    </div>
	</div>
<!-- from household copy -->	
</div>
<template class="categorymap">
	<c:forEach items="${categorykey}" var="key">
		<select class="category-select" data-type="${key}">
		<c:forEach items="${categorymap.get(key)}" var="item">
			<option value="${item.value}">${item.name}</option>
		</c:forEach>
		</div>
	</c:forEach>
</template>

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
			$("select").on("change", function () {
                $(this).parent().find("span").html($(this).find("option:selected").html());
            });
			_finance.search.init();
		},
		search: {
	        init: function () {
	            this.setting();
	            this.initVal();
	            this.search();
	        },
	        initVal: function () {
	            var date = new Date();
	            $("#householdYear").val(date.getFullYear());
	            $("#householdMonth").val(date.getMonth() + 1);
	            $("#householdDay_pc").val(date.getDate());
	            $("#householdDay_mobile").val(date.getDate());

	            $("div.selectDiv").children("span").each(function () {
	                $(this).html($(this).parent().find("select").find("option:selected").html());
	            });
	        },
	        setting: function () {
	            $("select").on("change", function () {
	                $(this).parent().find("span").html($(this).find("option:selected").html());
	            });
	            //date-left
	            $("span.fa.fa-chevron-circle-left").on("click", function () {
	            	_finance.search.addMonth(-1);
	                var select = $("div.selectDiv.household-date.year");
	                select.find("span").html(select.find("select").val());
	                var select = $("div.selectDiv.household-date.month");
	                select.find("span").html(select.find("select").val());
	                _finance.search.search();
	            });
	            //date-right
	            $("span.fa.fa-chevron-circle-right").on("click", function () {
	            	_finance.search.addMonth(1);
	                var select = $("div.selectDiv.household-date.year");
	                select.find("span").html(select.find("select").val());
	                var select = $("div.selectDiv.household-date.month");
	                select.find("span").html(select.find("select").val());
	                _finance.search.search();
	            });
	            //検索セレクトが値が変更すると発生
	            $("div.main-date select, select#searchDaySelect, select#searchTypeSelect").on("change", function () {
	            	_finance.search.search();
	            });
	            $("#householdYear").on("change", function () {
	                $("#householdYearView").html($("#householdYear").val());
	            });
	            $("#householdMonth").on("change", function () {
	                $("#householdMonthView").html($("#householdMonth").val());
	            });
	            //検索初期化
	            $("input[type=button]#searchInit").on("click", function () {
	                $("select#searchDaySelect,select#searchTypeSelect").val("");
	                $("div.selectDiv.searchDaySelect").find("span").html($("select#searchDaySelect").find("option:selected").html());
	                $("div.selectDiv.searchTypeSelect").find("span").html($("select#searchTypeSelect").find("option:selected").html());
	                _finance.search.search();
	            });
	            
	            $("#householdCategory").on("change", function(){
	            	debugger;
	            	var type = $(this).find("option:selectd").val();
	            	console.log(type);
	            	var dom = $(".category-select[data-type="+type+"]").html();
	            	console.log(dom);
	            	$("#householdType").html(dom);
	            });
	        },
	        search: function () {
	            var year = parseInt($("#householdYear").val());
	            var month = parseInt($("#householdMonth").val());
	            var day = parseInt($("#searchDaySelect").val());
	            if (isNaN(day)) {
	                day = "";
	            }
	            var type = $("#searchTypeSelect").val();
	            debugger;
	            console.log("search!!");
	            //TODO: This must be solved!.
	            //_.data.initVal();
	            //_.fn.sendAjax("Search", "year=" + year + "&month=" + month + "&day=" + day + "&type=" + type, _.data.searchData);
	        },
	        addMonth: function (addmonth) {
	            var year = parseInt($("#householdYear").val());
	            var month = parseInt($("#householdMonth").val());
	            month += addmonth;
	            if (month < 1) {
	                month += 12;
	                year--;
	            } else if (month > 12) {
	                month -= 12;
	                year++;
	            }
	            //householdDay
	            $("#householdYear").val(year);
	            $("#householdMonth").val(month);
	        }
	    }
	});
</script>
<jsp:include page="./particle/bottom2.jsp"></jsp:include>