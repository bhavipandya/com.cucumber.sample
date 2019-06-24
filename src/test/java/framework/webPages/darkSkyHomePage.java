package framework.webPages;

import org.joda.time.DateTime;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import stepdefinition.SharedSD;

import java.text.SimpleDateFormat;
import java.util.*;


public class darkSkyHomePage extends BasePage {

    private By darkSkyAPIlink = By.linkText("Dark Sky API");
    private By SignUpButton = By.linkText("TRY FOR FREE");
    private By registerButton = By.xpath("//button[contains(text(),'Register')]");
    private By summarySwap = By.xpath("//span[@class='summary swap']");
    private By nowTemp = By.xpath("//div[@id='timeline']//div[@class='temps']//span[@class='first']");
    private By searchButtonImg = By.xpath("//a[@class='searchButton']");
    private By todaystimelinetoggle = By.xpath("//a[@class='day'][@data-day='0']//span[@class='toggle']");
    private By todaysLowTemp = By.xpath("//a[@class='day revealed']//span[@class='minTemp']");
    private By todaysHighTemp = By.xpath("//a[@data-day='0']//span[@class='maxTemp']");
    private By expandedLowTemp = By.xpath("//div[@class='dayDetails revealed']//span[@class='temp']");
    private By expandedHighTemp = By.xpath("//div[@class='dayDetails revealed']//div[@class='highLowTemp swip']//span[@class='lowTemp swap']//span[@class='temp']");


    public void clickOndarkSkyAPIlink() {
        clickOn(darkSkyAPIlink);
    }

    public void clickOnSignUpButton() {
        clickOn(SignUpButton);
    }


    public void clickOnregisterButton() {
        clickOn(registerButton);
    }


    public void currentTemo() {
        String SumaryTemp = summarySwap.toString().substring(0, 2);
        System.out.println(SumaryTemp);
    }


    public boolean searchbutton() {
        return isElementDisplayed(searchButtonImg);
    }

    public int summarySwap() {
        String summaryText = getTextFromElement(summarySwap);
        String summarytemp = summaryText.substring(0, 2);
        int tempSumInteger = Integer.parseInt(summarytemp);
        return tempSumInteger;

    }

    public int nowTemp() {
        String nowtemp = getTextFromElement(nowTemp);
        String NowTemprature = nowtemp.substring(0, 2);
        int nowTemprat = Integer.parseInt(NowTemprature);
        return nowTemprat;

    }

    public void timelinetemprature() {
        String nowtemp = getTextFromElement(nowTemp);
        String NowTemprature = nowtemp.substring(0, 2);
        int nowTemprat = Integer.parseInt(NowTemprature);
        int high = nowTemprat;
        int low = nowTemprat;
        boolean isValid = true;


        List<WebElement> timelineTemp = SharedSD.getDriver().findElements(By.xpath("//span[contains(@style,'opacity')]"));

        //System.out.println(timelineTemp);

        for (WebElement timelineTemps : timelineTemp) {

            String temprature = timelineTemps.getText();
            int tempLine = Integer.parseInt(temprature.substring(0, 2));
            System.out.println(tempLine);

            if (tempLine > high) {
                high = tempLine;


            }
            if (tempLine < low) {
                low = tempLine;


            }

        }

        System.out.println("high" + high);
        System.out.println("low" + low);
        if (nowTemprat > high && nowTemprat < low) {
            isValid = false;

        }

        //using for loop to add items into array

       /*  List<String> Arraytimeline = new ArrayList<>();


       for(int i=0; i<timelineTemp.size();i++){
           //Arraytimeline.add( timelineTemp.get(i).getText());
           Arraytimeline.add(timelineTemp.get(i).getText().replace("°",""));
            System.out.println("String Array of Timeline Temps" +timelineTemp.get(i).getText());

            break;
        }

        */


        //Removing the degree symbol


        //converting String Array into Int Array

    }

    public void todaysTimeLine() throws InterruptedException {
        SharedSD.getDriver().manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) SharedSD.getDriver();
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0,1000)", "");
        Thread.sleep(2000);
        clickOn(todaystimelinetoggle);


    }


    public void todaysLowHighTemp() {

        Assert.assertEquals(getTextFromElement(todaysLowTemp), getTextFromElement(expandedLowTemp));

        Assert.assertEquals(getTextFromElement(todaysHighTemp), getTextFromElement(expandedHighTemp));


    }

    public void TimeIncrementValidation() {

        SimpleDateFormat sdf=new SimpleDateFormat("hh aa" );
        Calendar cal = Calendar.getInstance(); // creates calendar
        cal.setTime(new Date()); // sets calendar time/date
        cal.getTime(); // returns new date object, one hour in the future

        List<WebElement> listtimeOnTimeline = SharedSD.getDriver().findElements(By.xpath("//div[@id='timeline']//div[@class='hours']//span//span"));

        int i = 0;
        String strTime2 = "";
        String wElement = "";

        Iterator<WebElement> iter = listtimeOnTimeline.iterator();

        while (iter.hasNext()) {
            WebElement we = iter.next();
            wElement = we.getText().trim();

            if (i == 0){
                if (wElement.equals("Now")) {
                    System.out.println("Success! Element 0 is Now.");
                } else {
                    System.out.println("Error! Element 0 is not Now.");
                }
            }

            if (i > 0){
                cal.add(Calendar.HOUR_OF_DAY, 2); // adds two hours
                strTime2 = sdf.format(cal.getTime()).replace(" ","").toLowerCase();

                if (wElement.length() ==3){
                    wElement = "0" + wElement;
                }

                if (strTime2.equals(wElement)){
                    System.out.println("Success! Element " + i + " matches.");
                } else {
                    System.out.println("Error! Element " + i + " does not match.");
                }


            }

            i++;
        }

    }

}
















