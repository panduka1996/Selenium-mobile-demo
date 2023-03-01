package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import pages.HomePage;
import pages.OrderCreatePage;
import pages.OrderDetailPage;
import pages.SettingsPage;

public class FirstTest extends BaseClass{

	@Test(priority=1,description="Accept the warning")
	public void Test1() {
		
		HomePage page = new HomePage(driver);
		MobileElement element = page.WarningBtn(); // Accept the warning message
		element.click();
		
	}
	
	@Test(priority=2,description="Verify 'Cofee Shop App' title visibility on the home screen")
	public void Test2() {
		
		HomePage page = new HomePage(driver);
		MobileElement element = page.AppHeader(); 
		String ActualTitle = element.getText(); // Get the application title
		String ExpectedTitle = "Coffee Shop App";
		Assert.assertEquals(ExpectedTitle, ActualTitle,"Test Case Failed");
		
	}
	
	@Test(priority=3,description="Navigate to settings and switch to Dark mode theme")
	public void Test3() {
		
		HomePage homePage = new HomePage(driver);
		SettingsPage sttPage = new SettingsPage(driver);
		
		MobileElement element1 = homePage.OptionBtn(); // Click the menu button
		element1.click();
		
		MobileElement element2 = sttPage.SettingsBtn(); // Click the settings button
		element2.click();
		
		MobileElement element3 =  sttPage.ModeBtn(); // Click the mode button
		element3.click();
		
		MobileElement element4 = sttPage.DarkModeBtn(); // select the dark theme
		element4.click();
		
	}
	
	@Test(priority=4,description="Navigate to the Home page")
	public void Test4() {
		
		SettingsPage sttPage = new SettingsPage(driver);
		MobileElement element = sttPage.BackBtn(); // Click the back button
		element.click();
		
	}
	
