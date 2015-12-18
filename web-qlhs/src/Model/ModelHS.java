package Model;


import java.sql.ResultSet;
import java.sql.SQLException;

import dto.dtoHocSinh;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;




public class ModelHS extends Model{

	ModelConnection con = new ModelConnection();
	public ModelHS() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public boolean add(dtoHocSinh hs)
	{
		int x = 0;
		String id = "";
		ModelDiem diem = new ModelDiem();
		if(con.connect())
		{
			try {				
				String sql = "INSERT INTO `hocsinh`(`hoten`, `ngaysinh`, `gioitinh`, `dantoc`, `tongiao`, `diachi`, `sdt`) VALUES ('"+hs.getHoTen()+"','"+hs.getNgaySinh()+"','"+hs.getGioiTinh()+"','"+hs.getDanToc()+"','"+hs.getTonGiao()+"','"+hs.getDiaChi()+"','"+hs.getSdt()+"')";
				x = con.write(sql);	
				if(x > 0)
				{
					sql = "SELECT max(`mahs`) as `id` from `hocsinh`";
					ResultSet rs = con.read(sql);
					if(rs.next())
					{						
						id =  rs.getString("id");
						diem.create(id, hs.getLop());
					}
					
				}				
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			con.close();
		}
		return !id.equals("") && x > 0;
	}


	
	public List<dtoHocSinh> getDSHS(){
		List<dtoHocSinh> dshs = new ArrayList<dtoHocSinh>();
		String sql = "select * from hocsinh where 1";
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
