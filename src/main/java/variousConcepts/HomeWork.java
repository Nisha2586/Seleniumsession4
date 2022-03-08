package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class HomeWork {
	WebDriver driver;

	@Before
	public void Initialization() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.techfios.com/billing/?ng=login/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void keyboardEnter() throws InterruptedException {
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("demo@techfios.com");
		Actions action = new Actions(driver);
		action.sendKeys(Keys.TAB).build().perform();
		action.sendKeys("abc123", Keys.TAB);
		action.sendKeys(Keys.ENTER).build().perform();

		driver.findElement(By.xpath("//span[text()='Transactions']")).click();
		driver.findElement(By.xpath("//a[text()='New Deposit']")).click();

		String TRANSACTION_HEADER_LOCATOR = driver.findElement(By.xpath("//h2[text()=' Transactions ']")).getText();

		Assert.assertEquals("wrong Page", "Transactions", TRANSACTION_HEADER_LOCATOR);

		By ACCOUNTDROPDOWN_LOCATOR = By.xpath("//select[@id='account']");

		Select sel = new Select(driver.findElement(ACCOUNTDROPDOWN_LOCATOR));
		sel.selectByVisibleText("CHECKING");
		
		driver.findElement(By.xpath("//input[@id='description']")).sendKeys("My Checking Account");
		driver.findElement(By.xpath("//input[@id='amount']")).sendKeys("123213");
		driver.findElement(By.xpath("//button[@id='submit']")).click();
		Thread.sleep(5000);
		
		String TRANSACTION_SUCCESSFULL_LOCATOR =driver.findElement(By.xpath("//div[@class=\"alert alert-success fade in\"]")).getText();
		System.out.println(TRANSACTION_SUCCESSFULL_LOCATOR);
		Assert.assertEquals("wrong Page", " Transaction Added Successfully ", TRANSACTION_SUCCESSFULL_LOCATOR);
	}

}
