package unit_test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import dto.dtoHocSinh;
import Model.ModelHS;

public class ModelHSTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testModelHS() {
		ModelHS model = new ModelHS();		
		assertNotNull("ModelHSTest/testModelHS khong the khoi tao doi tuong", model);
	}

	
	
	@Test
	public void testAdd() {
		ModelHS model = new ModelHS();		
		dtoHocSinh hs = new dtoHocSinh();
		assertFalse("ModelHSTest.testAdd() - sai khi them doi tuong hs", model.add(hs));		
		
	}
	
	@Test
	public void testAdd1() {
		ModelHS model = new ModelHS();
		
		dtoHocSinh hs = new dtoHocSinh();
		hs.setLop("1");
		assertTrue("ModelHSTest.testAdd1() - sai khi them doi tuong hs", model.add(hs));				
	}
	
	
	@Test
	public void testAdd2() {
		ModelHS model = new ModelHS();
		
		dtoHocSinh hs = new dtoHocSinh();
		hs.setLop("1");
		hs.setHoTen("Tran Nhu Luan");
		assertTrue("ModelHSTest.testAdd2() - sai khi them doi tuong hs", model.add(hs));				
	}
	
	
	@Test
	public void testAdd3() {
		ModelHS model = new ModelHS();
		
		dtoHocSinh hs = new dtoHocSinh();
		hs.setLop("1");
		hs.setHoTen("Tran Nhu Luan");
		hs.setNgaySinh("26/05/1994");
		assertTrue("ModelHSTest.testAdd3() - sai khi them doi tuong hs", model.add(hs));				
	}
	
	
	@Test
	public void testAdd4() {
		ModelHS model = new ModelHS();
		
		dtoHocSinh hs = new dtoHocSinh();
		hs.setLop("1");
		hs.setHoTen("Tran Nhu Luan");
		hs.setNgaySinh("26/05/1994");
		hs.setGioiTinh("Nam");
		assertTrue("ModelHSTest.testAdd4() - sai khi them doi tuong hs", model.add(hs));				
	}
	
	
	@Test
	public void testAdd5() {
		ModelHS model = new ModelHS();
		
		dtoHocSinh hs = new dtoHocSinh();
		hs.setLop("1");
		hs.setHoTen("Tran Nhu Luan");
		hs.setNgaySinh("26/05/1994");
		hs.setGioiTinh("Nam");
		hs.setDanToc("Kinh");
		assertTrue("ModelHSTest.testAdd5() - sai khi them doi tuong hs", model.add(hs));				
	}
	
	
	@Test
	public void testAdd6() {
		ModelHS model = new ModelHS();
		
		dtoHocSinh hs = new dtoHocSinh();
		hs.setLop("1");
		hs.setHoTen("Tran Nhu Luan");
		hs.setNgaySinh("26/05/1994");
		hs.setGioiTinh("Nam");
		hs.setDanToc("Kinh");
		hs.setTonGiao("Thien chua giao");
		assertTrue("ModelHSTest.testAdd6() - sai khi them doi tuong hs", model.add(hs));				
	}
	
	
	@Test
	public void testAdd7() {
		ModelHS model = new ModelHS();
		
		dtoHocSinh hs = new dtoHocSinh();
		hs.setLop("1");
		hs.setHoTen("Tran Nhu Luan");
		hs.setNgaySinh("26/05/1994");
		hs.setGioiTinh("Nam");
		hs.setDanToc("Kinh");
		hs.setTonGiao("Thien chua giao");
		assertTrue("ModelHSTest.testAdd7() - sai khi them doi tuong hs", model.add(hs));				
	}
	
	@Test
	public void testAdd8() {
		ModelHS model = new ModelHS();
		
		dtoHocSinh hs = new dtoHocSinh();
		hs.setLop("1");
		hs.setHoTen("Tran Nhu Luan");
		hs.setNgaySinh("26/05/1994");
		hs.setGioiTinh("Nam");
		hs.setDanToc("Kinh");
		hs.setTonGiao("Thien chua giao");
		hs.setSdt("000000000");
		hs.setDiaChi("Binh Duong/ Ba Ria Vung Tau");
		assertTrue("ModelHSTest.testAdd8() - sai khi them doi tuong hs", model.add(hs));				
	}
	
	@Test
	public void testAdd9() {
		ModelHS model = new ModelHS();
		
		dtoHocSinh hs = new dtoHocSinh();
		hs.setLop("1");
		hs.setHoTen("Tran Nhu Luan");
		hs.setNgaySinh("26/05/1994");
		hs.setGioiTinh("Nam");
		hs.setDanToc("Kinh");
		hs.setTonGiao("Thien chua giao");
		hs.setSdt("000000000'--");
		hs.setDiaChi("sss");
		assertFalse("ModelHSTest.testAdd9() - sai khi them doi tuong hs", model.add(hs));				
	}
	
	
	@Test
	public void testAdd10() {
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
					
	@Test
	public void testGetDSHS() {
		ModelHS model = new ModelHS();
		List<dtoHocSinh> data = model.getDSHS();
		assertNotNull("ModelHSTest/testGetDSHS - tra ve null",data);
		assertTrue("ModelHSTest/testGetDSHS - tra ve tap du lieu rong", data.size() > 0);
	}

	@Test
	public void testGetDSHSString() {
		ModelHS model = new ModelHS();
		List<dtoHocSinh> data = model.getDSHS("");
		assertNull("ModelHSTest/testGetDSHSString - du lieu tra ve null", data);
	}
	
	@Test
	public void testGetDSHSString1() {
		ModelHS model = new ModelHS();
		List<dtoHocSinh> data = model.getDSHS("1");
		assertNotNull("ModelHSTest/testGetDSHSString - du lieu tra ve null", data);
	}
	
	
	@Test
	public void testGetDSHSString2() {
		ModelHS model = new ModelHS();
		List<dtoHocSinh> data = model.getDSHS("uhu");
		assertNotNull("ModelHSTest/testGetDSHSString - du lieu tra ve null", data);
		assertEquals("ModelHSTest/testGetDSHSString ",0, data.size());
	}
	
	@Test
	public void testGetDSHSString3() {
		ModelHS model = new ModelHS();
		List<dtoHocSinh> data = model.getDSHS("1 or 1=1");
		assertNotNull("ModelHSTest/testGetDSHSString - du lieu tra ve null", data);
		assertEquals("ModelHSTest/testGetDSHSString ",0, data.size());
	}

	@Test
	public void testGetHS() {
		ModelHS model = new ModelHS();
		dtoHocSinh hs = model.getHS("");
		assertNull("ModelHSTest/testGetHS - ket qua mong doi la null",hs);
	}
	
	@Test
	public void testGetHS1() {
		ModelHS model = new ModelHS();
		dtoHocSinh hs = model.getHS("70");
		assertNull("ModelHSTest/testGetHS1 tra ve null. mong doi la not null",hs);
	}
	
	@Test
	public void testGetHS2() {
		ModelHS model = new ModelHS();
		dtoHocSinh hs = model.getHS("a");
		assertNull("ModelHSTest/testGetHS1 tra ve khac null.",hs);
	}
	
	@Test
	public void testGetHS3() {
		ModelHS model = new ModelHS();
		dtoHocSinh hs = model.getHS("1 or 1=1");
		assertNull("ModelHSTest/testGetHS1 tra ve null. mong doi la null",hs);
	}

}
