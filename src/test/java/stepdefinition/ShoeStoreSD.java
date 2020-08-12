package stepdefinition;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.webPages.ShoeStoreHomePage;
import framework.webPages.darkSkyHomePage;
import org.openqa.selenium.By;
import org.testng.Assert;



public class ShoeStoreSD {
    private ShoeStoreHomePage shoeStoreHomePage = new ShoeStoreHomePage();

    @Given("^I am on ShoeStore Home Page$")
    public void setDarkSkyHomePage() {
        Assert.assertEquals(darkSkyHomePage.searchbutton(), true);

    }

    @When("^I Verify the month Bat exists with all the twelve months and All Shows Link$")
    public void MonthlyBar() {


    }

    @Then("^I verify Welcome title on ShoeSore Homepage$")
    public void WelcomeTitile() {



    }

    @Then("^I verify redirection to All Shoes Page$")
    public void AllShoes() {



    }

    @Then("^I click on All Shoes Link$")
    public void ClickAllSHoes() {


    }

    @Then("^I enter invalid data in Promotion Code Textbox$")
    public void PromoCode() {


    }
    @Then("^I verify Invalid Code Format Message$")
    public void InvEmaol() {


    }


}