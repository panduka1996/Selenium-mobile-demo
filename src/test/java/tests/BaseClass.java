package tests;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {

	AndroidDriver<MobileElement> driver = null;
	
	@BeforeTest
	public void setup() throws MalformedURLException, InterruptedException {
		
		File file = new File("src/test/resources/apps/com.apps.ac.martin.coffeeshopapp-v1.0.apk");
		
		DesiredCapabilities dcb = new DesiredCapabilities();
		
		dcb.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		dcb.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dcb.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
		dcb.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		
		dcb.setCapability(MobileCapabilityType.APP, file.getAbsolutePath());
	    
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		
		driver = new AndroidDriver<MobileElement>(url,dcb);
		
	}
	
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}
	
}
