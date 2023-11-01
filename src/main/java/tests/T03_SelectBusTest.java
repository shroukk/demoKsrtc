package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.P03_ResultPage;
import utils.ExcelUtils;
import java.io.IOException;
import java.time.Duration;

public class T03_SelectBusTest extends BaseTest {


    @BeforeMethod
    public void setDrive (){
        resultPage = new P03_ResultPage(driver);
        js = (JavascriptExecutor) driver;
    }

    @Test(priority = 2)
    public void TestSelectSeatsBtn() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // click on select seats button
        js.executeScript("arguments[0].click();", resultPage.getSelectSeatBtns().get(0));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

    }


    //        select an available seat
    @Test(priority = 3, dependsOnMethods = "TestSelectSeatsBtn")
    public void TestSelectAvailSeats() {
        js.executeScript("arguments[0].click();", resultPage.getAvailSeats().get(2));
        js.executeScript("arguments[0].click();", resultPage.getAvailSeats().get(3));
    }


    //        select boarding and dropping point
    @Test(dependsOnMethods = "TestSelectAvailSeats")
    public void TestBoardingDroppingPoint() {
        js.executeScript("arguments[0].click();", resultPage.getBoardingPoint().get(0));
        js.executeScript("arguments[0].click();", resultPage.getBoardingPoint().get(1));
    }



    //        enter mobile no. & email id
    @Test(dependsOnMethods = "TestBoardingDroppingPoint")
    public void TestSetCstInfo(){
        resultPage.setMobileNum("6789125987");
        resultPage.setEmailId("Test@test.com");
    }



    @DataProvider(name = "customerData")
    public Object[][] testData() throws IOException {
        return ExcelUtils.getCustomerData("src/resources/testdata/customerdata.xlsx", "CustomerData");
    }


    //       fill passenger details
    @Test( dataProvider = "customerData", dependsOnMethods = "TestSetCstInfo")
    public void fillPassengerInfo(int passengerIndex, String cstName, String cstGender, int cstAge, String confession, String country){
        resultPage.setPassengerName(passengerIndex,cstName);
        resultPage.setgender(passengerIndex,cstGender);
        resultPage.setPassengerAge(passengerIndex,cstAge);
        resultPage.selectConfession(passengerIndex,confession);
        resultPage.selectCountry(passengerIndex,country);
    }


//  click make payment
    @Test(dependsOnMethods = "fillPassengerInfo")
    public void TestClickPayment(){
        resultPage.makePayment();
    }


}
