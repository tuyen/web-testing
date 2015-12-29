<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="dto.dtoHocSinh"%>
<%@ page import="Model.ModelHS"%>
<%@ page import="Model.ModelLop"%>
<%@ page import="java.util.List"%>
<%@ page import="dto.dtoLop"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Quản lý học sinh</title>

<link rel="stylesheet"
	href="view/resource/bootstrap/css/bootstrap.min.css">
<script src="view/resource/lib/jquery-2.1.4.min.js"></script>
<script src="view/resource/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>


	<div class="container">
		<div class="jumbotron">
			<center>
				<h2>Quản lý học sinh</h2>
			</center>
		</div>
		<p>
			<%
				if(request.getAttribute("ss") != null)
					out.write(request.getAttribute("ss").toString());
			%>
		</p>
		<div class="panel panel-default">
			<div class="panel-heading">Nhập học sinh</div>
			<div class="panel-body">

				<form action="ControllerDSHocSinh" method="post">

					<table width="100%" border="0">
						<tr>
							<td width="10%">Họ tên</td>
							<td width="20%"><input required type="text" name="hoten"
								maxlength="100"></td>
							<td width="10%">Ngày sinh</td>
							<td width="20%"><input required type="text" name="ngaysinh"
								maxlength="100"></td>
							<td width="10%">Giới Tính</td>
							<td width="20%"><input required type="text" name="gioitinh"
								maxlength="100"></td>
						</tr>
						<tr>
							<td colspan="6" width="100%"><hr></td>
						</tr>
						<tr>
							<td>Dân tộc</td>
							<td><input type="text" required name="dantoc"
								maxlength="100"></td>
							<td>Tôn Giáo</td>
							<td><input type="text" required name="tongiao"
								maxlength="100"></td>
							<td></td>
							<td></td>

						</tr>
						<tr>
							<td colspan="6" width="100%"><hr></td>
						</tr>
						<tr>
							<td>Địa chỉ</td>
							<td><input type="text" required name="diachi"
								maxlength="100"></td>
							<td>Liên hệ</td>
							<td><input type="text" required name="sdt" maxlength="100"></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td colspan="6" width="100%"><hr></td>
						</tr>
						<tr>
							<%
								ModelLop lop = new ModelLop();
								List<dtoLop> dslop = lop.GetDSLop();
							%>
							<td>Chọn lớp:</td>
							<td><select name="lop">
									<%
										for (dtoLop l : dslop) {
											out.print("<option value=\"" + l.getMaLop() + "\">"
													+ l.getTenLop() + "</option>");
										}
									%>
							</select></td>
							<td></td>
							<td><input type="submit" value="Thêm học sinh"
								name="btn_submit" maxlength="100"> <input type="reset"
								value="Đặt lại" name="sdt" maxlength="100"></td>
							<td></td>
							<td></td>
						</tr>
					</table>
				</form>
			</div>
		</div>

		<p>
			<%
				if(request.getAttribute("count") != null)
					out.write("Có "+request.getAttribute("count").toString() + " đã được chuyển lớp");
			%>
		</p>
		<div class="panel panel-default">
			<div class="panel-heading">Chuyển lớp</div>
			<div class="panel-body">

				<form action="ControllerDSHocSinh" method="post">
					<table border="0" width="30%">
						<tr>
							<td width="50%">Từ lớp</td>
							<td width="50%">Chuyến đến lớp</td>
						</tr>

						<tr>
							<td><select name="from">
									<%
										for (dtoLop l : dslop) {
											out.print("<option value=\"" + l.getMaLop() + "\">"
													+ l.getTenLop() + "</option>");
										}
									%>
							</select></td>
							<td><select name="to">
									<%
										for (dtoLop l : dslop) {
											out.print("<option value=\"" + l.getMaLop() + "\">"
													+ l.getTenLop() + "</option>");
										}
									%>
							</select></td>
						</tr>

						<tr>
							<td></td>
							<td><br> <input type="submit" name="btn_change"
								value="Chuyển"></td>
						</tr>
					</table>
				</form>
			</div>
		</div>

		<div class="panel panel-default">
			<%
				ModelHS hs = new ModelHS();
				List<dtoHocSinh> ds = hs.getDSHS();
			%>
			<div class="panel-heading">Danh sách học sinh</div>
			<div class="panel-body">
				<h3>
					Có:
					<%=ds.size()%>
					học sinh
				</h3>
				<hr>
				<table border="1" width="100%">
					<tr>
						<td width="4%">STT</td>
						<td width="14%">Họ tên</td>
						<td width="12%">Ngày Sinh</td>
						<td width="10%">Giới Tính</td>
						<td width="12%">Dân tộc</td>
						<td width="12%">Tôn giáo</td>
						<td width="12%">Địa chỉ</td>
						<td width="12%">Liên hệ</td>
					</tr>
					<%
						for (dtoHocSinh i : ds) {
							out.print("<tr>");
							out.print("<td>" + i.getMaHS() + "</td>");
							out.print("<td><a href='ControllerHS?hs=" + i.getMaHS() + "'>"
									+ i.getHoTen() + "</a></td>");
							out.print("<td>" + i.getNgaySinh() + "</td>");
							out.print("<td>" + i.getGioiTinh() + "</td>");
							out.print("<td>" + i.getDanToc() + "</td>");
							out.print("<td>" + i.getTonGiao() + "</td>");
							out.print("<td>" + i.getDiaChi() + "</td>");
							out.print("<td>" + i.getSdt() + "</td>");
							out.print("</tr>");
						}
					%>
				</table>
			</div>
		</div>
	</div>

	<!--
`mahs`, `hoten`, `ngaysinh`, `gioitinh`, `dantoc`, `tongiao`, `diachi`, `sdt`

  -->

</body>
</html>