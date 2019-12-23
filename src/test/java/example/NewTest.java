package example;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class NewTest {		
    private WebDriver driver;		
	@Test				
	public void demoTest() {	
		driver.get("http://demo.guru99.com/test/guru99home/");  
		String title = driver.getTitle();				 
		Assert.assertTrue(title.contains("Demo Guru99 Page")); 	
		WebElement myElement= driver.findElement(By.linkText("Agile Project"));
		myElement.click();
		WebElement myUserID= driver.findElement(By.name("uid"));
		myUserID.sendKeys("1303");
		WebElement myPassword= driver.findElement(By.name("password"));
		myPassword.sendKeys("Guru99");
		WebElement loginBtn= driver.findElement(By.name("btnLogin"));
		loginBtn.click();
		
	}	
	@BeforeTest
	public void beforeTest() {	
	    driver = new ChromeDriver();  
	}		
	@AfterTest
	public void afterTest() {
		driver.quit();			
	}	
	
}