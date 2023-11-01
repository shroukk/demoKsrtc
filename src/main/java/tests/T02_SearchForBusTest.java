package tests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;
import pages.P02_HomePage;

import java.time.Duration;


public class T02_SearchForBusTest extends BaseTest {

    @Test(priority = 1)
    public void testSearch () throws InterruptedException {
        homePage = new P02_HomePage(driver);

//         click pagedown on keyboard
        Actions A = new Actions(driver);
        A.sendKeys(Keys.PAGE_DOWN).build().perform();

        //set home, destination, journey date
        homePage.setFromPlace("Chikkamagaluru");
        homePage.setToPlace("Bengaluru");
        homePage.setJourneyDate();

        // click search button
        homePage.clickSearch();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // assert that the directed page is correct
        Assert.assertTrue(driver.getCurrentUrl().equals("https://ksrtc.in/oprs-web/avail/services.do"));



    }
}
