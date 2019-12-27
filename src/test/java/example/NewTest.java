package example;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class NewTest {		
    private WebDriver driver;		
	@Test				
	public void demoTest() {	
		driver.get("http://demo.guru99.com/test/guru99home/");  
		driver.manage().window().maximize();
		String title = driver.getTitle();				 
		Assert.assertTrue(title.contains("Demo Guru99 Page")); 	
		WebElement myElement= driver.findElement(By.linkText("Agile Project"));
		if (driver instanceof JavascriptExecutor) {
	        ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", myElement);
	    }
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",myElement);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebElement myUserID= driver.findElement(By.name("uid"));
		myUserID.sendKeys("1303");
		WebElement myPassword= driver.findElement(By.name("password"));
		myPassword.sendKeys("Guru99");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebElement loginBtn= driver.findElement(By.name("btnLogin"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",loginBtn);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebElement message= driver.findElement(By.className("heading3"));
	    if (driver instanceof JavascriptExecutor) {
	        ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", message);
	    }
	    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	    WebElement logout= driver.findElement(By.linkText("Log out"));
	    if (driver instanceof JavascriptExecutor) {
	        ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", logout);
	    }
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();",logout);
	    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	    driver.switchTo().alert().accept();
	}	
	
	@Parameters({ "browser" })
	@BeforeTest
	public void beforeTest(String browser) throws Exception {
		
		String chromedriverPath="./src/main/resources/drivers/chromedriver";
		String iedriverPath="./src/main/resources/drivers/IEDriverServer.exe";
		String firefoxdriverPath="./src/main/resources/drivers/geckodriver";
		
		String OS =System.getProperty("os.name").toLowerCase();
		System.out.println(OS);
				if(OS.contains("win")) {				
				    chromedriverPath+=".exe";
				    firefoxdriverPath+=".exe";
				 } else {
					 System.out.println(chromedriverPath);
					 System.out.println(firefoxdriverPath);
					
				 }
		try {
	        if (browser.equalsIgnoreCase("firefox")) {
	            System.out.println(browser);
	            System.setProperty("webdriver.gecko.driver",firefoxdriverPath);
	            System.out.println(firefoxdriverPath);
	            driver = new FirefoxDriver();
	        } else if (browser.equalsIgnoreCase("chrome")) {
	            System.out.println(browser);
	            System.setProperty("webdriver.chrome.driver",chromedriverPath);
	            System.out.println(chromedriverPath);
	            driver = new ChromeDriver();
	        } else if (browser.equalsIgnoreCase("ie")) {
	        	System.out.println(browser);
	            System.setProperty("webdriver.ie.driver", iedriverPath);
	            System.out.println(iedriverPath);
	            driver = new InternetExplorerDriver();
	        }
	    } catch (WebDriverException e) {
	        System.out.println(e.getMessage());
	    }
	}		
	@AfterTest
	public void afterTest() {
		driver.quit();			
	}	
	
}