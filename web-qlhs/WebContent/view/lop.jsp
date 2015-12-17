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
<title>Thông tin lớp - Quản Lý Học Sinh</title>
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
	List<dtoHocSinh> dshs = new ArrayList<dtoHocSinh>();
	ModelHS mdhs = new ModelHS();
	String malop = request.getParameter("lop");
	dshs = mdhs.getDSHS(malop);
	
	ModelLop mdl = new ModelLop();	
	dtoLop lop = mdl.GetLop(malop);
	
	ModelDiem mdd = new ModelDiem();
%>
<body>
	<div class="container" style = "padding-top:30px;">
		<div class="row">
			<div class="col-md-8">				
				<h3>Lớp <%=lop.getTenLop() %></h3>
				<div style = "display:inline;">
					<p><b>Sỉ số: </b>  <%=lop.getSiSo() %> </p>
					<p><b>Giáo viên: </b>  <%=lop.getGiaoVien() %> </p>
					<p><b>Năm học: </b>  <%=lop.getNamHoc() %> </p>
				</div>
				<h3>Danh sách học sinh</h3>
				<table id="tpost"
					class="table table-striped table-bordered table-hover "
					width="100%">
					<thead>
						<tr>
							<th>STT</th>
							<th>Họ tên</th>
							<th>Toán</th>
							<th>Tiếng Việt</th>
							<th>Tập làm văn</th>
						</tr>
					</thead>
					<tbody>
						<%
							dtoDiem d = new dtoDiem();
							for(dtoHocSinh hs : dshs){
								out.write("<tr><td>" + hs.getMaHS() +"</td>");
								out.write("<td><a href='"+request.getContextPath() + "/ControllerHS?hs=" + hs.getMaHS() + "'>"+ hs.getHoTen()+"</a></td>");
								d = mdd.getDiem(hs.getMaHS(), malop);
								out.write("<td>"+d.getToan()+"</td>");
								out.write("<td>"+d.getTiengViet()+"</td>");
								out.write("<td>"+d.getTapLamVan()+"</td></tr>");
							}
						%>
					</tbody>
				</table>
			</div>
			<div class="col-md-4" style = "border-left: thin solid;border-left-color: black;">
				<div class = "form-group">
					<h3>Cập nhật điểm số</h3>
					<form role = "form form-inline" class = "form" action="ControllerLop" method = "POST">
						<label for = "txths">Học sinh</label>
						<select class="form-control" id = "txths" name = "txths">
							<%
								for(dtoHocSinh hs : dshs){
									out.write("<option value = '"+hs.getMaHS()+"'> "+hs.getHoTen()+"</option>");
								}
							%>							
						</select>
						<label for = "txtToan">Toán</label>
						<input required class="form-control" id = "txtToan" name = "txtToan" type="number" placeholder = "10">
						<label for = "txtTV">Tiếng Việt</label>
						<input required class="form-control" id = "txtTV" name = "txtTV" type="number" placeholder = "10">
						<label for = "txttlv">Tập làm văn</label>
						<input required class="form-control" id = "txttlv" name = "txttlv" type="number" placeholder = "10">						
						<input type = "text" style = "display: none" value = "<%=malop %>" id = "txtmalop" name = "txtmalop">
						<input class = "form-control btn btn-primary" style = "margin-top:10px;" type = "submit" name = "btnSubmit" value = "Cập nhật điểm">
					</form>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		/**
		 * datatable
		 */
		$(document)
				.ready(
						function() {
							$('#tpost')
									.DataTable(
											{
												"order" : [ [ 0, "asc" ] ],
												"language" : {
													"lengthMenu" : "Hiển thị _MENU_ học sinh",
													"zeroRecords" : "Chưa có dữ liệu",
													"search" : "Tìm kiếm:",
													"info" : "Hiển thị từ _START_ đến _END_ trong tổng số _TOTAL_ học sinh",
													"infoEmpty" : "Chưa có dữ liệu",
													"infoFiltered" : "(Lọc từ _MAX_ học sinh)",
													"paginate" : {
														"first" : "Trang đầu",
														"last" : "Trang cuối",
														"next" : "Trang sau",
														"previous" : "Trang trước"
													},
													"aria" : {
														"sortAscending" : ": Chọn để sắp xếp tăng dần",
														"sortDescending" : ": Chọn để sắp xếp giảm dần"
													}
												}
											});
						});
	</script>
</body>
</html>