package test;

import java.io.File;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.apache.logging.log4j.*;
public class FileUploadTest extends LoginPage {
    
	private static Logger log = LogManager.getLogger(FileUploadTest.class.getName());
	public WebDriver driver;

	@Test
	public void file() throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\ChromeVersion\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.demo.guru99.com/test/upload/");
		WebDriverWait w = new WebDriverWait(driver, 5);
		w.until(ExpectedConditions.titleContains("File Upload Demo"));
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		WebElement filepath = driver.findElement(By.xpath("//input[@type='file']"));
		js.executeScript("arguments[0].click;", filepath);
		Thread.sleep(3000);
		Runtime.getRuntime().exec("C:\\Users\\Public\\Downloads\\upload.exe");
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.id("submitbutton")).click();
		String text = driver.findElement(By.cssSelector("h3#res.demo")).getText();
	}

	@Test
	public void downloadFile() throws IOException, InterruptedException {
		String downloadpath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\ChromeVersion\\chromedriver.exe");
		HashMap<String, Object> chromeprefs = new HashMap<String, Object>();
		chromeprefs.put("profile.default_content_settings.popups", 0);
		chromeprefs.put("download.default_directory", downloadpath);
		ChromeOptions ch = new ChromeOptions();
		ch.setExperimentalOption("prefs", chromeprefs);
		WebDriver driver = new ChromeDriver(ch);
		driver.get("https://online2pdf.com/text-to-pdf");
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		driver.findElement(By.className("browse_button")).click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec("C:\\Users\\sowmiya\\Documents\\text.exe");
		Thread.sleep(5000);
		driver.findElement(By.className("convert_button")).click();
		Thread.sleep(5000);
		File f = new File(downloadpath + "/converted.zip");
		if (f.exists()) {
			System.out.println("file exists");
			if (f.delete()) {
				System.out.println("file deleted");
			}
		}
	}

	@Test
	public void Ecommerce() throws IOException {
		driver = InitializeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		int j = 0;
		String[] names = { "Cucumber", "Beetroot", "Beans" };
		List vegginames = Arrays.asList(names);
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		for (int i = 0; i < products.size(); i++) {
			String[] productnames = products.get(i).getText().split("-");
			String formatted = productnames[0].trim();
			if (vegginames.contains(formatted)) {
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				j++;
				if (j == formatted.length()) {
					break;
				}
			}
		}
	}

	@Test
	public void search() throws IOException, InterruptedException {
		driver = InitializeDriver();
		int j = 0;
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
		driver.findElement(By.className("search-keyword")).sendKeys("ca");
		Thread.sleep(2000);
		List<WebElement> products = driver.findElements(By.xpath("//*[@id='root']/div/div[1]/div/div/h4"));
		while (j < products.size()) {

			String[] prd = products.get(j).getText().split("-");
			String onlynames = prd[0].trim();
			System.out.println(onlynames);
			j++;
			}
		driver.close();
	}
	@Test
	public void MultipleWindows() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\ChromeVersion\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		WebDriverWait w = new WebDriverWait(driver,5);
		w.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.cssSelector("h1.heading")), "Welcome to the-internet"));
		driver.manage().window().maximize();
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		driver.findElement(By.linkText("Multiple Windows")).click();
		driver.findElement(By.linkText("Click Here")).click();
		Thread.sleep(2000);
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parent = it.next();
		String child = it.next();
		driver.switchTo().window(child);
		System.out.println(driver.findElement(By.cssSelector("div.example")).getText());
		driver.switchTo().window(parent);
		System.out.println(driver.findElement(By.xpath("//h3[contains(text(),'window')]")).getText());
		driver.close();
	}
	@Test
	public void nestedFrames() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\ChromeVersion\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		WebDriverWait w = new WebDriverWait(driver,5);
		w.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.cssSelector("h1.heading")), "Welcome to the-internet"));
		driver.manage().window().maximize();
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)");
		driver.findElement(By.partialLinkText("Nested")).click();
		Thread.sleep(2000);
		driver.switchTo().frame("frame-top");
		driver.switchTo().frame("frame-middle");
		System.out.println(driver.findElement(By.id("content")).getText());
		driver.get("https://the-internet.herokuapp.com/drag_and_drop");
		Actions a = new Actions(driver);
		WebElement source = driver.findElement(By.id("column-b"));
		WebElement dest = driver.findElement(By.id("column-a"));
		a.dragAndDrop(source, dest).build().perform();
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.xpath("//*[@id='column-a']/header")).getText());
		driver.close();
	}
	@Test
	public void testRahul()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\ChromeVersion\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/telecom/index.html");
		Actions a = new Actions(driver);
		String onclick= Keys.chord(Keys.CONTROL,Keys.ENTER);
		driver.findElement(By.linkText("Add Customer")).sendKeys(onclick);
		Set<String> move = driver.getWindowHandles();
		Iterator<String> it = move.iterator();
		it.next();
		driver.switchTo().window(it.next());
		driver.manage().window().maximize();
		System.out.println(driver.findElement(By.id("pending")).isEnabled());
		System.out.println(driver.findElement(By.id("pending")).isSelected());
		a.moveToElement(driver.findElement(By.id("fname"))).click().keyDown(Keys.SHIFT).sendKeys("sowmiya").build().perform();
		a.moveToElement(driver.findElement(By.tagName("h3"))).contextClick().build().perform();
		
		
	}
	
}
