package OrangeHRM;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class SupportPage {
	
	WebDriver driver ;
	
  @Test
  public void Support_Page() {
	  
	  WebElement Username = driver.findElement(By.xpath("//input[@placeholder='Username']"));
      Username.sendKeys("Admin");
      WebElement Password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
      Password.sendKeys("admin123");
      WebElement Login = driver.findElement(By.xpath("//button[@type='submit']"));
      Login.click();
	  
	  WebElement performance = driver.findElement(By.xpath("(//a[@class='oxd-main-menu-item'])[7]"));
	  performance.click();
	  
	  WebElement profile = driver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']"));
	  profile.click();
	  
	  WebElement Support = driver.findElement(By.xpath("//a[@href=\"/web/index.php/help/support\"]"));
	  Support.click();
	  
	  //Verify that the support page is visible
	  String Expected_Title = "OrangeHRM";
	  String Actual_Title = driver.getTitle();
	  Assert.assertEquals(Expected_Title, Actual_Title);
	  
  }
  
  
  @BeforeMethod
  public void beforeMethod() {
	  
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}
