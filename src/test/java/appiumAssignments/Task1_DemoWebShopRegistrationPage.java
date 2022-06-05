package appiumAssignments;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.appium.java_client.remote.MobileCapabilityType;

public class Task1_DemoWebShopRegistrationPage {
	RemoteWebDriver driver;

	int min = 132;
	int max = 147852;
	int random_value = (int) Math.floor(Math.random() * (max - min + 1) + min);
	String Email = "dummymail" + Integer.toString(random_value) + "@abc.com";

	@Test
	public void DemoWebShopRegistration() throws InterruptedException {

		driver.findElement(By.linkText("Register")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("gender-female")).click();
		driver.findElement(By.name("FirstName")).sendKeys("Lakshmi");
		driver.findElement(By.name("LastName")).sendKeys("Mummadisetti");
		driver.findElement(By.name("Email")).sendKeys(Email);
		driver.findElement(By.id("Password")).sendKeys("Secure@14785");
		driver.findElement(By.id("ConfirmPassword")).sendKeys("Secure@14785");
		driver.findElement(By.xpath("//input[@value='Register']")).click();
		Thread.sleep(3000);
		String expected = "Your registration completed";
		String actual = driver.findElement(By.xpath("//div[contains(text(),'Your registration completed')]")).getText();
		Assert.assertEquals(expected, actual);
	}

	@BeforeClass
	public void lauchBrowser() throws MalformedURLException, InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		options.setCapability(MobileCapabilityType.DEVICE_NAME, "Lakshmi");
		options.setCapability("unicodeKeyboard", true);
		options.setCapability("resetKeyboard", true);
		driver = new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"), options);
		driver.get("http://demowebshop.tricentis.com");
		Thread.sleep(3000);
	}

	@AfterClass()
	public void quitBrowser() {
		driver.quit();
	}
}
