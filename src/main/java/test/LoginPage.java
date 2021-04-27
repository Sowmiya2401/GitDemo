package test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {

	public static WebDriver driver;
	
	
	public WebDriver InitializeDriver() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\sowmiya\\eclipse-workspace\\Sample\\inputs.properties");
		prop.load(fis);
		String browser= prop.getProperty("browser");
		System.out.println(browser);
		if(browser.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\ChromeVersion\\chromedriver.exe");
		driver = new ChromeDriver();
	}
		else if(browser.equals("firefox"))
		{
			
		}
		else if(browser.equals("IE"))
		{
			
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver;
	}
	
	

}
