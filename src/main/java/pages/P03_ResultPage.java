package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class P03_ResultPage extends BasePage {
    private final By selectSeatBtns = By.cssSelector("[class=\"btnSelectLO select-service-btn\"]");
    private final By boardingPoint = By.cssSelector("[class=\"bordingPoint-list\"] li");
    private final By availSeats = By.cssSelector("[class=\"availSeatClassS\"]");
    private final By emailId = By.id("email");
    private final By mobileNum = By.id("mobileNo");

    private final By makePaymentBtn = By.id("PgBtn");

    public P03_ResultPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getSelectSeatBtns(){
        return driver.findElements(selectSeatBtns);
    }

    public List<WebElement> getBoardingPoint(){
        return driver.findElements(boardingPoint);
    }

    public List<WebElement> getAvailSeats(){
        return driver.findElements(availSeats);
    }




    public void setMobileNum(String number){
        driver.findElement(mobileNum).sendKeys(number);
    }

    public void setEmailId(String email){
        driver.findElement(emailId).sendKeys(email);
    }
    public void setPassengerName(int passInx, String name){
        By passengerName = By.id("passengerNameForward"+passInx);
        driver.findElement(passengerName).sendKeys(name);
    }

    public void setgender(int passInx, String gen){
        By gender = By.id("genderCodeIdForward"+passInx);
        String GEN = gen.toUpperCase();
        boolean female = false;
        if (GEN.equals("FEMALE")){female =true;}

        WebElement dropdowngender = driver.findElement(gender);
        Select dropdown = new Select(dropdowngender);
        boolean isOptionPresent = false;
        for (WebElement option : dropdown.getOptions()) {
            if (option.getText().equals(GEN)) {
                isOptionPresent = true;
                break;
            }
        }

        // Select the option if found, handle if not found
        if (isOptionPresent && female) {
            dropdown.selectByVisibleText(GEN);
            // handle alert shown when selecting female
            Alert alert = driver.switchTo().alert();
            alert.accept();

        } else if (isOptionPresent){
            dropdown.selectByVisibleText(GEN);
        } else {
            dropdown.selectByVisibleText("OTHERS");
        }

    }


    public void setPassengerAge(int passInx, int age){
        String ageStr = Integer.toString(age);
        By passengerAge = By.id("passengerAgeForward"+passInx);
        driver.findElement(passengerAge).sendKeys(ageStr);
    }

    public void selectConfession(int passInx, String confessionOpt) {
        By confession = By.id("concessionIdsForward"+passInx);
        WebElement confessbtn = driver.findElement(confession);
        Select select = new Select(confessbtn);
        select.selectByVisibleText(confessionOpt);
    }

    public void selectCountry(int passInx, String country){
        By countrySelect = By.id("nationalityForward"+passInx);
        WebElement countrybtn = driver.findElement(countrySelect);
        Select select = new Select(countrybtn);
        select.selectByVisibleText(country);
    }

    public void makePayment(){
        driver.findElement(makePaymentBtn).click();
    }

}
