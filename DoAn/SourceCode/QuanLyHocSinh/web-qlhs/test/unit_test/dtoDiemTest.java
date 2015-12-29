package unit_test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import dto.dtoDiem;

public class dtoDiemTest {

	private static dtoDiem diem;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		diem = new dtoDiem();
	}

	@Test
	public void testGetMaHS() {
		assertNotNull(diem);
		diem.setMaHS("1");
		assertTrue(diem.getMaHS().equals("1"));
	}

	@Test
	public void testSetMaHS() {
		assertNotNull(diem);
		diem.setMaHS("1");
		assertTrue(diem.getMaHS().equals("1"));
	}

	@Test
	public void testGetMaLop() {
		assertNotNull(diem);
		diem.setMaLop("1");
		assertTrue(diem.getMaLop().equals("1"));
	}

	@Test
	public void testSetMaLop() {
		assertNotNull(diem);
		diem.setMaLop("1");
		assertTrue(diem.getMaLop().equals("1"));
	}

	@Test
	public void testGetToan() {
		assertNotNull(diem);
		diem.setToan("1");
		assertTrue(diem.getToan().equals("1"));
	}

	@Test
	public void testSetToan() {
		assertNotNull(diem);
		diem.setToan("1");
		assertTrue(diem.getToan().equals("1"));		
	}

	@Test
	public void testGetTiengViet() {
		assertNotNull(diem);
		diem.setTiengViet("1");
		assertTrue(diem.getTiengViet().equals("1"));
	}

	@Test
	public void testSetTiengViet() {
		assertNotNull(diem);
		diem.setTiengViet("1");
		assertTrue(diem.getTiengViet().equals("1"));
	}

	@Test
	public void testGetTapLamVan() {
		assertNotNull(diem);
		diem.setTapLamVan("1");
		assertTrue(diem.getTapLamVan().equals("1"));
	}

	@Test
	public void testSetTapLamVan() {
		assertNotNull(diem);
		diem.setTapLamVan("1");
		assertTrue(diem.getTapLamVan().equals("1"));
	}

}
