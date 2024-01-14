package features.step_definitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BasePage;
import pages.HomePage;

public class BookingSteps extends BasePage {

    //public static WebDriver driver;
    HomePage homePage = new HomePage();
    @Given("I am on the home page")
    public void i_am_on_the_home_page() {
        //driver = new FirefoxDriver();
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        homePage.navigateToHomePage();

    }

    @When("I browse through the page")
    public void i_browse_through_the_page() {
        homePage.goToRoomsCategory();
    }
    @Then("I have the option to book a room")
    public void i_have_the_option_to_book_a_room() {
       homePage.assertBookButtonDisplayed();
    }
    
    @Then("I click the book button")
    public void i_click_the_book_button() {
       homePage.clickBookButton();
    }
    
    @Then("I have the calendar option to select the dates")
    public void i_have_the_calendar_option_to_select_the_dates() {
       homePage.assertCalendarOptionDisplayed();
    }
    
    @Then("I select two available dates on the calendar")
    public void i_select_two_available_dates_on_the_calendar() {
       homePage.selectDatesOnCalendar();
    }
    
    @Then("I fill in the customer details")
    public void i_fill_in_the_customer_details(DataTable table) {
       homePage.fillCustomerDetails(table);
    }
    
    @Then("I submit the booking")
    public void i_submit_the_booking() throws InterruptedException {
       homePage.submitTheBooking();
    }
    
    @Then("I get the booking successful message with the dates booked")
    public void i_get_the_booking_successful_message_with_the_dates_booked() {
       homePage.assertSuccessfullBookingPopupAndMessage();
    }

}
