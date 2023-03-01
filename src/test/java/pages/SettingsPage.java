package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class SettingsPage {

	AndroidDriver<MobileElement> driver = null;
	WebDriverWait wait = null;
	
	public SettingsPage(AndroidDriver<MobileElement> driver) {
		
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
		
	}

	public MobileElement SettingsBtn() {
		
		return (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.id("com.apps.ac.martin.coffeeshopapp:id/settings")));
		
	}
	
	public MobileElement ModeBtn() {
		
		return (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='Dark Mode']")));
		
	}
	
	public MobileElement DarkModeBtn() {
		
		return (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.CheckedTextView[@text='Dark']")));
		
	}
	
	public MobileElement BackBtn() {
		
		return (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]")));
		
	}
	
}
