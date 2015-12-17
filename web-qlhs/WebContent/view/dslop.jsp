<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Danh sách lớp - Quản Lý Học Sinh</title>
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
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-8">
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
						<tr>
							<td>Lớp</td>
							<td>Sỉ số</td>
							<td>Giáo viên</td>
							<td>Năm học</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="col-md-4"></div>
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
												"order" : [ [ 0, "desc" ] ],
												"language" : {
													"lengthMenu" : "Hiển thị _MENU_ bài",
													"zeroRecords" : "Chưa có dữ liệu",
													"search" : "Tìm kiếm:",
													"info" : "Hiển thị từ _START_ đến _END_ trong tổng số _TOTAL_ bài",
													"infoEmpty" : "Chưa có dữ liệu",
													"infoFiltered" : "(Lọc từ _MAX_ bài)",
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