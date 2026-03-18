import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class coursesPage {
    WebDriver driver;
    @FindBy(xpath = "//a[text()='Courses']")
    WebElement coursesLink;

    @FindBy(xpath = "//a[text()='Selenium WebDriver: Selenium Automation Testing with Java']")
    WebElement seleniumJavaLink;


    public coursesPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void  clickOnCoursesLink(){
        coursesLink.click();
    }
    public void clickOnSeleniumJavalink(){
        seleniumJavaLink.click();
    }
}
