package Experimental;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Interaction;

public class Action {
  public static void main(String[] args) {
	WebDriver driver= new ChromeDriver();
	Actions action= new Actions(driver);
}
}
