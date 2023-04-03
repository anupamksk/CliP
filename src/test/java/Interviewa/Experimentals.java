package Interviewa;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Experimentals {
	@Test(timeOut = 2000)
	public void testcase1() {
		        String str = "Hello";
		        for (int i = 0; i < str.length(); i++) {
		            int ascii = (int) str.charAt(i);
		            System.out.println("The ASCII value of " + str+ " is " +ascii);
		            

	            }
		      
    }
}
