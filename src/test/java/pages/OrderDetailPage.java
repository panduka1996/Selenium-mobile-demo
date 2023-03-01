package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class OrderDetailPage {

	AndroidDriver<MobileElement> driver = null;
	WebDriverWait wait = null;
	
	public OrderDetailPage(AndroidDriver<MobileElement> driver) {
		
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
		
	}
	
	public MobileElement OrderBtn() {
		
		return (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.id("com.apps.ac.martin.coffeeshopapp:id/orders")));
		
	}
	
	public MobileElement ViewDetailBtn() {
		
		return (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='View details']")));
		
	}
	
	public MobileElement CancelOrderBtn() {
		
		return (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@text='CANCEL ORDER']")));
		
	}
	
	public MobileElement BackBtn() {
		
		return (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]")));
		
	}
	
	public MobileElement StatusLbl() {
		
		return (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@index='4']")));
		
	}

}
