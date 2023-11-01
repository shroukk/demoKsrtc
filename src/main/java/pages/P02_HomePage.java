package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class P02_HomePage extends BasePage {
    private Actions action;
    protected WebDriverWait wait;


    private By fromPlaceField = By.id("fromPlaceName");
    private By toPlaceField = By.id("toPlaceName");

    private By journeyDateField = By.id("txtJourneyDate");


    private By searchForBusButton = By.xpath("//*[@id=\"bookingsForm\"]/div[1]/div/div[2]/div[3]/button");


    public P02_HomePage(WebDriver driver){
        super(driver);
    }

    public void setFromPlace(String fromPlace){
        WebElement element = driver.findElement(fromPlaceField);
        element.sendKeys(fromPlace);
        action = new Actions(driver);
        action.moveToElement(element).perform();
        driver.findElement(By.cssSelector("[id=\"ui-id-1\"] a")).click();
    }
    public void setToPlace(String toPlace){
        WebElement element = driver.findElement(toPlaceField);
        element.sendKeys(toPlace);
        action = new Actions(driver);
        action.moveToElement(element).perform();
        driver.findElement(By.cssSelector("[id=\"ui-id-2\"] a")).click();
    }

    public void setJourneyDate(){
        WebElement element = driver.findElement(journeyDateField);
        element.click();
        List<WebElement> days= driver.findElements(By.cssSelector("[data-handler=\"selectDay\"]"));
//        select day from next month in case there are only two days in current month
        if (days.size()<3){
            JavascriptExecutor js = (JavascriptExecutor) driver;
//            click on next month arrow
            js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]")));
            days = driver.findElements(By.cssSelector("[data-handler=\"selectDay\"]"));
        }
        // select random day
        int min = 1;
        int randomDay = (int)Math.floor(Math.random()*((days.size()-1)-min+1)+min);
        days.get(randomDay).click();
    }
    public void clickSearch(){

        driver.findElement(searchForBusButton).click();
    }



}

