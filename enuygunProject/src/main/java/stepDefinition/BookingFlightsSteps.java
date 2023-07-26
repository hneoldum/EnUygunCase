package stepDefinition;

import PageObjectModel.BookingFlightsPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class BookingFlightsSteps {

    public BookingFlightsPage bookingFlightsPage = new BookingFlightsPage();
    private WebDriver driver;
    @Given("Navigate to Website {string}")
    public void navigateToWebsite(String Url) {
        bookingFlightsPage.navigateToWebsite(Url);
    }

    @And("Type Departure City {string}")
    public void typeDepartureCity(String departureCity){
        bookingFlightsPage.typeDepartureCity(departureCity);
    }

    @And("Type Destination City {string}")
    public void typeDestinationCity(String destinationCity){
        bookingFlightsPage.typeDestinationCity(destinationCity);
    }
    @And("Select {string} Passenger {int}")
    public void selectPassenger(String passengerType,int passengerCount){
        bookingFlightsPage.selectPassenger(passengerType,passengerCount);
    }
    @And("Select Departure Date {string}")
    public void selectDepartureDate(String date){
        bookingFlightsPage.selectDepartureDate(date);
}
    @And("Click Transit Checkbox")
    public void clickTransitCheckbox(){
        bookingFlightsPage.clickTransitCheckbox();
    }
    @And("Select Return Date {string}")
    public void selectReturnDate(String date){
        bookingFlightsPage.selectReturnDate(date);
    }
    @When("Click Find Deals Button")
    public void clickFindDealsButton(){
        bookingFlightsPage.clickFindDealsButton();
    }
    @Then("Verify the Search Page")
    public void verifyTheSearchPage(){
        bookingFlightsPage.verifyTheSearchPage();
    }

    @Then("Click The First Video")
    public void clickthevideo(){
        bookingFlightsPage.clickthevideo();
    }
}

