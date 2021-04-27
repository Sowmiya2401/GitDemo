package test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {
	
	public static WebDriver driver;

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\ChromeVersion\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://thefashionmessanger.com/");
		List<WebElement> links = driver.findElements(By.tagName("a"));
		SoftAssert a = new SoftAssert();
		for(WebElement link:links)
		{
				String url = link.getAttribute("href");
				 HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
				 conn.setRequestMethod("HEAD");
				 conn.connect();
				 int respcode = conn.getResponseCode();
				 System.out.println(respcode);
				 a.assertTrue(respcode<400,"The link with Text "+link.getText()+" is broken with code"+respcode);
		}
		
        a.assertAll();
       
	}

}
