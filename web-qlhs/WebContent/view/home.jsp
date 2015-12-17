<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Quản Lý Học Sinh</title>
<script type="text/javascript"
	src="view/resource/lib/jquery-2.1.4.min.js"></script>
<script type="text/javascript"
	src="view/resource/bootstrap/js/bootstrap.min.js"></script>
<link href="view/resource/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="view/resource/css/css_home.css" rel="stylesheet">

</head>
<body>
	<div class="container">
		<center>
			<div style="margin: 0 auto; margin-top: 30px; display:inline-block;">
				<form action="ControllerDSLop" style = "margin:10px">
					<button type="submit"  style = "background-image: url('view/resource/img/mm.jpg');"  class="btn btn-default btn-circle btn-xl">
						Lớp học</button>
				</form>
				<form action="Controller"style = "margin:10px">
					<button title = "Học sinh" style = "background-image: url('view/resource/img/mn.jpg');" type="button" class="btn btn-default btn-circle btn-xl">
						Học sinh</button>
				</form>				
			</div>
		</center>
	</div>
</body>
</html>