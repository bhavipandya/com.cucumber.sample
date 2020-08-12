package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.mobilePages.HomeScreen;
import framework.mobilePages.MainMenu;
import org.testng.Assert;

public class MobileMenuSD {

    private MainMenu mainMenu = new MainMenu();
    private HomeScreen homeScreen = new HomeScreen();

    @When("^I tap on skip button")
    public void clickOnSkipButton() {
        homeScreen.tapOnSkipButton();
    }

    @When("^I tap on menu button$")
    public void clickOnMenuButton() throws InterruptedException {
        Thread.sleep(30000);
        homeScreen.tapOnMainMenuButton();
    }

    @Then("^I verify sidebar menu is displayed$")
    public void verifySidebarMenu() {
        Assert.assertTrue(mainMenu.isMenuPresent());
    }

    @Then("^I tap on login button$")
    public void loginbutton(){
        homeScreen.tapOnLoginButton();
    }

    @Then("^I enter username$")
    public void username(){
        homeScreen.setUsername();
    }

    @Then("^I enter password$")
    public void password(){
        homeScreen.setPassword();

    }

    @Then("^I click on Login button$")
    public void Loginclick(){
        homeScreen.taponLOGIN();

    }

    @Then("^I tap on Logout$")
    public void logout(){
   homeScreen.taapOnLogout();
    }


    @Then("^I verify Lojin option exists$")
    public void loginoptiojn(){
        Assert.assertTrue(homeScreen.isLoginDispalyed());

    }

    @When("^I am on home page of the app$")
    public void mainPage(){
        homeScreen.tapOnSkipButton();
    }

   @Then("^I verify default main menu bar fields$")
    public void menubarfields(){
       homeScreen.menufieldsDisplayed();
   }

   @Given("^I am on Splash screen of the ionic conference app$")
       public void SplashScreen(){
        Assert.assertTrue(homeScreen.SplashScreenValidation());

       }

   @When("^I swipe right 3 times on tutorials slides$")
        public void swipe(){
        homeScreen.SwipeHorizontal();
   }

     @Then("^I verify Continue button is displayed$")
    public void continueButton(){
    Assert.assertTrue(homeScreen.isContinueDisplayed());
    }




}
