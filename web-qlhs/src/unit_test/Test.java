package unit_test;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Result rs = JUnitCore.runClasses(AllTests.class);
		int i = 1;
		try {
			Date d = new Date();
			FileWriter writer = new FileWriter(new File("F:/TEST_RESULT/TEST_" + d.getDate() +".txt" ));
			BufferedWriter buf = new BufferedWriter(writer);
			for(Failure f : rs.getFailures())
			{
				
				buf.write("Bug "+i +": \r\n");
				buf.write("Test header: " + f.getTestHeader() + "\r\n");
				buf.write("Message: " + f.getMessage() + "\r\n");			
				buf.write("Trace: " + f.getTrace() + "\r\n");
				buf.write("Description: " + f.getDescription() + "\r\n");
				buf.write("Exception: " + f.getException() + "\r\n");
				buf.write("----------------------------------------------------------\r\n\r\n");
				i++;
			}
			buf.close();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Failure f : rs.getFailures())
		{
			System.out.print("Bug "+i +":\n");
			System.out.print("Test header: " + f.getTestHeader() + "\n");
			System.out.print("Message: " + f.getMessage() + "\n");			
			System.out.print("Trace: " + f.getTrace() + "\n");
			System.out.print("Description: " + f.getDescription() + "\n");
			System.out.print("Exception: " + f.getException() + "\n");
			System.out.print("----------------------------------------------------------\n\n");
			i++;
		}
	}

}
