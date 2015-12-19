package generate_test_lop;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import dto.dtoLop;
import Model.ModelHS;
import Model.ModelLop;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Bat dau chay \n");
		ModelLop lop = new ModelLop();
		System.out.print("Lay danh sach lop \n");
		List<dtoLop> ds  = lop.GetDSLop();

		System.out.print(ds.size() + "Đọc file \n");
		FileReader in;

		String base = "";
		String line = "";
		try {
			in = new FileReader("data.html");
			BufferedReader reader = new BufferedReader(in);
			while((line = reader.readLine()) != null)
			{
				base += line;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
						
		System.out.print(base +" \n");		
		int order = 0;
		
		
		System.out.print("Ghi file \n");
		for(dtoLop l : ds)
		{
			String w = base;
			
			FileWriter outFileWriter;
			
			w += "<tr><td>open</td><td>/web-qlhs/ControllerLop?lop="+l.getMaLop()+"</td><td></td></tr>";
			
			w+="<tr><td>assertText</td><td>css=h3</td><td>Lớp "+l.getTenLop()+"</td></tr>";
			
			w+="<tr><td>assertText</td><td>css=p</td><td>Sỉ số: "+l.getSiSo()+"</td></tr>";
			
			w+="<tr><td>assertText</td><td>//p[2]</td><td>Giáo viên: "+l.getGiaoVien()+"</td></tr>";
			
			w+="<tr><td>assertText</td><td>//p[3]</td><td>Năm học: "+l.getNamHoc()+"</td></tr>";
			
			w+="</tbody></table></body></html>";
			
			
			try {
				outFileWriter = new FileWriter(new File("lop_testcase/" + "testcase_kiemtralop_"+order + ".html"));
				BufferedWriter buffer = new BufferedWriter(outFileWriter);
				
				buffer.write(w);
				System.out.print("Đã ghi file " + order);
				buffer.close();
				outFileWriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			order+=1;
			
		}
	}

}
