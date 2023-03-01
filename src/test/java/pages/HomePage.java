package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class HomePage {
	
	AndroidDriver<MobileElement> driver = null;
	WebDriverWait wait = null;
	
	public HomePage(AndroidDriver<MobileElement> driver) {
		
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
		
	}

	public MobileElement WarningBtn() {
		
		return (MobileElement) driver.findElementById("android:id/button1");
		
	}
	
	public MobileElement AppHeader() {
		
		return (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='Coffee Shop App']")));
	}
	
	public MobileElement OptionBtn() {
		
		return (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ImageButton[@index='0']")));
		
	}
	
	public MobileElement ChocolateBtn() {
		
		return (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//androidx.cardview.widget.CardView[@index='6']")));
		
	}
	
	public MobileElement AddQtnBtn() {
		
		return (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ImageButton[@index='2']")));
		
	}
	
	public MobileElement AddToOrderBtn() {
		
		return (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@text='ADD TO ORDER']")));
		
	}
	
	public MobileElement SnackBtn() {
		
		return (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.LinearLayout[@content-desc=\"Snacks\"]")));
		
	}
	
	public MobileElement ItemBtn() {
		
		return (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.id("com.apps.ac.martin.coffeeshopapp:id/fab_order")));
		
	}
	
	public MobileElement TotalPriceLbl() {
		
		return (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[2]")));
		
	}
	
	public MobileElement CheckOutBtn() {
		
		return (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@text='CHECKOUT']")));
		
	}
	
	
}
