package unit_test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import dto.dtoLop;

public class dtoLopTest {

	static dtoLop lop;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		lop = new dtoLop();
	}

	@Test
	public void testGetMaLop() {
		assertNotNull("doi tuong lop phai khac null", lop);
		lop.setMaLop("1");		
		assertTrue("Hai ket qua tra ve khong nhu mong doi", lop.getMaLop().equals("1"));
	}

	@Test
	public void testSetMaLop() {
		assertNotNull("doi tuong lop phai khac null", lop);
		lop.setMaLop("1");				
		assertTrue("Hai ket qua tra ve khong nhu mong doi", lop.getMaLop().equals("1"));
	}

	@Test
	public void testGetTenLop() {
		
		assertNotNull("doi tuong lop phai khac null", lop);
		lop.setTenLop("1");				
		assertTrue("Hai ket qua tra ve khong nhu mong doi", lop.getMaLop().equals("1"));
	}

	@Test
	public void testSetTenLop() {
		assertNotNull("doi tuong lop phai khac null", lop);
		lop.setTenLop("1");		
		assertTrue("Hai ket qua tra ve khong nhu mong doi", lop.getTenLop().equals("1"));
	}

	@Test
	public void testGetGiaoVien() {
		assertNotNull("doi tuong lop phai khac null", lop);
		lop.setGiaoVien("1");				
		assertTrue("Hai ket qua tra ve khong nhu mong doi", lop.getGiaoVien().equals("1"));
	}

	@Test
	public void testSetGiaoVien() {
		assertNotNull("doi tuong lop phai khac null", lop);
		lop.setGiaoVien("1");				
		assertTrue("Hai ket qua tra ve khong nhu mong doi", lop.getGiaoVien().equals("1"));
	}

	@Test
	public void testGetNamHoc() {
		assertNotNull("doi tuong lop phai khac null", lop);
		lop.setNamHoc("1");				
		assertTrue("Hai ket qua tra ve khong nhu mong doi", lop.getNamHoc().equals("1"));
	}

	@Test
	public void testSetNamHoc() {
		assertNotNull("doi tuong lop phai khac null", lop);
		lop.setNamHoc("1");				
		assertTrue("Hai ket qua tra ve khong nhu mong doi", lop.getNamHoc().equals("1"));
	}

	@Test
	public void testGetSiSo() {
		assertNotNull("doi tuong lop phai khac null", lop);
		lop.setSiSo("1");				
		assertTrue("Hai ket qua tra ve khong nhu mong doi", lop.getSiSo().equals("1"));
	}

	@Test
	public void testSetSiSo() {
		assertNotNull("doi tuong lop phai khac null", lop);
		lop.setSiSo("1");				
		assertTrue("Hai ket qua tra ve khong nhu mong doi", lop.getSiSo().equals("1"));
	}

}
