package stepdefinition;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.webPages.darkSkyHomePage;
import org.openqa.selenium.By;
import org.testng.Assert;

public class darkSkySD {

 private darkSkyHomePage darkSkyHomePage= new darkSkyHomePage();
@Given("^I am on DarkSky Home Page$")
public void setDarkSkyHomePage(){
    Assert.assertEquals(darkSkyHomePage.searchbutton(),true);

}



 @When("^I am on the darksky homepage page$")
 public void darkskyhomepage()
 {
     darkSkyHomePage.clickOndarkSkyAPIlink();
 }


 @Given("^I am on the darksky Register page$")
    public void RegisterPage(){
     darkSkyHomePage.clickOnSignUpButton();

 }



    @When("^I click on Register button$")
 public void RegisterButton(){
        darkSkyHomePage.clickOnregisterButton();

    }


    @Then("^I verify am on RegisterPage by verifying Registerlink$")
    public void VerifyRegisterPage(){
     String expected =darkSkyHomePage.getTextFromElement(By.xpath("//h1[@class='stand-alone title']"));


       Assert.assertEquals(expected, "Register");
    }




@Then("^I verify current temp is not greater or less then temps from daily timeline$")
    public void temp(){
   //  Assert.assertEquals(darkSkyHomePage.summarySwap(),darkSkyHomePage.nowTemp());

    darkSkyHomePage.timelinetemprature();


}
    @When("^I expand todays timeline$")
    public void expandtodaytimeline() throws InterruptedException{
        darkSkyHomePage.todaysTimeLine();

    }

@Then("^I verify lowest and highest temp is displayed correctly$")
    public void todaysTempValidation(){
     darkSkyHomePage.todaysLowHighTemp();

}

@Then("^I verify timeline is displayed with two hours incremented$")
    public void timelineIncrement(){
   darkSkyHomePage.TimeIncrementValidation();
}

}
