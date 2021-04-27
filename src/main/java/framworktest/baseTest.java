package framworktest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class baseTest extends LoginPage{
	
	public static Properties prop = new Properties();
	
	
	@BeforeMethod
	public void launch() throws IOException
	{
		driver = InitializeDriver();
 		FileInputStream fis = new FileInputStream("C:\\Users\\sowmiya\\eclipse-workspace\\Sample\\data.properties");
 		prop.load(fis);
 		driver.get(prop.getProperty("url"));
 		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
 		driver.manage().window().maximize();
 		driver.manage().deleteAllCookies();
	}
	
   
	@Test(dataProvider="multipledata")
	public void loginurl(String username,String password) 
	{
		LogInTest lt = new LogInTest(driver);
		lt.userid().sendKeys(username);
		lt.password().sendKeys(password);
		lt.login().click();
		String title = "GTPL Bank Manager HomePage";
		Assert.assertEquals(driver.getTitle(), title);
	}
	
	@DataProvider
	public Object[][] multipledata() throws IOException
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\sowmiya\\eclipse-workspace\\Sample\\data.properties");
		prop.load(fis);
		Object[][] ar = new Object[3][2];
		ar[0][0] = prop.getProperty("userid");
		ar[0][1] = prop.getProperty("password");
		
		ar[1][0] = prop.getProperty("user");
		ar[1][1] = prop.getProperty("password");
		
		ar[2][0] = prop.getProperty("userid");
		ar[2][1] = prop.getProperty("pwd");
		return ar;
	}
	@Test
	public static void validLogin() throws IOException
	{
		
 		FileInputStream fis = new FileInputStream("C:\\Users\\sowmiya\\eclipse-workspace\\Sample\\data.properties");
 		prop.load(fis);
 		driver.get(prop.getProperty("url"));
 		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
 		driver.manage().window().maximize();
 		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		LogInTest lt = new LogInTest(driver);
		lt.userid().sendKeys(prop.getProperty("userid"));
		lt.password().sendKeys(prop.getProperty("password"));
		lt.login().click();
	}
	@AfterMethod
	public void quitBrowser()
	{
		driver.quit();
		
	}
   
	
}
