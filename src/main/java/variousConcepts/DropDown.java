package variousConcepts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;



public class DropDown {
	WebDriver driver;
	@Before
	public void Initialization() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.techfios.com/billing/?ng=admin/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test
	public void dropdown() {
		WebElement USERNAME_ELEMENT=driver.findElement(By.xpath("//input[@id='username']"));
		WebElement PASSWORD_ELEMENT=driver.findElement(By.id("password"));
		WebElement SIGNIN_ELEMENT=driver.findElement(By.xpath("//button[@name='login']"));
		By USERNAME_LOCATOR=(By.xpath("//input[@id='username']"));
		By PASSWORD_LOCATOR=(By.id("password"));
		By SIGNIN_LOCATOR=(By.xpath("//button[@name='login']"));
		By DROPDOWN_LOCATOR =(By.xpath("//select[@id='cid']"));
		By DASHBOARD_LOCATOR = (By.xpath("//h2[contains(text(),'Dashboard')]"));
		
		
		USERNAME_ELEMENT.sendKeys("demo@techfios.com");
		driver.findElement(PASSWORD_LOCATOR).sendKeys("abc123");
	    SIGNIN_ELEMENT.click();
	    
	    String DASHBOARDHEADER =driver.findElement(DASHBOARD_LOCATOR).getText();
	    
	    Assert.assertEquals("Wrong Page","Dashboard",DASHBOARDHEADER);
	    
		driver.findElement(By.xpath("//span[text()='Customers']")).click();
		driver.findElement(By.xpath("//a[text()='Add Customer']")).click();
		
		
		
		Select sel = new Select(driver.findElement(DROPDOWN_LOCATOR));
		sel.selectByVisibleText("ATT");
		//System.out.println(sel.getOptions().toString());
		List<WebElement> mylist=sel.getOptions();
		
		for(WebElement item:mylist) {
			System.out.println(item.getText());
		}
		
		
	}

}
