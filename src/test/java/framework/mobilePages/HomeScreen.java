package framework.mobilePages;

import framework.AppiumWrapper;
import framework.MobileBasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomeScreen extends MobileBasePage {
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='SKIP ']")
    @iOSFindBy(accessibility = "undefined")
    private MobileElement skipButton;

    @AndroidFindBy(xpath = "//android.webkit.WebView/android.view.View/android.widget.Button[1]")
    @iOSFindBy(accessibility = "undefined")
    private MobileElement mainMenu;


    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='log in Login '] ")
    @iOSFindBy(accessibility = "undefined")
    private MobileElement loginButton;


    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='log out Logout '] ")
    @iOSFindBy(accessibility = "undefined")
    private MobileElement logoutButton;


    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Username']")
    @iOSFindBy(accessibility = "undefined")
    private MobileElement username;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Password']")
    @iOSFindBy(accessibility = "undefined")
    private MobileElement password;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='LOGIN ']")
    @iOSFindBy(accessibility = "undefined")
    private MobileElement LOGINBUTTON;


    @AndroidFindBy(xpath = "//*[@content-desc='Welcome to ICA']")
    @iOSFindBy(accessibility = "undefined")
    private MobileElement splashScreenMessage;


    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='CONTINUE arrow forward ']")
    @iOSFindBy(accessibility = "undefined")
    private MobileElement ContinueButton;

    @AndroidFindBy(className = "android.widget.Button")
    private List<MobileElement> listOfMenuButtons;

    public void getListOfMenuButtons(){
        for(MobileElement element :listOfMenuButtons){
            System.out.println("Size of Menu Items" +element.getSize());
        }
       listOfMenuButtons.get(0).isDisplayed();
    }


    public void tapOnLoginButton() {
        tapOn(loginButton);
    }

    public void tapOnSkipButton() {
        tapOn(skipButton);
    }

    public void tapOnMainMenuButton() {
        tapOn(mainMenu);
    }

    public void setUsername() {
        username.sendKeys("test@test.com");
    }

    public void setPassword() {
        password.sendKeys("kshdkshf");
    }

    public void taponLOGIN() {
        tapOn(LOGINBUTTON);
    }

    public void taapOnLogout() {
        tapOn(logoutButton);
    }

    public boolean isLoginDispalyed() {
        return loginButton.isDisplayed();
    }

    public void menufieldsDisplayed() {
       /* List<MobileElement> LIST = AppiumWrapper.getAppiumDriver().findElementsById("loggedOutMenu");
        for (int i = 0; i < LIST.size(); i++) {
            System.out.println(LIST.get(i).getText());
        }



        */
    }

   public boolean SplashScreenValidation(){
        //String message=splashScreenMessage.getText();
        //String Message=getTextFromElement(splashScreenMessage);
        return splashScreenMessage.isDisplayed();
   }

  public void SwipeHorizontal(){
        swipeScreenHorizontally(3);
  }

  public boolean isContinueDisplayed(){
   return ContinueButton.isDisplayed();
  }

}








