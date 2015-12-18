package unit_test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import Model.ModelDiem;
import dto.dtoDiem;

public class ModelDiemTest
{

	@Test
	public void testModelDiem()
	{
		ModelDiem md = new ModelDiem();
		assertNotNull("ModelDiemTest/testModelDiem",md);
	}
	/**
	 * nhap sai ma lop va ma hoc sinh
	 */
	@Test
	public void testCreate4()
	{
		ModelDiem md = new ModelDiem();
		assertTrue("ModelDiemTest/testCreate4", md.create("qweqweqwe1", "2weqweqwe"));
	}
	/**
	 * truong hop sai ma hoc sinh 
	 */
	@Test
	public void testCreate1()
	{
		ModelDiem md = new ModelDiem();
		assertTrue("ModelDiemTest/testCreate1", md.create("qweqweqwe1", "1"));
	}
	/**
	 * truong hop sai ma lop
	 */
	@Test
	public void testCreate2()
	{
		ModelDiem md = new ModelDiem();
		assertTrue("ModelDiemTest/testCreate2", md.create("72", "2weqweqwe"));
	}
	/**
	 * truong hop input dung nhung trong database da co nen k insert duoc
	 */
	@Test
	public void testCreate3()
	{
		ModelDiem md = new ModelDiem();
		assertTrue("ModelDiemTest/testCreate3", md.create("72", "1"));
	}
	/**
	 * truong hop trong database khong co du lieu va input dung
	 */
	@Test
	public void testCreate()
	{
		ModelDiem md = new ModelDiem();
		assertTrue("ModelDiemTest/testCreate", md.create("72", "3"));
	}
	/**
	 * truong hop input rong
	 */
	@Test
	public void testCreate5()
	{
		ModelDiem md = new ModelDiem();
		assertTrue("ModelDiemTest/testCreate3", md.create("", ""));
	}
	/**
	 * truong hop input hop le (nhap vao so)
	 */
	@Test
	public void testGetDiemStringString()
	{
		ModelDiem md = new ModelDiem();
		dtoDiem dtodiem = md.getDiem("1123456789", "12345678");
		assertNotNull("ModelDiemTest/testGetDiemStringString",dtodiem);
	}
	/**
	 * truong hop input rong
	 */
	@Test
	public void testGetDiemStringString1()
	{
		ModelDiem md = new ModelDiem();
		dtoDiem dtodiem = md.getDiem("", "");
		assertNotNull("ModelDiemTest/testGetDiemStringString1",dtodiem);
	}
	/**
	 * truong hop input k hop le
	 */
	@Test
	public void testGetDiemStringString2()
	{
		ModelDiem md = new ModelDiem();
		dtoDiem dtodiem = md.getDiem("wertyu", "fsvjbkajs");
		assertNotNull("ModelDiemTest/testGetDiemStringString2",dtodiem);
	}
	/**
	 * truong hop input ma lop khong hop le
	 */
	@Test
	public void testGetDiemStringString3()
	{
		ModelDiem md = new ModelDiem();
		dtoDiem dtodiem = md.getDiem("72", "tnmads");
		assertNotNull("ModelDiemTest/testGetDiemStringString3",dtodiem);
	}
	/**
	 * truong hop input ma ma hoc sinh khong hop le
	 */
	@Test
	public void testGetDiemStringString4()
	{
		ModelDiem md = new ModelDiem();
		dtoDiem dtodiem = md.getDiem("qwdugqiwdh", "1");
		assertNotNull("ModelDiemTest/testGetDiemStringString4",dtodiem);
	}
	/**
	 * input hop le (ma hoc sinh co trong database)
	 */
	@Test
	public void testGetDiemString()
	{
		ModelDiem md = new ModelDiem();
		List<dtoDiem> dsd = md.getDiem("72");		
		int size = dsd.size();
		assertNotNull("ModelDiemTest/testGetDiemString",dsd);
		assertNotEquals("ModelDiemTest/testGetDiemString",0, size);
	}

	/**
	 * input khong co trong database
	 */
	@Test
	public void testGetDiemString1()
	{
		ModelDiem md = new ModelDiem();
		List<dtoDiem> dsd = md.getDiem("qwertyuio");		
		int size = dsd.size();
		assertNotNull("ModelDiemTest/testGetDiemString1",dsd);
		assertNotEquals("ModelDiemTest/testGetDiemString1",0, size);
	}
	/**
	 * input ky tu rong
	 */
	@Test
	public void testGetDiemString2()
	{
		ModelDiem md = new ModelDiem();
		List<dtoDiem> dsd = md.getDiem("");		
		int size = dsd.size();
		assertNotNull("ModelDiemTest/testGetDiemString2",dsd);
		assertNotEquals("ModelDiemTest/testGetDiemString2",0, size);
	}
	/**
	 * input ma hoc sinh va ma lop co trong database
	 */
	@Test
	public void testUpdateDiem()
	{
		ModelDiem md = new ModelDiem();
		dtoDiem dtodiem = new dtoDiem();
		dtodiem.setMaHS("72");
		dtodiem.setMaLop("1");
		dtodiem.setTapLamVan("1");
		dtodiem.setTiengViet("1");
		dtodiem.setToan("1");
		assertNotEquals("ModelDiemTest/testUpdateDiem",0, md.updateDiem(dtodiem));
	}
	/**
	 * input ma hoc sinh bat ki
	 */
	@Test
	public void testUpdateDiem1()
	{
		ModelDiem md = new ModelDiem();
		dtoDiem dtodiem = new dtoDiem();
		dtodiem.setMaHS("dfghjkl;a");
		dtodiem.setMaLop("1");
		dtodiem.setTapLamVan("1");
		dtodiem.setTiengViet("1");
		dtodiem.setToan("1");
		assertNotEquals("ModelDiemTest/testUpdateDiem1",0, md.updateDiem(dtodiem));
	}
	/**
	 * input ma lop bat ki
	 */
	@Test
	public void testUpdateDiem2()
	{
		ModelDiem md = new ModelDiem();
		dtoDiem dtodiem = new dtoDiem();
		dtodiem.setMaHS("72");
		dtodiem.setMaLop("4567890");
		dtodiem.setTapLamVan("1");
		dtodiem.setTiengViet("1");
		dtodiem.setToan("1");
		assertNotEquals("ModelDiemTest/testUpdateDiem2",0, md.updateDiem(dtodiem));
	}

	/**
	 * input ma hoc sinh va ma lop co trong database va diem la rong
	 */
	@Test
	public void testUpdateDiem3()
	{
		ModelDiem md = new ModelDiem();
		dtoDiem dtodiem = new dtoDiem();
		dtodiem.setMaHS("72");
		dtodiem.setMaLop("1");
		dtodiem.setTapLamVan("1");
		dtodiem.setTiengViet("");
		dtodiem.setToan("");
		assertNotEquals("ModelDiemTest/testUpdateDiem3",0, md.updateDiem(dtodiem));
	}
	/**
	 * input rong
	 */
	@Test
	public void testUpdateDiem4()
	{
		ModelDiem md = new ModelDiem();
		dtoDiem dtodiem = new dtoDiem();
		dtodiem.setMaHS("");
		dtodiem.setMaLop("");
		dtodiem.setTapLamVan("");
		dtodiem.setTiengViet("");
		dtodiem.setToan("");
		assertNotEquals("ModelDiemTest/testUpdateDiem4",0, md.updateDiem(dtodiem));
	}
}
