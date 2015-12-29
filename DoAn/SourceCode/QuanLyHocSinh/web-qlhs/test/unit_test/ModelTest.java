package unit_test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import Model.Model;
import Model.ModelDiem;

public class ModelTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testModel() {
		Model d = new ModelDiem();
		assertNotNull(d);
	}

}
