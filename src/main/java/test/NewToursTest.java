package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class NewToursTest {
	
	WebDriver driver;
	
	public NewToursTest(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By fname = By.name("firstName");
	By lname = By.name("lastName");
	By phone = By.name("phone");
	By email = By.id("userName");
	By address = By.name("address1");
	By city = By.name("city");
	By state = By.name("state");
	By postalcode = By.name("postalCode");
	By country = By.name("country");
	By usrname = By.id("email");
	By password = By.name("password");
	By confrmpwd = By.name("confirmPassword");
	By submit = By.name("submit");
	
	public WebElement fname()
	{
	     return driver.findElement(fname);
	}
	public WebElement lname()
	{
	     return driver.findElement(lname);
	}
	public WebElement phone()
	{
	     return driver.findElement(phone);
	}
	public WebElement email()
	{
	     return driver.findElement(email);
	}
	public WebElement address()
	{
	     return driver.findElement(address);
	}
	public WebElement city()
	{
	     return driver.findElement(city);
	}
	public WebElement state()
	{
	     return driver.findElement(state);
	}
	public WebElement postalcode()
	{
	     return driver.findElement(postalcode);
	}
	public WebElement country()
	{
	     return driver.findElement(country);
	}
	public WebElement usrname()
	{
	     return driver.findElement(usrname);
	}
	public WebElement password()
	{
	     return driver.findElement(password);
	}
	public WebElement confrmpwd()
	{
	     return driver.findElement(confrmpwd);
	}
	public WebElement submit()
	{
	     return driver.findElement(submit);
	}
	
	

}
