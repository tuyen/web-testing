package intergration_test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import Model.ModelDiem;
import Model.ModelHS;
import Model.ModelLop;
import dto.dtoDiem;
import dto.dtoHocSinh;
import dto.dtoLop;

public class IntegrationTest {
	private static ModelHS hs;
	private static ModelLop lop;
	static ModelDiem diem;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		hs = new ModelHS();
		lop = new ModelLop();
		diem = new ModelDiem();
	}

	@Test
	public void test1() {
		
		int size =  hs.getDSHS().size();
		dtoHocSinh dto = new dtoHocSinh();
		dto.setDanToc("Kinh");
		dto.setDiaChi("Di An Binh Duong");
		dto.setGioiTinh("Nam");
		dto.setHoTen("Kinh Duong Vuong");
		dto.setLop("1B2");
		dto.setNgaySinh("22/12/1995");
		dto.setSdt("0976082217");
		dto.setTonGiao("Thien Chua Giao");						
		assertTrue("Khong them được h�?c sinh",hs.add(dto));		
		assertEquals("Danh sach hoc sinh khong du",size + 1, hs.getDSHS().size());		
	}
	
	@Test
	public void test2() {
		int size = lop.GetDSLop().size();
		dtoLop l = new dtoLop();
		l.setGiaoVien("Tran Minh Luan");
		l.setNamHoc("2014");
		l.setSiSo("44");
		l.setTenLop("1A1");
		
		
		assertTrue("Khong them được lớp",lop.AddLop(l) > 0);
		
		assertEquals("Danh sach lop khong du",size + 1,lop.GetDSLop().size());
	}

	
	@Test
	public void test3()
	{
	
		int c = lop.GetDSLop().size();
		dtoLop test = lop.GetDSLop().get(0);
		dtoLop to = lop.GetDSLop().get(c - 1);
		
		List<dtoHocSinh> ds = hs.getDSHS(test.getMaLop());
		int count = 0;
		for(dtoHocSinh i : ds)
		{
			dtoDiem d = diem.getDiem(i.getMaHS(),test.getMaLop());	
			assertNotNull("Khong lay được diem của "+ i.getMaHS() + " " + test.getMaLop() , d);
			int tb= Integer.parseInt(d.getTapLamVan())+Integer.parseInt(d.getTiengViet())+Integer.parseInt(d.getToan());
			if(tb >= 15){
				boolean rs = diem.create(i.getMaHS(), to.getMaLop());
				assertTrue("Không chuyển lớp cho h�?c sinh "+i.getMaHS() + " " + to.getMaLop(),rs);
				count++;
			}
		}	
	}
	
	@Test
	public void test4()
	{
		dtoHocSinh dto = new dtoHocSinh();
				
		dto.setDanToc("Kinh");
		dto.setDiaChi("Di An Binh Duong");
		dto.setGioiTinh("Nam");
		dto.setHoTen("Kinh Duong Vuong");
		dto.setLop("1B2");
		dto.setNgaySinh("22/12/1995");
		dto.setSdt("0976082217");
		dto.setTonGiao("Thien Chua Giao");	
		ModelHS model = new ModelHS();
		assertTrue("Không them được h�?c sinh ", model.add(dto));				
		
	}
	
	@Test
	public void test5() {
		ModelHS model = new ModelHS();
		
		dtoHocSinh hs = new dtoHocSinh();
		hs.setLop("10000000");
		hs.setHoTen("Tran Nhu Luan");
		hs.setNgaySinh("26/05/1994");
		hs.setGioiTinh("Nam");
		hs.setDanToc("Kinh");
		hs.setTonGiao("Thien chua giao");
		hs.setSdt("000000000'--");
		hs.setDiaChi("sss");
		assertTrue("ModelHSTest.testAdd10() - sai khi them doi tuong hs", model.add(hs));				
	}
}
