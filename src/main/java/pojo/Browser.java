package pojo;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {
	
	public static WebDriver openChrome(String url) 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\abhij\\Desktop\\Automation files\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver =new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));   // it waits for all xpath whether it is wrong xpath
		
		return driver;
		
	}

}
