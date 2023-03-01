package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class OrderCreatePage {

	AndroidDriver<MobileElement> driver = null;
	WebDriverWait wait = null;
	
	public OrderCreatePage(AndroidDriver<MobileElement> driver) {
		
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
		
	}
	
	public MobileElement AllowAccessBtn() {
		
		return (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.id("com.android.packageinstaller:id/permission_allow_button")));
		
	}
	
	public MobileElement PickLocBtn() {
		
		return (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.id("com.apps.ac.martin.coffeeshopapp:id/fab_confirm")));
		
	}
	
	public MobileElement NameTxt() {
		
		return (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.id("com.apps.ac.martin.coffeeshopapp:id/txt_name")));
		
	}
	
	public MobileElement NicTxt() {
		
		return (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.id("com.apps.ac.martin.coffeeshopapp:id/txt_id_number")));
		
	}
	
	public MobileElement PhoneTxt() {
		
		return (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.id("com.apps.ac.martin.coffeeshopapp:id/txt_phone")));
		
	}
	
	public MobileElement CashRadioBtn() {
		
		return (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.id("com.apps.ac.martin.coffeeshopapp:id/radio_cash")));
		
	}
	
	public MobileElement ConfirmOrderBtn() {
		
		return (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.id("com.apps.ac.martin.coffeeshopapp:id/btn_confirm")));
		
	}
	
	public MobileElement BackBtn() {
		
		return (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.id("com.apps.ac.martin.coffeeshopapp:id/btn_back")));
		
	}
	
}
