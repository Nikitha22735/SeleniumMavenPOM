import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class coursesTestclass {
    WebDriver driver;

    @BeforeMethod
    public void navigateToPage() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");
        Thread.sleep(3000);
        loginPage lp = new loginPage(driver);
        lp.SubmitUserNameAndPw("student", "Password123");

        coursesPage cp = new coursesPage(driver);
        cp.clickOnCoursesLink();
        Thread.sleep(3000);

    }

    @Test
    public void validatePageNaviagationToCoursesScreen(){
        String pageTitle=driver.getTitle();
        String expectedTitle = "Courses | Practice Test Automation";
        Assert.assertEquals(pageTitle,expectedTitle);   //hard assertions
    }

    @Test
    public void validateChildTab() throws InterruptedException {
        coursesPage cp = new coursesPage(driver);
        cp.clickOnSeleniumJavalink();
        Set<String> allhandles= driver.getWindowHandles();
        System.out.println(driver.getTitle());
        Iterator<String> it = allhandles.iterator();
        String parent = it.next();
        String child = it.next();
        driver.switchTo().window(child);


        Thread.sleep(3000);
        System.out.println(driver.getTitle());
        seleniumJavaChildClass sjc = new seleniumJavaChildClass(driver);
        sjc.enterValueInSearchBox();
        driver.switchTo().window(parent);
        cp.clickOnSeleniumJavalink();
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }



}
