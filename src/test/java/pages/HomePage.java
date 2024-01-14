package pages;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.datatable.DataTable;
import utils.*;

import static utils.CommonUtils.*;
import static utils.DriversUtils.*;

import java.util.List;
import java.util.Map;


public class HomePage {

	@FindBy(tagName = "h2")
	private WebElement roomCategoryIdentifier;

	@FindBy(xpath = "//button[contains(@class,'openBooking')]")
	private WebElement bookButton;

	@FindBy(xpath = "//div[@class='rbc-month-view']")
	private WebElement calendar;

	@FindBy(xpath = "//div[@class='rbc-month-view']//div[@class='rbc-month-row']")
	private List<WebElement> calendarRows;

	@FindBy(xpath = "//div[contains(@class,'rbc-date-cell') and not(contains(@class,'rbc-off-range'))]/button")
	private List<WebElement> newCalendarDates;

	//@FindBy(xpath = "//div[contains(@class,'rbc-date-cell')]/button")
	//private List<WebElement> calendarDates;

	//@FindBy(xpath = "//div[contains(@class,'rbc-current')]/../../..//following-sibling::div[@class='rbc-month-row']//div[contains(@class,'rbc-date-cell')]/button")
	//private List<WebElement> futureCalendarDates;

	@FindBy(xpath = "//input[@placeholder='Firstname']")
	private WebElement firstName;

	@FindBy(xpath = "//input[@placeholder='Lastname']")
	private WebElement lastName;

	@FindBy(xpath = "//input[@placeholder='Email']")
	private WebElement email;

	@FindBy(xpath = "//input[@placeholder='Phone']")
	private WebElement phone;

	@FindBy(xpath = "//button[contains(text(),'Book')]")
	private WebElement submitBookButton;

	@FindBy(xpath = "//div[@class='form-row']")
	private WebElement successfulBookingPopup;

	@FindBy(xpath = "//div[@class='form-row']//h3")
	private WebElement successfulBookingMessage_1;

	@FindBy(xpath = "//div[@class='form-row']//p")
	private WebElement successfulBookingMessage_2;

	@FindBy(xpath = "//div[@class='form-row']//p[2]")
	private WebElement successfulBookingMessage_3;

	@FindBy(xpath = "//div[@class='form-row']//button[text()='Close']")
	private WebElement closeSuccessfulPopupButton;

	@FindBy(xpath = "//span[@class='rbc-toolbar-label']")
	private WebElement currentMonthAndYear;

	@FindBy(xpath = "//button[text()='Next']")
	private WebElement nextMonthButton;

	String bookingSuccessText = "Booking Successful!";
	String congratsBookingText = "Congratulations! Your booking has been confirmed for:";
	
	String startDateValue;
	String endDateValue;
	String year;
	String month;

	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}

	public void goToRoomsCategory() {
		try {
			scrollToElement(roomCategoryIdentifier);
		} catch (RuntimeException e) {
			e.printStackTrace();
			System.out.println("Error in the rooms category method");
		}
	}

	public void assertBookButtonDisplayed(){
		Assert.assertEquals(true, bookButton.isDisplayed());
	}

	public void navigateToHomePage() {
		getDriver().get("https://automationintesting.online/#/");
	}

	public void clickBookButton() {
		bookButton.click();
	}

	public void assertCalendarOptionDisplayed() {
		Assert.assertEquals(true,calendar.isDisplayed());
	}

	public void selectDatesOnCalendar() {

		//nextMonthButton.click();
		clickElement(nextMonthButton);
		year = getCurrentYear(currentMonthAndYear.getText());
		month = getCurrentMonth(currentMonthAndYear.getText());
		WebElement startDate = newCalendarDates.get(1);
		WebElement endDate = newCalendarDates.get(3);
		startDateValue = startDate.getText();
		endDateValue = endDate.getText();
		int x= startDate.getSize().getHeight()/2;
		int y= startDate.getSize().getWidth()/2;	
		getAction().click(startDate).clickAndHold().moveToElement(startDate, x, y).moveToElement(endDate,x,y).release().build().perform();
	}

	public void fillCustomerDetails(DataTable table)
	{
		List<Map<String, String>> rows = table.asMaps(String.class, String.class);
		for (Map<String, String> columns : rows) {
			firstName.sendKeys(columns.get("FirstName"));
			lastName.sendKeys(columns.get("LastName"));
			email.sendKeys(columns.get("Email"));
			phone.sendKeys(columns.get("Phone"));
		}
	}

	public void submitTheBooking()
	{
		submitBookButton.click();
	}

	public void assertSuccessfullBookingPopupAndMessage()
	{
		Assert.assertEquals(true, successfulBookingPopup.isDisplayed());
		Assert.assertEquals(bookingSuccessText, successfulBookingMessage_1.getText());
		Assert.assertEquals(congratsBookingText, successfulBookingMessage_2.getText());
		String expected = year+"-"+month+"-"+startDateValue+" - "+year+"-"+month+"-"+endDateValue;
		Assert.assertEquals(expected, successfulBookingMessage_3.getText());		

	}	

}

