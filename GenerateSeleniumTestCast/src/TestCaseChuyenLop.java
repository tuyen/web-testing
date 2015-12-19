import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestCaseChuyenLop {

	private static final String TEXT1 = "<?xml version='1.0' encoding='UTF-8'?><!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Strict//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd'><html xmlns='http://www.w3.org/1999/xhtml' xml:lang='en' lang='en'><head profile='http://selenium-ide.openqa.org/profiles/test-case'><meta http-equiv='Content-Type' content='text/html; charset=UTF-8' /><link rel='selenium.base' href='http://localhost:8080/web-qlhs/ControllerHome' /><title>";
	private static final String TEXT2 = "</title></head><body><table cellpadding='1' cellspacing='1' border='1'><thead><tr><td rowspan='1' colspan='3'>";
	private static final String TEXT3 = "</td></tr></thead><tbody><tr>	<td>open</td>	<td>/web-qlhs/ControllerDSHocSinh</td>	<td></td></tr><tr>	<td>select</td>	<td>name=from</td>	<td>label=";
	private static final String TEXT4 = "</td></tr><tr>	<td>select</td>	<td>name=to</td>	<td>label=";
	private static final String TEXT5 = "</td></tr><tr>	<td>clickAndWait</td>	<td>name=btn_change</td>	<td></td></tr><tr>	<td>assertElementPresent</td>	<td>//p[2]</td>	<td></td></tr></tbody></table></body></html>";

	private static List<String> getListClass(ModelConnection con) {
		List<String> dsLop = new ArrayList<String>();
		if (con.connect()) {
			String sql = "select tenlop from lop";
			ResultSet rs = con.read(sql);
			try {
				while (rs.next()) {
					dsLop.add(rs.getString("tenlop"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			con.close();
		}
		return dsLop;
	}

	public static void genHTMLFile(ModelConnection con) {
		FileWriter fWriter = null;
		BufferedWriter writer = null;
		List<String> dsl = getListClass(con);

		String title = "";
		for (int i = 0; i < dsl.size(); i++) {
			for (int j = dsl.size() - 1; j >= 0; j--) {
				if (i != j)
					try {
						title = "test-chuyen-lop-" + dsl.get(i) + "-"
								+ dsl.get(j);
						fWriter = new FileWriter(title + ".html");
						writer = new BufferedWriter(fWriter);
						writer.write(TEXT1 + title + TEXT2 + title + TEXT3
								+ dsl.get(i) + TEXT4 + dsl.get(j) + TEXT5);
						writer.newLine(); // this is not actually needed for
											// html
											// files
											// - can make your code more
											// readable
											// though
						writer.close(); // make sure you close the writer object
					} catch (Exception e) {
						// catch any exceptions here
					}
			}
		}
	}
}
