package org.ecocrew.pageobject.android;

import java.util.List;

import org.ecocrew.utils.AndroidAction;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CancelPickupOrderPage extends AndroidAction {
AndroidDriver driver;
	
	public CancelPickupOrderPage(AndroidDriver driver) {
       super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this); 
	}
	
	@AndroidFindBy(xpath="//android.view.ViewGroup[@content-desc='ecocrew.TrackOrderPickupViewOrderDetails']")
	private WebElement viewOrderDetails;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='ecocrew.PickupDetailCancelPickupButton']")
	private WebElement cancelOrder;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='ecocrew.CancelViewOnCancel']")
	private WebElement cancelViewOn;
	
	@AndroidFindBy(id = "ecocrew.CancelViewOnDontCancel")
	private WebElement dontCancel;
	
	@AndroidFindBy(xpath="//android.widget.RadioButton[@content-desc='ecocrew.CancelViewRadio']/android.widget.TextView")
	List<WebElement> reasonForCancelRadioBtn;
	
	@AndroidFindBy(id = "ecocrew.CancelViewCancelComment")
	private WebElement enterCancelComment;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='ecocrew.CancelViewOnSubmit']")
	private WebElement cancelReasonSubmitBtn;
		
	
	public void viewOrderDetailsLink() throws InterruptedException {
	
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"View order details\").instance(0));"));
		Thread.sleep(3000);
		viewOrderDetails.click();
	}
	
	public void cancelPickupOrder() {
		scrollToText("Cancel pickup");
		cancelOrder.click();
	}
	
	
	public void cancelViewOnButton() {
		cancelViewOn.click();
	}
	
	public void reasonForCancellation() {
		for(WebElement reasoncancelList: reasonForCancelRadioBtn) {
			String reasonCancel=reasoncancelList.getText();
			System.out.println(reasonCancel);
		}
		reasonForCancelRadioBtn.get(0).click();
		
	}
	
	public void submitButton() {
		cancelReasonSubmitBtn.click();
	}
	
	
	
	
	
	
	
}
