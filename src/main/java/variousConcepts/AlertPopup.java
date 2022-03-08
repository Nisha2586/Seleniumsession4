package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class AlertPopup {
	WebDriver driver;
	@Before
	public void Initialization() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test
	public void Alert() throws InterruptedException {
		
		By HEADER_LOCATOR =By.xpath("//div[@class='logtext']");
		Assert.assertTrue("wrong page", driver.findElement(HEADER_LOCATOR).isDisplayed());
		
		String HEADER = driver.findElement(By.xpath("//div[text()='rediff']")).getText();
		
		Assert.assertEquals("wrong page", "rediffmail", HEADER);
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(3000);
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		
	}

}
