package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class MouseHover {
	WebDriver driver;
	@Before
	public void Initialization() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.dell.com/en-us");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test
	public void MouseHover() throws InterruptedException {
	By APEX_LOCATOR = By.xpath("//span[text()='APEX']");
	By APEX_CLOUDSERVICES_LOCATOR=By.xpath("//*[@id=\"unified-masthead-navigation\"]/nav/ul/li[1]/ul/li[4]/a");
	By APEXCLOUD_WITHVMWARE_LOCATOR =By.xpath("//a[text()='APEX Cloud Services with VMware Cloud']");
	
	Actions action = new Actions(driver);
	action.moveToElement(driver.findElement(APEX_LOCATOR)).build().perform();
	action.moveToElement(driver.findElement(APEX_CLOUDSERVICES_LOCATOR)).build().perform();
	Thread.sleep(3000);
	driver.findElement(APEXCLOUD_WITHVMWARE_LOCATOR).click();

	}

}
