package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


	

import dto.dtoDiem;

public class ModelDiem extends Model {


	public ModelDiem() {
		super();
		// TODO Auto-generated constructor stub
	}


	public boolean create(String id, String malop)
	{
		int row = 0;
		if(connection.connect())
		{
			String sql = "INSERT INTO `diem`(`mahs`, `malop`, `toan`, `tiengviet`, `taplamvan`) VALUES ("+id+","+malop+","+0+","+0+","+0+")";
			row = connection.write(sql);
			connection.close();
		}
		return row > 0;
	}

	public dtoDiem getDiem(String mahs, String malop) {
		dtoDiem d = new dtoDiem();
		String sql = "select * from diem where mahs = " + mahs + " and malop = " + malop;
		connection.connect();
		ResultSet rs = connection.read(sql);
		try {
			if (rs.next()) {
				d.setMaHS(rs.getString("mahs"));
				d.setMaLop(rs.getString("malop"));
				d.setTapLamVan(rs.getString("taplamvan"));
				d.setTiengViet(rs.getString("tiengviet"));
				d.setToan(rs.getString("toan"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d;
	}
	
	public List<dtoDiem> getDiem(String mahs) {
		List<dtoDiem> dsd = new ArrayList<dtoDiem>();
		dtoDiem d;
		String sql = "select * from diem where mahs = " + mahs;
		connection.connect();
		ResultSet rs = connection.read(sql);
		try {
			if (rs.next()) {
				d = new dtoDiem();
				d.setMaHS(rs.getString("mahs"));
				d.setMaLop(rs.getString("malop"));
				d.setTapLamVan(rs.getString("taplamvan"));
				d.setTiengViet(rs.getString("tiengviet"));
				d.setToan(rs.getString("toan"));
				dsd.add(d);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsd;
	}

	public int updateDiem(dtoDiem d) {
		String sql = "UPDATE `diem` SET `toan`=" + d.getToan()
				+ ",`tiengviet`=" + d.getTiengViet() + ",`taplamvan`="
				+ d.getTapLamVan() + " WHERE `diem`.`mahs` = " + d.getMaHS()
				+ " AND `diem`.`malop` = " + d.getMaLop();
		connection.connect();
		return connection.write(sql);		
	}
}
