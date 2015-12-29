package unit_test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ModelConnectionTest.class, ModelHSTest.class,
		ModelLopTest.class })
public class AllTests {

}
