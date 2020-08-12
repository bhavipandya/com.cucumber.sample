package stepdefinition;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.webPages.HomePage;
import framework.webPages.HotlesHomePage;
import gherkin.lexer.Th;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class HotelsSD {

    private  HotlesHomePage hotlesHomePage= new HotlesHomePage();

    @Given("^I am on default locations search result screen$")
    public void defaultsearchScreen()
    {
        SharedSD.getDriver().navigate().refresh();
        SharedSD.getDriver().manage().window().maximize();
        hotlesHomePage.setSearchButton();


    }

  @When("^I select property class (.+)$")
    public void selectStars(String stars) {

    switch (stars) {
        case "5 stars":
            hotlesHomePage.selectFiveStars();
            break;
        case "4 stars":
            hotlesHomePage.selectFourStars();
            break;
        case "3 stars":
            hotlesHomePage.selectThreeStars();
            break;

    }


  }

 @Then("^I verify system displays only (.+) hotels on search result$")
public void starsValidation(){

 }

 @Then("^I verify system displays all hotels within 10 miles radius of airport$")
    public void hotelDistance()throws InterruptedException{
        hotlesHomePage.ClickOndistance();
        Thread.sleep(0,500);
       // hotlesHomePage.DistanceofDisplayedHotels();
        // Thread.sleep(0,1000);



 }

 @Then("^I verify Hilton Hotel is within radius$")
    public void hiltondistance(){
        hotlesHomePage.hiltonIsInRadius();

 }

}
