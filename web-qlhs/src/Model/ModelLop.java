package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.dtoDiem;
import dto.dtoLop;

public class ModelLop extends Model {

	public ModelLop() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<dtoLop> GetDSLop() {
		List<dtoLop> dslop = new ArrayList<dtoLop>();
		String sql = "select * from lop";
		if (connection.connect()) {
			ResultSet rs = connection.read(sql);
			try {
				while (rs.next()) {
					dtoLop lop = new dtoLop();
					lop.setGiaoVien(rs.getString("giaovien"));
					lop.setMaLop(rs.getString("malop"));
					lop.setNamHoc(rs.getString("namhoc"));
					lop.setSiSo(rs.getString("siso"));
					lop.setTenLop(rs.getString("tenlop"));
					dslop.add(lop);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return dslop;
	}
	
	public dtoLop GetLop(String malop) {		
		String sql = "select * from lop where malop = " + malop;
		dtoLop lop = new dtoLop();
		if (connection.connect()) {
			ResultSet rs = connection.read(sql);
			try {
				while (rs.next()) {
					lop.setGiaoVien(rs.getString("giaovien"));
					lop.setMaLop(rs.getString("malop"));
					lop.setNamHoc(rs.getString("namhoc"));
					lop.setSiSo(rs.getString("siso"));
					lop.setTenLop(rs.getString("tenlop"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return lop;
	}

	public void AddLop(dtoLop lop) {
		String sql = "INSERT INTO `lop`(`tenlop`, `giaovien`, `namhoc`, `siso`) VALUES ('"
				+ lop.getTenLop()
				+ "','"
				+ lop.getGiaoVien()
				+ "','"
				+ lop.getNamHoc() + "'," + lop.getSiSo() + ")";
		if(connection.connect()){
			connection.write(sql);
			connection.close();
		}
	}
}
