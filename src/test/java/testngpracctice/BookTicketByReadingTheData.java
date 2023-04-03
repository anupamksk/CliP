package testngpracctice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//How to use DataProvider Annotation
public class BookTicketByReadingTheData {
	//Run Same testcase multiple times with different test data
	@Test(dataProvider = "dataprovider_bookTicketTest")
public void bookTicketTest(String src, String dst) {
System.out.println("Book Ticket from " +src+" to " + dst );
}
	//This annotation will always return two dimensional object array
	//So that We can pass any data type
	//This annotation helps to create data driven framework for banking and ecommerce 
@DataProvider(parallel = true)
public Object[][] dataprovider_bookTicketTest() {
	//row count = 5 represents no of test has to run
	//coloumn count = 2 represents the no of arguments for each iteration has to be passed. 
	Object[][] objArr = new Object[5][2];
	objArr[0][0] = "Bangalore";
	objArr[0][1] = "Goa";
	
	objArr[1][0] = "Bangalore";
	objArr[1][1] = "Mysore";
	
	objArr[2][0] = "Bangalore";
	objArr[2][1] = "Mangalore";
	
	objArr[3][0] = "Bangalore";
	objArr[3][1] = "Hyderabad";
	
	objArr[4][0] = "Bangalore";
	objArr[4][1] = "Mumbai";
	return objArr;
}
}
