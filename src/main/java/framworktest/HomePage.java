package framworktest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

public class HomePage extends LoginPage{

	 
	@Test
	public void addCustomer() throws IOException
	{
		
		driver = InitializeDriver();
		//base.validLogin();
		driver.get("http://www.demo.guru99.com/V4/manager/addcustomerpage.php");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		ExcelData exe = new ExcelData();
		ArrayList data = exe.getExcelData();
		LogInTest lt = new LogInTest(driver);
		lt.newCustomer().click();
		lt.name().sendKeys(new String[] {(String) data.get(0)});
		//lt.genderF().click();
		lt.dob().sendKeys(new String[] {(String) data.get(1)});
		lt.addr().sendKeys(new String[] {(String) data.get(2)});
		lt.city().sendKeys(new String[] {(String) data.get(3)});
		lt.state().sendKeys(new String[] {(String) data.get(4)});
		lt.pin().sendKeys(new String[] {(String) data.get(5)});
		lt.mobno().sendKeys(new String[] {(String) data.get(6)});
		lt.emailid().sendKeys(new String[] {(String) data.get(7)});
		lt.pwd().sendKeys(new String[] {(String) data.get(8)});
		lt.submit().click();
	}
}

