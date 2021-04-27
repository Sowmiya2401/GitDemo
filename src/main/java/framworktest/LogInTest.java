package framworktest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInTest {
	
	WebDriver driver;
	public LogInTest(WebDriver driver)
	{
		this.driver = driver;
	}

	By userid = By.xpath("//input[@name='uid']");
	By password = By.cssSelector("input[type='password']");
	By login = By.name("btnLogin");
	
	By newCustomer = By.linkText("New Customer");
	By name = By.name("name");
	By genderMale = By.xpath("//input[@value='m']");
	By genderFemale = By.xpath("//input[@value='f']");
	By dob = By.id("dob");
	By addr = By.name("addr");
	By city = By.name("city");
	By state = By.name("state");
	By pin = By.name("pinno");
	By mobno = By.name("telephoneno");
	By emailid = By.name("emailid");
	By pwd = By.name("password");
	By submit = By.name("sub");
	By register = By.linkText("REGISTER");
	
	public WebElement userid()
	{
		return driver.findElement(userid);
		
	}
	public WebElement  password()
	{
		return driver.findElement(password);
	}
	public WebElement login()
	{
		return driver.findElement(login);	
	}
	
	
	public WebElement newCustomer()
	{
		return driver.findElement(newCustomer);
	}
	public WebElement name()
	{
		return driver.findElement(name);
	}
	public WebElement genderM()
	{
		return driver.findElement(genderMale);
	}
	public WebElement genderF()
	{
		return driver.findElement(genderFemale);
	}
	public WebElement dob()
	{
		return driver.findElement(dob);
	}
	public WebElement addr()
	{
		return driver.findElement(addr);
	}
	public WebElement city()
	{
		return driver.findElement(city);
	}
	public WebElement state()
	{
		return driver.findElement(state);
	}
	public WebElement pin()
	{
		return driver.findElement(pin);
	}
	public WebElement mobno()
	{
		return driver.findElement(mobno);
	}
	public WebElement emailid()
	{
		return driver.findElement(emailid);
	}
	public WebElement pwd()
	{
		return driver.findElement(pwd);
	}
	public WebElement submit()
	{
		return driver.findElement(submit);
	}
	public WebElement register()
	{
		return driver.findElement(register);
	}
}
