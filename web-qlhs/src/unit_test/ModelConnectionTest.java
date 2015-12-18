package unit_test;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.mysql.jdbc.AssertionFailedException;

import Model.ModelConnection;

public class ModelConnectionTest {

	ModelConnection mdc = new ModelConnection();
	
	@Test
	public void testModelConnection() {
		
		assertNotNull("ModelConnectionTest/testModelConnection ", mdc);
	}

	@Test
	public void testConnect() {
		assertTrue("ModelConnectionTest/testConnect ", mdc.connect());
	}

	@Test
	public void testRead() {
		assertTrue("ModelConnectionTest/testRead ", mdc.connect());
		ResultSet rs = mdc.read("select gioitinh from hocsinh where mahs = 1");
		assertNotNull("ModelConnectionTest/testRead ", rs);
		
		try {
			rs.next();
			assertEquals("ModelConnectionTest/testRead ", "Nu", rs.getString("gioitinh"));
		} catch (SQLException e) {
		}
	}
	
	@Test
	public void testRead1() {
		assertTrue("ModelConnectionTest/testRead1 ", mdc.connect());
		
		ResultSet rs = mdc.read("select gioi tinh from hocsinh");
		assertNotNull("ModelConnectionTest/testRead1 ", rs);
		
		try {
			rs.next();
			assertEquals("ModelConnectionTest/testRead1 ", "Nam", rs.getString("gioitinh"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	public void testWrite() {
		assertTrue("ModelConnectionTest/testWrite ", mdc.connect());
		int x = mdc.write("update hocsinh set hoten = 'tuyen' where mahs = 1");
		assertEquals("ModelConnectionTest/testWrite ",1, x);
	}
	
	@Test
	public void testWrite1() {
		assertTrue("ModelConnectionTest/testWrite1 ", mdc.connect());
		int x = mdc.write("update hocsinh set hoten = 'tuyen' where mahs = 100");
		assertEquals("ModelConnectionTest/testWrite1 ",1, x);
	}
	
	@Test
	public void testWrite2() {
		assertTrue("ModelConnectionTest/testWrite2 ", mdc.connect());
		int x = mdc.write("update hocsinh set hoten = 'tuyen' wheremahs = 100");
		assertEquals("ModelConnectionTest/testWrite2 ",1, x);
	}

	@Test
	public void testClose() {
		assertTrue("ModelConnectionTest/testClose ", mdc.connect());
		mdc.close();
		int x = mdc.write("update hocsinh set hoten = 'tao lao' where mahs = 1");
		assertEquals("ModelConnectionTest/testClose ",0, x);
	}

}
