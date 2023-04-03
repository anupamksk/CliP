package testngpracctice;

import org.testng.annotations.Test;
@Test
public class DependsOnMethodsArgument {
	
	@Test
	public void firstExecution() {
		int[]a=new int[2];
		System.out.println(a[2]);
		System.out.println("FirstExecution sampanna");
	}
	@Test(dependsOnMethods = "firstExecution")
	public void SecondExecution() {
		
		System.out.println("SecondExcecution sampanna");
	}

}
