package generate_testcase;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Random r = new Random();
		
		RandomName name = new RandomName();
		List<dtoLop> ds = new ArrayList<dtoLop>();
		try {
			System.out.print("Tạo lớp \n");
			for (int k = 1; k < 5; k++) {
				for (int i = 65; i < 70; i++) {
					for (int j = 1; j < 5; j++) {
						dtoLop l = new dtoLop();
						l.setTenLop(k + ""+(char)i+ ""+ j );
						l.setGiaoVien(name.getName(r));
						l.setSiSo((Math.abs(r.nextInt()) % 10) + "");
						l.setNamHoc("2015");
						ds.add(l);
					}
				}
			}			
			System.out.print("Đọc file \n");
			FileReader in = new FileReader("data.html");
			BufferedReader reader = new BufferedReader(in);
			
			String base = "";
			String line = "";
			
			while((line = reader.readLine()) != null)
			{
				base += line;
			}
			System.out.print(base +" \n");		
			int order = 0;
			
			System.out.print("Ghi file \n");
			for(dtoLop lop : ds)
			{
				FileWriter outFileWriter = new FileWriter(new File("testcase/" + "testcase_themlop_"+order + ".html"));
				BufferedWriter buffer = new BufferedWriter(outFileWriter);
				String data_to_write = base;
				data_to_write += "<table cellpadding=\"1\" cellspacing=\"1\" border=\"1\"><thead>";
				data_to_write += "<tr><td rowspan=\"1\" colspan=\"3\">testcase_themlop" + order + "</td></tr></thead><tbody>";
				
				data_to_write += "<tr><td>open</td><td>/web-qlhs/ControllerDSLop</td><td></td></tr>";
				
				data_to_write+= "<tr><td>type</td><td>id=txtLop</td><td>"+lop.getTenLop()+"</td></tr>";
				
				data_to_write += "<tr><td>type</td><td>id=txtGV</td><td>"+lop.getGiaoVien()+"</td></tr>";
				
				data_to_write+="<tr><td>type</td><td>id=txtss</td><td>"+lop.getSiSo()+"</td></tr>";
				
				data_to_write+="<tr><td>type</td><td>id=txtnh</td><td>2015</td></tr>";
				
				data_to_write += "<tr><td>clickAndWait</td><td>name=btnSubmit</td><td></td></tr>";
				
				data_to_write += "<tr><td>assertText</td><td>id=result</td><td>exact:* Thêm thành công!</td></tr>";
				
				data_to_write+="</tbody></table></body></html>";
			
				order += 1;
				buffer.write(data_to_write);
				buffer.close();
				outFileWriter.close();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
