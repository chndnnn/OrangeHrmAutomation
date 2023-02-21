package OrangeHRM;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class PostNewsFeed {
	
	WebDriver driver ;
	
  @Test
  public void PostNews_Feed() {
	  
	  WebElement Username = driver.findElement(By.xpath("//input[@placeholder='Username']"));
      Username.sendKeys("Admin");
      WebElement Password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
      Password.sendKeys("admin123");
      WebElement Login = driver.findElement(By.xpath("//button[@type='submit']"));
      Login.click();
      
      WebElement Buzz = driver.findElement(By.xpath("(//a[@class='oxd-main-menu-item'])[10]"));
      Buzz.click();
      
      WebElement Text = driver.findElement(By.xpath("//textarea[@placeholder=\"What's on your mind?\"]"));
      Text.sendKeys("I am a software tester");
      WebElement Post = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
      Post.click();
      
	  
	  
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
	  driver.close() ;
  }

}
