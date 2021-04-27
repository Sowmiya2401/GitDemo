package test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ResgisterTestCase extends LoginPage{
	
	public WebDriver driver;
	public static Properties prop;
	
	@BeforeMethod  
	public void Register() throws IOException 
	{
		driver = InitializeDriver();
		FileInputStream fis = new FileInputStream("C:\\Users\\sowmiya\\eclipse-workspace\\Sample\\inputs.properties");
		prop = new Properties();
 		prop.load(fis);
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	@Test(dataProvider="testData")
	public void registerInputs(String fname, String lname, String phone,String email,String address, String city,String state,String code,
			String country,String user,String pwd,String confpwd) throws IOException
	{
		
		NewToursTest nt = new NewToursTest(driver);
		nt.fname().sendKeys(fname);
		nt.lname().sendKeys(lname);
		nt.phone().sendKeys(phone);
		nt.email().sendKeys(email);
		nt.address().sendKeys(address);
		nt.city().sendKeys(city);
		nt.state().sendKeys(state);
		nt.postalcode().sendKeys(code);
		nt.country().sendKeys(country);
		nt.usrname().sendKeys(user);
		nt.password().sendKeys(pwd);
		nt.confrmpwd().sendKeys(confpwd);
		nt.submit().click();
	}
	@DataProvider
	public Object[][] testData() throws IOException
	{
		Testngsample ts = new Testngsample();
		Object[][] td = ts.getData();
		return td;
		
	}
    @AfterMethod
    public void quit()
    {
    	driver.close();
    }
}
