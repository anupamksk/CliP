package datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadCommonData {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/commondata.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		String value = pobj.getProperty("password");
		System.out.println(value);
	}

}
