package unit_test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import dto.dtoHocSinh;

public class dtoHocSinhTest {

	private static dtoHocSinh hocsinh;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		hocsinh = new dtoHocSinh();
	}

	@Test
	public void testGetLop() {
		assertNotNull(hocsinh);
		hocsinh.setLop("1");
		assertTrue(hocsinh.getLop().equals("1"));
	}

	@Test
	public void testSetLop() {
		assertNotNull(hocsinh);
		hocsinh.setLop("1");
		assertTrue(hocsinh.getLop().equals("1"));
	}

	@Test
	public void testGetMaHS() {
		assertNotNull(hocsinh);
		hocsinh.setMaHS("1");
		assertTrue(hocsinh.getMaHS().equals("1"));
	}

	@Test
	public void testSetMaHS() {
		assertNotNull(hocsinh);
		hocsinh.setMaHS("1");
		assertTrue(hocsinh.getMaHS().equals("1"));
	}

	@Test
	public void testGetHoTen() {
		assertNotNull(hocsinh);
		hocsinh.setHoTen("1");
		assertTrue(hocsinh.getHoTen().equals("1"));
	}

	@Test
	public void testSetHoTen() {
		assertNotNull(hocsinh);
		hocsinh.setHoTen("1");
		assertTrue(hocsinh.getHoTen().equals("1"));
	}

	@Test
	public void testGetNgaySinh() {
		assertNotNull(hocsinh);
		hocsinh.setNgaySinh("1");
		assertTrue(hocsinh.getNgaySinh().equals("1"));
	}

	@Test
	public void testSetNgaySinh() {
		assertNotNull(hocsinh);
		hocsinh.setNgaySinh("1");
		assertTrue(hocsinh.getNgaySinh().equals("1"));
	}

	@Test
	public void testGetGioiTinh() {
		assertNotNull(hocsinh);
		hocsinh.setGioiTinh("1");
		assertTrue(hocsinh.getGioiTinh().equals("1"));
	}

	@Test
	public void testSetGioiTinh() {
		assertNotNull(hocsinh);
		hocsinh.setGioiTinh("1");
		assertTrue(hocsinh.getGioiTinh().equals("1"));
	}

	@Test
	public void testGetDanToc() {
		assertNotNull(hocsinh);
		hocsinh.setDanToc("1");
		assertTrue(hocsinh.getDanToc().equals("1"));
	}

	@Test
	public void testSetDanToc() {
		assertNotNull(hocsinh);
		hocsinh.setDanToc("1");
		assertTrue(hocsinh.getDanToc().equals("1"));
	}

	@Test
	public void testGetTonGiao() {
		assertNotNull(hocsinh);
		hocsinh.setTonGiao("1");
		assertTrue(hocsinh.getTonGiao().equals("1"));
	}

	@Test
	public void testSetTonGiao() {
		assertNotNull(hocsinh);
		hocsinh.setTonGiao("1");
		assertTrue(hocsinh.getTonGiao().equals("1"));
	}

	@Test
	public void testGetDiaChi() {
		assertNotNull(hocsinh);
		hocsinh.setDiaChi("1");
		assertTrue(hocsinh.getDiaChi().equals("1"));
	}

	@Test
	public void testSetDiaChi() {
		assertNotNull(hocsinh);
		hocsinh.setDiaChi("1");
		assertTrue(hocsinh.getDiaChi().equals("1"));
	}

	@Test
	public void testGetSdt() {
		assertNotNull(hocsinh);
		hocsinh.setSdt("1");
		assertTrue(hocsinh.getSdt().equals("1"));
	}

	@Test
	public void testSetSdt() {
		assertNotNull(hocsinh);
		hocsinh.setSdt("1");
		assertTrue(hocsinh.getSdt().equals("1"));
	}

}
