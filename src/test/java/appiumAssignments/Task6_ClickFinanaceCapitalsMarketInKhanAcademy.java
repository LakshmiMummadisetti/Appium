package appiumAssignments;

import org.testng.annotations.Test;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.testng.annotations.BeforeClass;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Task6_ClickFinanaceCapitalsMarketInKhanAcademy {
	AndroidDriver<AndroidElement> driver;

	@Test
	public void clickFinanceMarketInEconomics() throws InterruptedException {
		driver.findElement(MobileBy.AccessibilityId("Search tab")).click();
		Thread.sleep(3000);
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Economics\")")).click();
		Thread.sleep(3000);
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Finance and capital markets\")")).click();
		Thread.sleep(3000);
		String Expected = "Finance and capital markets";
		String Actual = driver
				.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Finance and capital markets\")"))
				.getText();
		Assert.assertEquals(Actual, Expected);
	}

	@BeforeClass
	public void beforeClass() throws MalformedURLException {
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("deviceName", "emulator-5558");
		capability.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capability.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "org.khanacademy.android");
		capability.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,
				"org.khanacademy.android.ui.library.MainActivity");
		capability.setCapability("unicodeKeyboard", true);
		capability.setCapability("resetKeyboard", true);
		driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"), capability);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
