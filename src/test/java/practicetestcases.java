import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class practicetestcases {
    WebDriver driver;

    @BeforeMethod
    public void navigateToPage() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");
        Thread.sleep(3000);
    }



}
