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

public class DeletePost {
	
	WebDriver driver ;
  @Test
  public void Delete_Post() throws InterruptedException {
	  
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
      
      Thread.sleep(3000);
      
      WebElement Ellipsis = driver.findElement(By.xpath("(//button[@type=\"button\"])[7]"));
      Ellipsis.click();
      WebElement Delete = driver.findElement(By.xpath("(//li[@class=\"orangehrm-buzz-post-header-config-item\"])[1]"));
      Ellipsis.click();
      
  }
  @BeforeMethod
  public void beforeMethod() {
	  
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
  }

  @AfterMethod
  public void afterMethod() {
	  
	  driver.close();
  }

}
