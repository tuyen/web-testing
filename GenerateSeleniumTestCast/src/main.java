import java.util.Random;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ModelConnection con = new ModelConnection();

//		TestCaseLinkClick.genHTMLFile(con);
		TestCaseChuyenLop.genHTMLFile(con);
//		TestInsertHS.genHTMLFile(con);
//		addHS(con);
	}

	private static void addHS(ModelConnection con) {
		Random r = new Random();
		for (int i = 0; i < 1000; i++) {
			String hoten = AutoGen.getName(r);
			String ngaysinh = AutoGen.getNgaySinh(r);
			String gioitinh = AutoGen.getGioiTinh(r);
			String dantoc = AutoGen.getDanToc(r);
			String tongiao = AutoGen.getTonGiao(r);
			String diachi = AutoGen.getDiaChi(r);
			String sdt = "01284739588";
			String sql = "INSERT INTO `hocsinh`(`hoten`, `ngaysinh`, `gioitinh`, `dantoc`, `tongiao`, `diachi`, `sdt`) VALUES ('"
					+ hoten
					+ "','"
					+ ngaysinh
					+ "','"
					+ gioitinh
					+ "','"
					+ dantoc
					+ "','"
					+ tongiao
					+ "','"
					+ diachi
					+ "','"
					+ sdt
					+ "')";
			if (con.connect()) {
				con.write(sql);
				con.close();
			}
		}
	}
}
