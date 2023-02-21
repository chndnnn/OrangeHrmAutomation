package OrangeHRM;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class Employ_performanance {
	
	WebDriver driver ;
  @Test
  public void EmployPerformanance() {
	  
	  WebElement Username = driver.findElement(By.xpath("//input[@placeholder='Username']"));
      Username.sendKeys("Admin");
      WebElement Password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
      Password.sendKeys("admin123");
      WebElement Login = driver.findElement(By.xpath("//button[@type='submit']"));
      Login.click();
	  
	  WebElement performance = driver.findElement(By.xpath("(//a[@class='oxd-main-menu-item'])[7]"));
	  performance.click();
	  
	  WebElement Employ_Tracker = driver.findElement(By.xpath("(//a[@class='oxd-topbar-body-nav-tab-item'])[2]"));
	  Employ_Tracker.click();
	  
	  WebElement Employ_Name = driver.findElement(By.xpath("//input[@placeholder=\"Type for hints...\"]"));
	  Employ_Name.sendKeys("o");
	  WebElement Select = driver.findElement(By.xpath("(//div[@role=\"option\"])[1]"));
	  Select.click();
	  
	  WebElement Include = driver.findElement(By.xpath("//div[@class=\"oxd-select-text-input\"]"));
	  Include.click();
	  WebElement Select1 = driver.findElement(By.xpath("(//div[@role=\"option\"])[2]"));
	  Select1.click();
	  
	  WebElement Search = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
	  Search.click();
	  
	  
	  boolean verify = driver.findElement(By.xpath("//div[@class=\"orangehrm-horizontal-padding orangehrm-vertical-padding\"]")).isDisplayed();
	  if(verify==true) {
		  System.out.println("The result is visible");
	  }
	  else {
		  System.out.println("The result is not visible");
	  }
	  
	  
	  
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
