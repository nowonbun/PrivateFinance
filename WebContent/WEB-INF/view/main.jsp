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
<title>SB Admin - Blank Page</title>
<link href="//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.css" rel="stylesheet">
<link href="//cdn.jsdelivr.net/npm/startbootstrap-sb-admin@5.0.2/vendor/fontawesome-free/css/all.min.css" rel="stylesheet">
<link href="//cdn.datatables.net/1.10.18/css/dataTables.bootstrap4.min.css" rel="stylesheet">
<link href="//cdn.jsdelivr.net/npm/startbootstrap-sb-admin@5.0.2/css/sb-admin.min.css" rel="stylesheet">
<style>
.sidebar .nav-item .nav-link {
	text-align: center;
	padding: .75rem 1rem;;
	width: 80px;
}

.sidebar .nav-item .nav-link span {
	font-size: .65rem;
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
	width: calc(100% - 80px);
}
</style>
</head>
<body id="page-top" class="sidebar-toggled">
	<nav class="navbar navbar-expand navbar-dark bg-dark static-top">
		<a class="navbar-brand mr-1" href="index.html">Start Bootstrap</a>
		<ul class="navbar-nav ml-auto ml-auto mr-0 mr-md-3 my-0">
			<li class="nav-item dropdown no-arrow"><a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i
					class="fas fa-user-circle fa-fw"></i>
			</a>
				<div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
					<a class="dropdown-item" href="javascript:void(0);" data-toggle="modal" data-target="#logoutModal">Logout</a>
				</div></li>
		</ul>
	</nav>
	<div id="wrapper">
		<ul class="sidebar navbar-nav" style="width: inherit !important;">
			<li class="nav-item"><a class="nav-link" href="index.html"> 
				<i class="fas fa-fw fa-tachometer-alt"></i> <span>Dashboard</span>
			</a></li>
			<li class="nav-item dropdown"><a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i
					class="fas fa-fw fa-folder"></i> <span>Pages</span>
			</a>
				<div class="dropdown-menu" aria-labelledby="pagesDropdown">
					<h6 class="dropdown-header">Login Screens:</h6>
					<a class="dropdown-item" href="login.html">Login</a> <a class="dropdown-item" href="register.html">Register</a> <a class="dropdown-item" href="forgot-password.html">Forgot Password</a>
					<div class="dropdown-divider"></div>
					<h6 class="dropdown-header">Other Pages:</h6>
					<a class="dropdown-item" href="404.html">404 Page</a> <a class="dropdown-item active" href="blank.html">Blank Page</a>
				</div></li>
			<li class="nav-item"><a class="nav-link" href="charts.html"> <i class="fas fa-fw fa-chart-area"></i> <span>Charts</span></a></li>
			<li class="nav-item"><a class="nav-link" href="tables.html"> <i class="fas fa-fw fa-table"></i> <span>Tables</span></a></li>
		</ul>
		<div id="content-wrapper">
			<div class="container-fluid">
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="index.html">Dashboard</a></li>
					<li class="breadcrumb-item active">Blank Page</li>
				</ol>
				<h1>Blank Page</h1>
				<hr>
				<p>This is a great starting point for new custom pages.</p>
			</div>
			<footer class="sticky-footer" style="height: 40px;">
				<div class="container my-auto">
					<div class="copyright text-center my-auto">
						<span>Copyright © Your Website 2018</span>
					</div>
				</div>
			</footer>
		</div>
	</div>
	<a class="scroll-to-top rounded" href="#page-top"> <i class="fas fa-angle-up"></i>
	</a>
	<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
					<button class="close" type="button" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
					<a class="btn btn-primary" href="javascript:void(0);" id="logoutBtn">Logout</a>
				</div>
			</div>
		</div>
	</div>
	<script src="//code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/js/bootstrap.bundle.min.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
	<script src="//cdn.jsdelivr.net/npm/startbootstrap-sb-admin@5.0.2/js/sb-admin.min.js"></script>
	<script type="text/javascript" src="https://apis.google.com/js/platform.js?onload=onLoad" async defer></script>
	<script>
		function onLoad() {
			gapi.load('auth2,signin2', function() {
				auth2 = gapi.auth2.init();
			});
			$("#logoutBtn").on("click", function(){
				var auth2 = gapi.auth2.getAuthInstance();
				auth2.signOut().then(function() {
					location.href="logout.html";
				});
			});
		}
	</script>
</body>
</html>
