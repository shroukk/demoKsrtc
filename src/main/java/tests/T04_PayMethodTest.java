package tests;

import org.testng.annotations.Test;
import pages.P04_PaymentPage;

public class T04_PayMethodTest extends BaseTest {
//    choose payment method (card)
//    fill card data
    @Test
    public void paymentTest(){
        paymentPage = new P04_PaymentPage(driver);
        driver.switchTo().frame(paymentPage.getPaymentFrame());
        paymentPage.clickOnPaymentMethodBtn();
        paymentPage.setCardNo("1212121212121");
        paymentPage.setCardExpiry("01/30");
        paymentPage.setCardCvv("312");
    }
}
