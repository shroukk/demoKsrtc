package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P04_PaymentPage extends BasePage {


    private final By paymentFrame = By.cssSelector("iframe[class='razorpay-checkout-frame']");

    public P04_PaymentPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getPaymentFrame(){
        return driver.findElement(paymentFrame);
    }
    private final By paymentMethodBtn = By.cssSelector("button[class=\"new-method has-tooltip false svelte-1d17g67\"]");
    public void clickOnPaymentMethodBtn(){
        driver.findElements(paymentMethodBtn).get(0).click();
    }

    private final By cardNo = By.id("card_number");
    public void setCardNo(String number){
//        String cardStr = Double.toString(number)
        driver.findElement(cardNo).sendKeys(number);
    }
    private final By cardExpiry = By.id("card_expiry");
    public void setCardExpiry(String date){
        driver.findElement(cardExpiry).sendKeys(date);
    }
    private final By cardCvv = By.id("card_cvv");
    public void setCardCvv(String number){
        driver.findElement(cardCvv).sendKeys(number);
    }

}
