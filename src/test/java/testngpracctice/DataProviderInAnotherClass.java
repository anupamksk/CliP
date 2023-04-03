package testngpracctice;

import org.testng.annotations.Test;
//Read the Data from different class by @DataProvider Annotation 
public class DataProviderInAnotherClass {  
	@Test(dataProvider = "ticketData" , dataProviderClass = DataProviderClass.class  )
public void bookTicketTest(String src, String dest, int tickets) {
	System.out.println("execute source => " + src + ", Destiantions =>" +dest + ", No of Tickets => " +tickets);
}
}
