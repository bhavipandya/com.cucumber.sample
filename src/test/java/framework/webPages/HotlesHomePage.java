package framework.webPages;

import cucumber.api.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import stepdefinition.SharedSD;

import java.util.List;

public class HotlesHomePage  extends BasePage{


    private By searchButton= By.xpath("//button[@type='submit']");
    private By defaultLocation = By.id("qf-0q-destination");
    private By fiveStars= By.id("f-star-rating-5");
    private By fourStars=By.id("f-star-rating-4");
    private By threeStars=By.id("f-star-rating-3");
    private By distance = By.linkText("Distance");
    private By loganAirport= By.linkText("Logan International Airport (BOS)");
    Float distanceRange;

    public void setSearchButton() {

        setValue(defaultLocation, "Boston  Logan  International Airport (BOS)");
        clickOn(searchButton);
    }


   public void selectThreeStars()  {

      SharedSD.getDriver().manage().window().maximize();
      clickOn(threeStars);
      List<WebElement> threeStarHotels= SharedSD.getDriver().findElements(By.xpath("//div[@class='additional-details resp-module']//span[@class='star-rating-text']"));

       for (WebElement hotel : threeStarHotels)
       {
        String stars = hotel.getText();
           System.out.println(stars);
       }


   }

  public void selectFourStars(){

      SharedSD.getDriver().manage().window().fullscreen();
      clickOn(fourStars);
      List<WebElement> fourStarHotel= SharedSD.getDriver().findElements(By.xpath("//div[@class='additional-details resp-module']//span[@class='star-rating-text star-rating-text-strong']"));

      for(WebElement hotel4: fourStarHotel)
      {
          String stars= hotel4.getText();
          System.out.println(stars);
      }

  }

  public void selectFiveStars(){

      SharedSD.getDriver().manage().window().maximize();
      clickOn(fiveStars);
      List<WebElement> fiveStarHotel= SharedSD.getDriver().findElements(By.xpath("//div[@class='additional-details resp-module']//span[@class='star-rating-text star-rating-text-strong']"));

      for(WebElement hotel5: fiveStarHotel)
      {
          String stars= hotel5.getText();
          System.out.println(stars);
      }

  }

  public void ClickOndistance()throws InterruptedException {
    //  SharedSD.getDriver().manage().window().maximize();
      clickOn(distance);
      Thread.sleep(0, 500);
      clickOn(loganAirport);

     /* boolean IsHitlonPresent = false;
      List<WebElement> hotelsList = SharedSD.getDriver().findElements(By.xpath("//ol[@class='listings infinite-scroll-enabled']"));
      for (WebElement ele : hotelsList) {
          String list = ele.getText();
          System.out.println(list);
          if (list.contains("Hilton")) {
              IsHitlonPresent = true;
              System.out.println("Hilton is Present");

          }

      }


      */




      List<WebElement> hotels = SharedSD.getDriver().findElements(By.xpath("//ul[@class='property-landmarks']/child::li[1]"));
      //********Only checking the first 10 hotels with in 10 miles radius or not*******
      for (WebElement distance : hotels) {
          String[] dis = (distance.getText().split("miles"));
          distanceRange = Float.parseFloat(dis[0]);
          Thread.sleep(1000);
      }
      boolean result = false;

      if (distanceRange < 10) {
          result = true;
      }
      Assert.assertTrue(result);
  }


 /* public void DistanceofDisplayedHotels() throws InterruptedException {
         SharedSD.getDriver().manage().window().maximize();
       List<WebElement> hotels = SharedSD.getDriver().findElements(By.xpath("//ul[@class='property-landmarks']/child::li[1]"));
       //********Only checking the first 10 hotels with in 10 miles radius or not*******
       for (WebElement distance : hotels) {
       String[] dis = (distance.getText().split("miles"));
         distanceRange = Float.parseFloat(dis[0]);
        Thread.sleep(1000);
}
       boolean result = false;

        if (distanceRange < 10) {
          result = true;
}
        Assert.assertTrue(result);
}


  */



 public void hiltonIsInRadius()
{
    SharedSD.getDriver().manage().window().maximize();
    boolean result = false;
//Verify Between the first 10 hotels with in 10 miles of radius Hilton Hotel is there
      List<WebElement> hotelNames = SharedSD.getDriver().findElements(By.xpath("//a[@class='property-name-link']"));
     for (WebElement hotelName : hotelNames)
      {
       String hotel = hotelName.getText();

    if(hotel.contains("Hilton"))
 {
      result= true;
 }

}
   Assert.assertTrue(result);
 }


}
