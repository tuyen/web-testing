<%@page import="dto.dtoDiem"%>
<%@page import="Model.ModelDiem"%>
<%@page import="Model.ModelHS"%>
<%@page import="dto.dtoHocSinh"%>
<%@page import="Model.ModelLop"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dto.dtoLop"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript"
	src="view/resource/lib/jquery-2.1.4.min.js"></script>
<script type="text/javascript"
	src="view/resource/bootstrap/js/bootstrap.min.js"></script>
<link href="view/resource/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<!-- datatable -->
<link
	href="view/resource/DataTables-1.10.9/css/jquery.dataTables.min.css"
	rel="stylesheet">
<script type="text/javascript"
	src="view/resource/DataTables-1.10.9/js/jquery.dataTables.min.js"></script>
</head>
<%
	String mahs = request.getParameter("hs");
	String malop = request.getParameter("lop");

	dtoHocSinh hs = new dtoHocSinh();
	ModelHS mdhs = new ModelHS();
	hs = mdhs.getHS(mahs);

	ModelLop mdl = new ModelLop();

	ModelDiem mdd = new ModelDiem();
	List<dtoDiem> dsd = mdd.getDiem(mahs);
%>

<title><%=hs.getHoTen()%> - Quản Lý Học Sinh</title>
<body>
	<div class="container" style="padding-top: 30px;">
		<center>
			<h3><%=hs.getHoTen()%></h3>
		</center>
		<p>
			<b>Mã học sinh: </b>
			<%=hs.getMaHS()%>
		</p>
		<p>
			<b>Ngày sinh: </b>
			<%=hs.getNgaySinh()%>
		</p>
		<p>
			<b>Địa chỉ: </b>
			<%=hs.getDiaChi()%>
		</p>
		<p>
			<b>Dân tộc: </b>
			<%=hs.getDanToc()%>
		</p>
		<p>
			<b>Giới tính: </b>
			<%=hs.getGioiTinh()%>
		</p>
		<p>
			<b>Tôn giáo: </b>
			<%=hs.getTonGiao()%>
		</p>
		<p>
			<b>Số điện thoại: </b>
			<%=hs.getSdt()%>
		</p>
		<center>
			<h3>Thông tin học tập</h3>
		</center>
		<table id="tpost"
			class="table table-striped table-bordered table-hover " width="100%">
			<thead>
				<tr>
					<th>Lớp</th>
					<th>Giáo viên</th>
					<th>Toán</th>
					<th>Tiếng Việt</th>
					<th>Tập làm văn</th>
				</tr>
			</thead>
			<tbody>
				<%
					dtoLop lop = new dtoLop();
					for (dtoDiem d : dsd) {
						lop = mdl.GetLop(d.getMaLop());
						out.write("<tr><td>" + lop.getTenLop() + "</td>");
						out.write("<td>" + lop.getGiaoVien() + "</td>");
						out.write("<td>" + d.getToan() + "</td>");
						out.write("<td>" + d.getTiengViet() + "</td>");
						out.write("<td>" + d.getTapLamVan() + "</td></tr>");
					}
				%>
			</tbody>
		</table>
	</div>
</body>
</html>