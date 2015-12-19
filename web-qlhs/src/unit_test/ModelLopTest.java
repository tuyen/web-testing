package unit_test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import dto.dtoLop;
import Model.ModelLop;

public class ModelLopTest {

	ModelLop mdl = new ModelLop();
	@Test
	public void testModelLop() {
		
		assertNotNull("ModelLopTest/testModelLop ", mdl);
	}

	@Test
	public void testGetDSLop() {
		assertNotNull("ModelLopTest/testModelLop ", mdl);
		List<dtoLop> dsl1 = mdl.GetDSLop();		
		assertNotNull("ModelLopTest/testGetDSLop ", dsl1);
		dtoLop lop = new dtoLop();
		lop.setGiaoVien("Ngx Thanh Anh Tran Trui Trui");
		lop.setMaLop("122");
		lop.setNamHoc("2015");
		lop.setSiSo("10");
		lop.setTenLop("Lop 3A");		
		assertEquals(1,mdl.AddLop(lop));
		List<dtoLop> dsl2 = mdl.GetDSLop();		
		assertNotNull("ModelLopTest/testGetDSLop ", dsl2);
		assertEquals("ModelLopTest/testGetDSLop ",dsl1.size() + 1, dsl2.size());
	}

	@Test
	public void testGetLop() {
		dtoLop lop = mdl.GetLop("1");
		assertNotNull("ModelLopTest/testGetLop ", lop);
		assertEquals("ModelLopTest/testGetLop ","Nguyễn Thanh Anh Tuyên", lop.getGiaoVien());
	}

	@Test
	public void testGetLop1() {
		dtoLop lop = mdl.GetLop("a");
		assertNotNull("ModelLopTest/testGetLop1 ", lop);
		assertEquals("ModelLopTest/testGetLop1 ","Nguyễn Thanh Anh Tuyên", lop.getGiaoVien());
	}
	
	@Test
	public void testGetLop2() {
		dtoLop lop = mdl.GetLop("'--1");
		assertNotNull("ModelLopTest/testGetLop2 ", lop);
		assertEquals("ModelLopTest/testGetLop2 ","Nguyễn Thanh Anh Tuyên", lop.getGiaoVien());
	}
	
	@Test
	public void testAddLop() {
		dtoLop lop = new dtoLop();
		lop.setGiaoVien("Nguyeenx Thanh Anh Tran Trui Trui");
		lop.setMaLop("123");
		lop.setNamHoc("2015");
		lop.setSiSo("100");
		lop.setTenLop("Lop mot A");		
		assertEquals("ModelLopTest/testAddLop ",1,mdl.AddLop(lop));
	}
	
	@Test
	public void testAddLop1() {
		dtoLop lop = new dtoLop();
		lop.setGiaoVien("Nguyeenx Thanh Anh Tran Trui Trui");
		lop.setMaLop("acb");
		lop.setNamHoc("c15");
		lop.setSiSo("10d");
		lop.setTenLop("Lop mot A");		
		assertEquals("ModelLopTest/testAddLop1 ",1,mdl.AddLop(lop));
	}

	@Test
	public void testAddLop2() {
		dtoLop lop = new dtoLop();
		lop.setGiaoVien("Nguyeenx '--Thanh Anh Tran Trui Trui");
		lop.setMaLop("1");
		lop.setNamHoc("15");
		lop.setSiSo("10");
		lop.setTenLop("Lop mot A");		
		assertEquals("ModelLopTest/testAddLop2 ",1,mdl.AddLop(lop));
	}
}
