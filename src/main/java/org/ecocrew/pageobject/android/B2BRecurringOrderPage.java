package org.ecocrew.pageobject.android;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class B2BRecurringOrderPage {
	AndroidDriver driver;

	public B2BRecurringOrderPage(AndroidDriver driver) {
		//super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='ecocrew.B2BHomeScreenBusinessName']")
	private WebElement businessName;
	
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='ecocrew.B2BRaiseRecurringPickupRequest']")
	private WebElement Recurring;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='ecocrew.B2BRecurringPickupShowDatePicker']")
	private WebElement RecurringShowDatePicker;
	
//	@AndroidFindBy(xpath = "//android.view.View[@content-desc='25 July 2023']")
//	private WebElement ShowDatePicker;
	
	@AndroidFindBy(id = "android:id/button1")
	private WebElement okButton;
	
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='ecocrew.B2BRecurringPickupShowDatePicker']/android.widget.TextView")
	private WebElement dateText;
	
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='ecocrew.B2BRecurringPickupRepeatsEvery']")
	private WebElement repeatEvery;
	
	
	@AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc='ecocrew.B2BRecurringPickupRepeatsOn'])/android.widget.TextView")
	List<WebElement> repeatEveryText;
	
	
	@AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc='ecocrew.B2BRecurringPickupRepeatsOn'])")
	List<WebElement> repeatEveryList;
	
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='ecocrew.B2BRecurringPickupSelectTime']")
	private WebElement Selectatimeslot;
	
	@AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc='ecocrew.B2BRecurringPickupTimeslot'])")
	List<WebElement> PickupTimeslot;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='ecocrew.B2BRecurringPickupSelectTime']/android.widget.TextView")
	private WebElement timeSlotText;
	
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='ecocrew.B2BRecurringOrderSelectMoneyAcceptance']")
	private WebElement SelectMoneyAcceptance;
	
	
	@AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc='ecocrew.B2BRecurringPickupPaymentMode'])/android.widget.TextView")
	List<WebElement> listOfPaymentMode;
	
	@AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc='ecocrew.B2BRecurringPickupPaymentMode'])")
	List<WebElement> PickupPaymentMode;
	
	
	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='ecocrew.B2BRecurringOrderConfirmPickup']")
	private WebElement RecurringOrderConfirmPickup;
	
	
	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='ecocrew.B2BPickupConfirmedBackToHome']")
	private WebElement ConfirmedBackToHome;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='ecocrew.B2BHomeScreenViewOrderDetails']")
	private WebElement recurringViewOrderDetails;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='ecocrew.B2BOrderDetailsCancelPickup']")
	private WebElement OrderDetailsCancelPickup;
	
	@AndroidFindBy(xpath = "(//android.widget.RadioButton[@content-desc='ecocrew.B2BOneTimeOrderSubmitData'])")
	List<WebElement> cancelRecurringRadiobutton;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='ecocrew.B2BOrderDetailsRecurringModelButton']")
	private WebElement Confirmcancellation;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='ecocrew.B2BOrderDetailsGoBack']")
	private WebElement GoBack;
	
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='ecocrew.B2BOrderDetailsDate']")
	private WebElement date;
	
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='ecocrew.B2BOrderDetailsTime']")
	private WebElement time;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='ecocrew.B2BOrderDetailsMoneyAccMode']")
	private WebElement paymentMode;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='ecocrew.B2BOrderDetailsPickupAddress']")
	private WebElement address;
	
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='ecocrew.B2BOrderDetailsExeName']")
	private WebElement pickupexecutinename;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='ecocrew.B2BOrderDetailsExeNumber']")
	private WebElement pickupexecutinenumber;
	
	public void screenBusinessName() {
		String busName=businessName.getText();
	
	}
	
	
	public void recurringOrder() {
		Recurring.click();
	}
	public String StartsOn() {
		RecurringShowDatePicker.click();
		//ShowDatePicker.click();
		okButton.click();
		String startson=dateText.getText();
		System.out.println("startson " +startson);
		String string = startson;
		
		DateTimeFormatter format = DateTimeFormatter.ofPattern("d MMM yyyy");	           
        LocalDate date = LocalDate.parse(string, format);
	    String aa=date.toString();
        System.out.println(aa);
        
        String date1 =  LocalDate.parse( aa ).format(DateTimeFormatter.ofPattern( "dd-MM-uuuu" ));
        System.out.println(date1);	
        
        
        java.time.DayOfWeek dayOfWeek = date.getDayOfWeek();
        
        String day=dayOfWeek.toString();
        System.out.println("Day of week in text:"+day);
        
       String dateDay=date1.concat(", "+day);
       
       System.out.println("Day of week in text:"+dateDay);
       
       
		return dateDay;
	}
	
	
	public String repeatEvery(String repeats) throws InterruptedException {
		repeatEvery.click();
		String repeateveryList = null;
		int i=0;
		    	  System.out.println(repeatEveryText.size());
		    	  for(i=0;i<repeatEveryText.size();i++)
		    	  {
		    		  repeateveryList=repeatEveryText.get(i).getText();
		        	  System.out.println("repeatlist " +repeateveryList);
		        	  
		        	  Thread.sleep(3000);
		        	  if(repeateveryList.equals(repeats)) {
			    		  System.out.println("repeats " +repeats);
		        		  Thread.sleep(3000);
		        		  repeatEveryList.get(i).click();		        		  
		        	  }
		        	 
		    	  }
		    	  
		    	 
		    	 return repeateveryList;
				
	}
	
	
	public String selectTimeSlot() {
		Selectatimeslot.click();
		PickupTimeslot.get(0).click();
		String timeText=timeSlotText.getText();
		String userTime=timeText.substring(0,timeText.lastIndexOf("("));
		
		System.out.println(userTime);
		if(userTime.contains(" ")) {
			userTime = userTime.replace(" ", "");
			System.out.println(userTime);
     	   
        }
		return userTime;
		
	}
	
	public String moneyMode(String paymentMode) throws InterruptedException {
		SelectMoneyAcceptance.click();		
		String paymentList = null;
  	    System.out.println(listOfPaymentMode.size());
  	  for(int i=0;i<listOfPaymentMode.size();i++)
  	  {
  		paymentList=listOfPaymentMode.get(i).getText();
      	  System.out.println("paymentList " +paymentList);
      	  System.out.println("paymentMode " +paymentMode);
      	  Thread.sleep(3000);
      	  if(paymentList.equals(paymentMode)) {
      		  Thread.sleep(3000);
      		PickupPaymentMode.get(i).click();		        		  
      	  }
      	 
  	  }
  	 return paymentList;
		
	}
	
	public void confirm() {
		RecurringOrderConfirmPickup.click();
		ConfirmedBackToHome.click();
		recurringViewOrderDetails.click();
	}
	
	
	public String recurringPickupDetails() {
		String pickupdetailsDate=date.getText();
		System.out.println("pickupdetailsDate " +pickupdetailsDate);
		return pickupdetailsDate;
	}
	
	public String pickupdetailTime() {
		String pickupdetailsTime=time.getText();
		if(pickupdetailsTime.contains(" ")) {
			pickupdetailsTime = pickupdetailsTime.replace(" ", "");
			System.out.println("pickupdetailsTime " +pickupdetailsTime);

        }
		return pickupdetailsTime;
	}
	
	
	public String pickupdetailpaymentMode() {
		String pickupdetailsTime=paymentMode.getText();
		System.out.println("pickupdetailspaymentMode " +paymentMode);
		return pickupdetailsTime;
	}
	
	
	
	
}
