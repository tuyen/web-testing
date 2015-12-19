import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestCaseLinkClick {

	private static final String TEXT1 = "<?xml version='1.0' encoding='UTF-8'?><!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Strict//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd'><html xmlns='http://www.w3.org/1999/xhtml' xml:lang='en' lang='en'><head profile='http://selenium-ide.openqa.org/profiles/test-case'><meta http-equiv='Content-Type' content='text/html; charset=UTF-8' /><link rel='selenium.base' href='http://localhost:8080/web-qlhs/ControllerDSLop%22%20/%3E%3Ctitle%3Etestcase_themlop%3C/title%3E%3C/head%3E%3Cbody%3E%3Ctable%20cellpadding=%221%22%20cellspacing=%221%22%20border=%221%22%3E%3Cthead%3E%3Ctr%3E%3Ctd%20rowspan=%221%22%20colspan=%223' /><title>";
	private static final String TEXT2 = "</title></head><body><table cellpadding='1' cellspacing='1' border='1'><thead><tr><td rowspan='1' colspan='3'>";
	private static final String TEXT3 = "</td></tr></thead><tbody><tr>	<td>open</td>	<td>/web-qlhs/ControllerDSHocSinh</td>	<td></td></tr><tr>	<td>clickAndWait</td>	<td>link=";
	private static final String TEXT4 = "</td>	<td></td></tr><tr>	<td>assertText</td>	<td>css=p</td>	<td>Mã học sinh: ";
	private static final String TEXT5 = "</td></tr><tr>	<td>assertText</td>	<td>//p[2]</td>	<td>Ngày sinh: ";
	private static final String TEXT6 = "</td></tr><tr>	<td>assertText</td>	<td>//p[3]</td>	<td>Địa chỉ: ";
	private static final String TEXT7 = "</td></tr><tr>	<td>assertText</td>	<td>//p[4]</td>	<td>Dân tộc: ";
	private static final String TEXT8 = "</td></tr><tr>	<td>assertText</td>	<td>//p[5]</td>	<td>Giới tính: ";
	private static final String TEXT9 = "</td></tr><tr>	<td>assertText</td>	<td>//p[6]</td>	<td>Tôn giáo: ";
	private static final String TEXT10 = "</td></tr><tr>	<td>assertText</td>	<td>//p[7]</td>	<td>Số điện thoại: ";
	private static final String TEXT11 = "</td></tr></tbody></table></body></html>";
		
	private static List<dtoHocSinh> getListName(ModelConnection con) {		
		List<dtoHocSinh> dsTen = new ArrayList<dtoHocSinh>();
		dtoHocSinh hs;
		if (con.connect()) {
			String sql = "select * from hocsinh";
			ResultSet rs = con.read(sql);
			try {
				while (rs.next()) {
					 hs = new dtoHocSinh();
					hs.setHoTen(rs.getString("hoten"));
					hs.setDanToc(rs.getString("dantoc"));
					hs.setDiaChi(rs.getString("diachi"));
					hs.setGioiTinh(rs.getString("gioitinh"));					
					hs.setMaHS(rs.getString("mahs"));
					hs.setNgaySinh(rs.getString("ngaysinh"));
					hs.setSdt(rs.getString("sdt"));
					hs.setTonGiao(rs.getString("tongiao"));
					dsTen.add(hs);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			con.close();
		}
		return dsTen;
	}
	
	public static void genHTMLFile(ModelConnection con) {
		FileWriter fWriter = null;
		BufferedWriter writer = null;
		List<dtoHocSinh> dshs = getListName(con);
		int i = 1;
		String title = "";
		for (dtoHocSinh hs : dshs) {
			try {
				title = "test-click-link"+i++;
				fWriter = new FileWriter(title +".html");				
				writer = new BufferedWriter(fWriter);
				writer.write(TEXT1 + title + TEXT2 + title + TEXT3 + hs.getHoTen() + TEXT4 + hs.getMaHS() + TEXT5 + hs.getNgaySinh() + TEXT6 + hs.getDiaChi() + TEXT7 + hs.getDanToc() + TEXT8 + hs.getGioiTinh() + TEXT9 + hs.getTonGiao() + TEXT10 + hs.getSdt() + TEXT11);
				writer.newLine(); // this is not actually needed for html files
									// - can make your code more readable though
				writer.close(); // make sure you close the writer object
			} catch (Exception e) {
				// catch any exceptions here
			}
		}
	}
}
