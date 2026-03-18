import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class loginTestcases {
    WebDriver driver;

    @BeforeMethod
    public void navigateToPage() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");
        Thread.sleep(3000);
    }





    @Test(groups="login")
    public void ValidateLoginUsingPositiveCredentials() throws InterruptedException {
        loginPage lg = new loginPage(driver);
        lg.SubmitUserNameAndPw("student", "Password123");
        String actualTitle = driver.getTitle();

        String expctedTitle = "Logged In Successfully | Practice Test Automation";
        Assert.assertEquals(actualTitle,expctedTitle);
    }

    @Test(groups="login")
    public void ValidateLoginUsingInvalidusname() throws InterruptedException {
        loginPage lg = new loginPage(driver);
        lg.SubmitUserNameAndPw("1student", "Password123");
       WebElement errorElement = driver.findElement(By.cssSelector("div#error"));
        Assert.assertTrue(errorElement.isDisplayed());
    }

    @Test(groups="login")
    public void ValidateLoginUsingInvalidPw() throws InterruptedException {

        loginPage lg = new loginPage(driver);
        lg.SubmitUserNameAndPw("student", "1Password123");
        Thread.sleep(2000);
        WebElement errorElement = driver.findElement(By.cssSelector("div#error"));
        Assert.assertTrue(errorElement.isDisplayed());
    }


    @Test(groups="login")
    public void ValidateLoginUsingNegitiveCredentials() throws InterruptedException {
        loginPage lg = new loginPage(driver);
        lg.SubmitUserNameAndPw("1student", "1Password123");
        Thread.sleep(2000);
        WebElement errorElement = driver.findElement(By.cssSelector("div#error"));
        Assert.assertTrue(errorElement.isDisplayed());
    }

    @AfterMethod
    public void closeBrowser(){
        driver.close();
    }

}
