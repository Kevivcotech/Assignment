package Pages;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import UtilityAndReuseable.InitialiseDriver;



public class Page extends InitialiseDriver {

	
	
	public static String filePath = System.getProperty("user.dir");
	protected static ChromeDriver driver = InitialiseDriver.getdriver();
//	public static  ChromeDriver InitialiseDriver()  {
//		System.setProperty("webdriver.chrome.driver",filePath+"\\Drivers\\chromedriver.exe");
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		return driver;
//	}
	
	public static void NavigateURL() throws Throwable {
		driver.get("https://go.discovery.com/");
		Thread.sleep(3000);
//		driver.navigate().to("https://go.discovery.com/");
	}
	
	public static void ScrollDown() throws Throwable {
		WebElement PopularShows = driver.findElementByXPath("//div[@class='popularShowsCarousel__main']//*[@class='popularShowsCarousel__header']");
		Actions actions = new Actions(driver);
		actions.moveToElement(PopularShows);
		actions.perform();
		Thread.sleep(3000);
		
	}
	
	public static void ClickOnArrowTillLastVideo() throws Throwable {
		try{
			while(driver.findElement(By.xpath("//div[@class='popularShowsCarousel__main']//i[@class='icon-arrow-right']")).isDisplayed())
			{
				driver.findElement(By.xpath("//div[@class='popularShowsCarousel__main']//i[@class='icon-arrow-right']")).click();
				Thread.sleep(1000);
			}
		}catch (Exception e){
			
		}
		finally {
			Thread.sleep(1000);
		}
		
	}
	
	public static void ClickOnExploreShowButton() throws Throwable {
		WebElement button = driver.findElementByXPath("//div[@class='popularShowsCarousel__main']//button[@tabindex='0']");
		Actions actions = new Actions(driver);
		actions.moveToElement(button);
		actions.perform();
		
		if(driver.findElement(By.xpath("//div[@class='popularShowsCarousel__main']//button[@tabindex='0']")).isDisplayed())
		{
			driver.findElement(By.xpath("//div[@class='popularShowsCarousel__main']//button[@tabindex='0']")).click();
		}
		Thread.sleep(10000);
	}
	
	public static void ClickOnShowMoreButton() throws Throwable {
		try{
			WebElement ShowMoreButton = driver.findElement(By.xpath("//div[@class='episodeList__container']//button[@class='episodeList__showMoreButton']"));
			
			Actions actions = new Actions(driver);
			actions.moveToElement(ShowMoreButton);
			actions.perform();
			if(ShowMoreButton.isDisplayed())
			{
				ShowMoreButton.click();
				actions.moveToElement(ShowMoreButton);
				actions.perform();
				Thread.sleep(4000);
				ShowMoreButton.click();
				actions.moveToElement(ShowMoreButton);
				actions.perform();
				Thread.sleep(4000);
				ShowMoreButton.click();
				actions.moveToElement(ShowMoreButton);
				actions.perform();
				Thread.sleep(4000);
				ShowMoreButton.click();
				actions.moveToElement(ShowMoreButton);
				actions.perform();
				Thread.sleep(10000);
			}
			
		}catch (Exception e){
			
		}
		finally {
			Thread.sleep(3000);
		}
		
	}
	
	public static void ExtractTitleAndDurationAndSaveInNewFile() throws IOException {
		WebElement ul= driver.findElement(By.xpath("//div[@class='episodeList__container']/ul[@class='episodeList__list']"));
		List<WebElement> allTitles= ul.findElements(By.xpath("//p[@class='episodeTitle']"));
		List<WebElement> allDuration= ul.findElements(By.xpath("//li//div[@class='infoRow']/div/p"));
		
		ArrayList<String> allTitlesString= new ArrayList<String>();
		ArrayList<String> allDurationString= new ArrayList<String>();
		
		for(WebElement selectLi: allTitles)
	    {
			allTitlesString.add(selectLi.getText());
	    }
		
		for(WebElement selectLi: allDuration)
	    {
			allDurationString.add(selectLi.getText());
	    }
		
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date date = new Date();
		 
		String date1= dateFormat.format(date);
//		date1=date1.replace("/", "");
//		date1=date1.replace(":", "");
//		date1=date1.replace(" ", "");
		
		String Filename=date1.replace("/", "").replace(":", "").replace(" ", "").concat(".txt");
		File file = new File(filePath+"\\OutPut"+"\\"+Filename);
		file.createNewFile();
		file.setWritable(true);
		FileWriter f = new FileWriter(file);
	    BufferedWriter b = new BufferedWriter(f);
	    int j =0;
	    String index="Initialsed Only";
	    for(int i=0; i<allTitlesString.size(); i++ )
	    {
	    	j=i;
	    	index=String.valueOf(j);
	    	b.write(index + "-> Title is: " + allTitlesString.get(i) + "Duration is: " + allDurationString.get(i));
	    	b.newLine();
	    }
	    b.close();
		
	}
	
	public static void CloseBrowser() {
		driver.quit();
	}
}
