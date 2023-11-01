package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class P01_LoginPage  {
    WebDriver driver;

    private By usernameField = By.id("userName");
    private By passwordField = By.id("password");
    private By loginButton = By.id("submitBtn");
    private By checkField = By.xpath("//*[@id=\"TermsConditions\"]");
    private By errorMessage = By.cssSelector("div[id=\"errorMsg\"] strong");

    public P01_LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickOnTerms(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement(checkField));

    }
    public void clickLogin() {
        driver.findElement(loginButton).click();
    }


    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }

    public void performLogin(String username, String password) {
        setUsername(username);
        setPassword(password);
        clickOnTerms();
        clickLogin();
    }
}
