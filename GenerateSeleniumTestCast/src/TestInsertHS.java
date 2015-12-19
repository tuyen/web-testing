import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestInsertHS {

	private static final String TEXT1 = "<?xml version='1.0' encoding='UTF-8'?><!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Strict//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd'><html xmlns='http://www.w3.org/1999/xhtml' xml:lang='en' lang='en'><head profile='http://selenium-ide.openqa.org/profiles/test-case'><meta http-equiv='Content-Type' content='text/html; charset=UTF-8' /><link rel='selenium.base' href='http://localhost:8080/web-qlhs/ControllerHome' /><title>";
	private static final String TEXT2 = "</title></head><body><table cellpadding='1' cellspacing='1' border='1'><thead><tr><td rowspan='1' colspan='3'>";
	private static final String TEXT3 = "</td></tr></thead><tbody><tr>	<td>open</td>	<td>/web-qlhs/ControllerDSHocSinh</td>	<td></td></tr><tr>	<td>type</td>	<td>name=hoten</td>	<td>";
	private static final String TEXT4 = "</td></tr><tr>	<td>type</td>	<td>name=ngaysinh</td>	<td>";
	private static final String TEXT5 = "</td></tr><tr>	<td>type</td>	<td>name=gioitinh</td>	<td>";
	private static final String TEXT6 = "</td></tr><tr>	<td>type</td>	<td>name=dantoc</td>	<td>";
	private static final String TEXT7 = "</td></tr><tr>	<td>type</td>	<td>name=tongiao</td>	<td>";
	private static final String TEXT8 = "</td></tr><tr>	<td>type</td>	<td>name=diachi</td>	<td>";
	private static final String TEXT9 = "</td></tr><tr>	<td>type</td>	<td>name=sdt</td>	<td>";
	private static final String TEXT10 = "</td></tr><tr>	<td>clickAndWait</td>	<td>name=btn_submit</td>	<td></td></tr><tr>	<td>assertText</td>	<td>css=p</td>	<td>Thêm thành công</td></tr></tbody></table></body></html>";

	public static void genHTMLFile(ModelConnection con) {
		FileWriter fWriter = null;
		BufferedWriter writer = null;

		Random r = new Random();
		for (int i = 0; i < 100; i++) {
			String title = "";
			try {
				title = "test-insert-hs-" + i;
				fWriter = new FileWriter(title + ".html");
				writer = new BufferedWriter(fWriter);
				writer.write(TEXT1 + title + TEXT2 + title + TEXT3
						+ AutoGen.getName(r) + TEXT4 + AutoGen.getNgaySinh(r)
						+ TEXT5 + AutoGen.getGioiTinh(r) + TEXT6
						+ AutoGen.getDanToc(r) + TEXT7 + AutoGen.getTonGiao(r)
						+ TEXT8 + AutoGen.getDiaChi(r) + TEXT9 + "0334939583"
						+ TEXT10);
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
