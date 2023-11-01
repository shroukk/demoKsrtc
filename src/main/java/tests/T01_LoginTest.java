package tests;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.P01_LoginPage;
import org.openqa.selenium.WebDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

public class T01_LoginTest {
    protected WebDriver driver;
    protected P01_LoginPage loginPage;


    @DataProvider(name = "loginData")
    public Object[][] getLoginData() throws IOException {
        FileInputStream fis = new FileInputStream("src/resources/testdata/testdata.xlsx");
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("LoginData");

        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
        Object[][] data = new Object[rowCount - 1][colCount]; // Exclude header row

        for (int i = 1; i < rowCount; i++) {
            Row row = sheet.getRow(i);
            for (int j = 0; j < colCount; j++) {
                data[i - 1][j] = row.getCell(j,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
            }
        }

        workbook.close();
        fis.close();
        return data;
    }

    @BeforeTest
    public void setup(){
        driver = new ChromeDriver();
        loginPage = new P01_LoginPage(driver);
        driver.manage().window().maximize();
        driver.get("https://ksrtc.in/oprs-web/login/show.do");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @AfterTest
    public void closing(){
        driver.quit();
    }

    @Test(dataProvider = "loginData")
    public void testLogin(String username, String password, String expectedOutcome) throws InterruptedException {

        loginPage.performLogin(username, password);

//         Add assertions or verification here as needed
        if (expectedOutcome.contains("Login incorrect")) {
            // Verify that an error message is displayed when wrong credentials are entered
            Assert.assertTrue(loginPage.getErrorMessage().contains(expectedOutcome));
        } else {
            // Verify successful login and directed to the home page
            Assert.assertEquals(driver.getCurrentUrl(), expectedOutcome);
        }

    }
}
