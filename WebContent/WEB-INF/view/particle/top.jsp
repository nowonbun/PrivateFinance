<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- https://www.jsdelivr.com/package/npm/startbootstrap-sb-admin -->
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<meta name="google-signin-client_id" content="220458850151-v238vlakgd2c4n3dho9o76sc7u9a5ovb.apps.googleusercontent.com">
<title>Private Finance</title>
<link href="//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
<link href="//cdn.datatables.net/1.10.18/css/dataTables.bootstrap4.min.css" rel="stylesheet">
<link href="//cdn.jsdelivr.net/npm/startbootstrap-sb-admin@5.0.2/css/sb-admin.min.css" rel="stylesheet">
<link href="//cdnjs.cloudflare.com/ajax/libs/select2/4.0.6-rc.0/css/select2.min.css" rel="stylesheet" />
<link href="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css" rel="stylesheet" />
<style>
.sidebar .nav-item .nav-link {
	text-align: center;
	padding: .75rem 5px;
	width: 40px;
	font-size: 20px;
}

.sidebar .nav-item .nav-link span {
	font-size: 5px;
	display: block;
}

.sidebar .nav-item.dropdown .dropdown-toggle::after {
	display: none;
}

.sidebar .nav-item .dropdown-menu {
	position: absolute !important;
	-webkit-transform: none !important;
	transform: none !important;
	left: calc(90px + .5rem) !important;
	margin: 0;
}

body.sidebar-toggled footer.sticky-footer {
	width: calc(100% - 40px);
}
</style>
</head>
<body id="page-top" class="sidebar-toggled">
	<nav class="navbar navbar-expand navbar-dark bg-dark static-top">
		<a class="navbar-brand mr-1" href="index.html">Start Bootstrap</a>
		<ul class="navbar-nav ml-auto ml-auto mr-0 mr-md-3 my-0">
			<li class="nav-item dropdown no-arrow">
				<a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> 
					<i class="fas fa-user-circle fa-fw"></i>
				</a>
				<div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
					<a class="dropdown-item" href="javascript:void(0);" data-toggle="modal" data-target="#logoutModal">Logout</a>
				</div>
			</li>
		</ul>
	</nav>
	<div id="wrapper">
		<jsp:include page="./menu.jsp"></jsp:include>
		<div id="content-wrapper">