	@Test(priority=5,description="Scroll down and click on 'Chocolate smoothie'")
	public void Test5() {
		
		HomePage homePage = new HomePage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		wait.until(ExpectedConditions.elementToBeClickable(
				MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector())" +
		                ".scrollIntoView(new UiSelector().text(\"Chocolate Smoothie\"));") // Navigate to the bottom of the page
				));
		
		MobileElement element = homePage.ChocolateBtn();
		element.click();  
		
	}
	
	@Test(priority=6,description="Change Quantity to 5 and click on 'Add to order'") 
	public void Test6() {
		
		HomePage homePage = new HomePage(driver);
		
		MobileElement element1 = homePage.AddQtnBtn(); // Add 5 items
		
		for(int i=1;i<=4;i++) {
			element1.click();  
		}
		
		MobileElement element2 = homePage.AddToOrderBtn(); // Add to the order
		element2.click();  
		
	}
	
	@Test(priority=7,description="Go to 'Snacks'")
	public void Test7() {
		
		HomePage homePage = new HomePage(driver);
		MobileElement element = homePage.SnackBtn(); // Click the 'Snack' button 
		element.click();  
	}
	
	@Test(priority=8,description="Scroll Up to the top of the screen")
	public void Test8() {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		wait.until(ExpectedConditions.elementToBeClickable(
				MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector())" +
		                ".scrollIntoView(new UiSelector().text(\"Coffee Shop App\"));") // Navigate to the top of the application
				));
		
	}
	
	
	//I'm unable to complete this part. Cannot write text to the search text box
	
	@Test(priority=9,description="Go to 'Search' and enter the text 'Pancakes'")
	public void Test9() {
		
//		MobileElement element1 = (MobileElement) driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Search\"]"));
//		element1.click();
//		
//		MobileElement element2 = (MobileElement) driver.findElement(By.id("android:id/search_src_text"));
//		element2.sendKeys("Pancakes");

	}
	
	@Test(priority=10,description="Go to the Checkout list and verify the total amount")
	public void Test10() {
		
		HomePage homePage = new HomePage(driver);
		
		MobileElement element1 = homePage.ItemBtn(); // Click the Item button
		element1.click(); 
		
		MobileElement element2 = homePage.TotalPriceLbl(); // Get the total price
		String priceString = element2.getText();
		String[] priceArray = priceString.split("\\s"); // Break the string into 2 part using black space in the string
		String price = priceArray[1].replace(",", ""); // Get the 2nd part of the string and remove the ','
		
		int resultPrice = Integer.parseInt(price); // Convert the string into integer
		int expectedPrice = 3000;
		
		Assert.assertEquals(expectedPrice, resultPrice,"Test case failed"); // Compare the expected and result values
		
	}
	
	@Test(priority=11,description="Tap on Checkout")
	public void Test11() {
		
		HomePage homePage = new HomePage(driver);
		MobileElement element1 = homePage.CheckOutBtn(); // Click the checkout button
		element1.click(); 
		
	}
	
	
	/* 
	   Before click on the Pick Location button, there is a confirm pop-up message box displayed by the device which say 'allow this application to access 
	   this device location. So I had to write a script to click the allow button in the message box. 
	*/ 
	
	
	@Test(priority=12,description="Tap on PickLocations")
	public void Test12() {
		
		OrderCreatePage orderCreate = new OrderCreatePage(driver);
		
		MobileElement element2 = orderCreate.AllowAccessBtn(); // Give access to application for track the location of the phone 
		element2.click(); 
		
		MobileElement element1 = orderCreate.PickLocBtn(); // Click the location button
		element1.click(); 
		
	}
	
	
	@Test(priority=13,description="Provide user details")
	public void Test13() {
		
		OrderCreatePage orderCreate = new OrderCreatePage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		MobileElement element1 = orderCreate.NameTxt(); // Fill the name
		element1.sendKeys("Panduka Wijekoon");
		
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(
		        "new UiScrollable(new UiSelector().scrollable(true)).setAsVerticalList()" +
		         ".scrollIntoView(new UiSelector().text(\"Phone, This field is required\"))"))); // Navigate to the Phone field

		MobileElement element2 = orderCreate.NicTxt(); // Fill the NIC
		element2.sendKeys("963143818V");
		
		MobileElement element3 = orderCreate.PhoneTxt(); // Fill the phone no
		element3.sendKeys("0763533511"); 
		
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(
		        "new UiScrollable(new UiSelector().scrollable(true)).setAsVerticalList()" +
		         ".scrollIntoView(new UiSelector().text(\"CONFIRM ORDER\"))"))); // Navigate to the bottom of the page 
		
	}
	
	@Test(priority=14,description="Change Payment method to 'Cash' and Confirm order")
	public void Test14() {
		
		OrderCreatePage orderCreate = new OrderCreatePage(driver);
		
		MobileElement element1 = orderCreate.CashRadioBtn(); // Change the Payment method
		element1.click();
		
		MobileElement element2 = orderCreate.ConfirmOrderBtn(); // Confirm the order
		element2.click();  
		
	}
	
	@Test(priority=15,description="Back to home")
	public void Test15() {
		
		OrderCreatePage orderCreate = new OrderCreatePage(driver);
		
		MobileElement element1 = orderCreate.BackBtn(); // Navigate to the home page
		element1.click(); 
		
	}
	
	
	@Test(priority=16,description="Navigate to 'Orders' and tap on 'View Details'")
	public void Test16() {
		
		HomePage homePage = new HomePage(driver);
		OrderDetailPage orderDetail = new OrderDetailPage(driver);

		MobileElement element1 = homePage.OptionBtn(); // Click the option button
		element1.click();
		
		MobileElement element2 = orderDetail.OrderBtn(); // Click the order button
		element2.click();
		
		MobileElement element3 = orderDetail.ViewDetailBtn(); // View the order details
		element3.click();
		
	}
	
	@Test(priority=17,description="Scroll down and Cancel the order")
	public void Test17() {
		
		OrderDetailPage orderDetail = new OrderDetailPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(
		        "new UiScrollable(new UiSelector().scrollable(true)).setAsVerticalList()" +
		         ".scrollIntoView(new UiSelector().text(\"CANCEL ORDER\"))"))); // Navigate to the bottom of the page
		
		MobileElement element1 = orderDetail.CancelOrderBtn(); // Click the 'cancel order' button
		element1.click();
		
	}
	
	@Test(priority=18,description="Go Back to orders and verify order status has changed to 'canceled'")
	public void Test18() {
		
		OrderDetailPage orderDetail = new OrderDetailPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(
		        "new UiScrollable(new UiSelector().scrollable(true)).setAsVerticalList()" +
		         ".scrollIntoView(new UiSelector().text(\"View order\"))"))); // Navigate to the top of the page
		
		MobileElement element1 = orderDetail.BackBtn(); // Click the back button
		element1.click();
		
		MobileElement element2 = orderDetail.StatusLbl(); // Get the order status
		String Actualstatus = element2.getText();
		String Expectedstatus = "Cancelled";
		Assert.assertEquals(Expectedstatus, Actualstatus,"Test Case Failed"); // Compare the order status with the 'Cancelled' status
		
	}
	
}
