package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.dtoHocSinh;

public class ModelHS extends Model{

	public ModelHS() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public List<dtoHocSinh> getDSHS(String lop){
		List<dtoHocSinh> dshs = new ArrayList<dtoHocSinh>();
		String sql = "select * from hocsinh, diem where hocsinh.mahs = diem.mahs and malop = " + lop;
		if(connection.connect()){
			ResultSet rs = connection.read(sql);
			try {
				while(rs.next()){
					dtoHocSinh hs = new dtoHocSinh();
					hs.setDanToc(rs.getString("dantoc"));
					hs.setDiaChi(rs.getString("diachi"));
					hs.setGioiTinh(rs.getString("gioitinh"));
					hs.setHoTen(rs.getString("hoten"));
					hs.setMaHS(rs.getString("mahs"));
					hs.setNgaySinh(rs.getString("ngaysinh"));
					hs.setSdt(rs.getString("sdt"));
					hs.setTonGiao(rs.getString("tongiao"));
					dshs.add(hs);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return dshs;
	}
	
	public dtoHocSinh getHS(String mahs){
		String sql = "select * from hocsinh where hocsinh.mahs = " + mahs;
		dtoHocSinh hs = new dtoHocSinh();
		if(connection.connect()){
			ResultSet rs = connection.read(sql);
			try {
				while(rs.next()){
					hs.setDanToc(rs.getString("dantoc"));
					hs.setDiaChi(rs.getString("diachi"));
					hs.setGioiTinh(rs.getString("gioitinh"));
					hs.setHoTen(rs.getString("hoten"));
					hs.setMaHS(rs.getString("mahs"));
					hs.setNgaySinh(rs.getString("ngaysinh"));
					hs.setSdt(rs.getString("sdt"));
					hs.setTonGiao(rs.getString("tongiao"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return hs;
	}
}
