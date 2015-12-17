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
	List<dtoLop> dslop = new ArrayList<dtoLop>();
	ModelLop mdl = new ModelLop();
	dslop = mdl.GetDSLop();
%>
<body>
	<div class="container" style = "padding-top:30px;">
		<div class="row">
			<div class="col-md-8">
				<h3>Danh sách lớp</h3>
				<table id="tpost"
					class="table table-striped table-bordered table-hover "
					width="100%">
					<thead>
						<tr>
							<th>Lớp</th>
							<th>Sỉ số</th>
							<th>Giáo viên</th>
							<th>Năm học</th>
						</tr>
					</thead>
					<tbody>
						<%
							for(dtoLop lop : dslop){
								out.write("<tr><td><a href='"+request.getContextPath() + "/ControllerLop?lop=" + lop.getMaLop() + "'>"+ lop.getTenLop()+"</a></td>");
								out.write("<td>"+lop.getSiSo()+"</td>");
								out.write("<td>"+lop.getGiaoVien()+"</td>");
								out.write("<td>"+lop.getNamHoc()+"</td></tr>");
							}
						%>
					</tbody>
				</table>
			</div>
			<div class="col-md-4" style = "border-left: thin solid;border-left-color: black;">
				<div class = "form-group">
					<h3>Thêm lớp học</h3>
					<form role = "form form-inline" class = "form" action="ControllerDSLop" method = "POST">
						<label for = "txtLop">Tên lớp</label>
						<input required class="form-control" id = "txtLop" name = "txtLop" type="text" placeholder = "1A">
						<label for = "txtGV">Giáo viên</label>
						<input required class="form-control" id = "txtGV" name = "txtGV" type="text" placeholder = "Nguyễn Thanh Anh Tuyên">
						<label for = "txtss">Sỉ số</label>
						<input required class="form-control" id = "txtss" name = "txtss" type="number" placeholder = "30">
						<label for = "txtnh">Năm học</label>
						<input required class="form-control" id = "txtnh" name = "txtnh" type="text" placeholder = "2015">
						<input class = "form-control btn btn-primary" style = "margin-top:10px;" type = "submit" name = "btnSubmit" value = "Thêm lớp">
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