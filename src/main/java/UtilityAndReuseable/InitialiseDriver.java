package UtilityAndReuseable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InitialiseDriver {

	public static String filePath = System.getProperty("user.dir");
		  public static ChromeDriver driver;
		  
		  public InitialiseDriver(){
			System.setProperty("webdriver.chrome.driver",filePath+"\\Drivers\\chromedriver.exe");
		    driver = new ChromeDriver();
		  }
		  public static ChromeDriver getdriver(){
		    if (driver == null){
		    	System.setProperty("webdriver.chrome.driver",filePath+"\\Drivers\\chromedriver.exe");
		      driver = new ChromeDriver();
		      driver.manage().window().maximize();
		      return driver;
		    }else{
		      return driver;
		    }
		  }
	
	
}
