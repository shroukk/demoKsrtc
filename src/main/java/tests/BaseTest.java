package tests;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.P02_HomePage;
import pages.P01_LoginPage;
import pages.P03_ResultPage;
import pages.P04_PaymentPage;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;
    protected P02_HomePage homePage;

    protected P03_ResultPage resultPage;
    protected P04_PaymentPage paymentPage;

    protected JavascriptExecutor js;

    @BeforeTest
    public void setUp() {
        // Set up WebDriver and initialize HomePage
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1024,768));
        driver.get("https://ksrtc.in/oprs-web/guest/home.do?h=1");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterTest
    public void tearDown()  {
        if(driver != null){
            driver.quit();
        }
    }


}
