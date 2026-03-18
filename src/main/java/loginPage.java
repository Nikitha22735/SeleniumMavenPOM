import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
    WebDriver driver;
//    WebElement userNameLocator = driver.findElement(By.id("username"));

    @FindBy(id="username")
    WebElement userNameLocator;

    @FindBy(id="password")
    WebElement passWordLocator;


    @FindBy(id="submit")
    WebElement submitBtn;

    public loginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void SubmitUserNameAndPw(String username, String pw){
        enterUserName(username);
        enterPw(pw);
        clickOnSublit();

    }

    public boolean validateTheVisibilityOfusername(){
        boolean visibility = userNameLocator.isDisplayed();
        return visibility;
    }

    public void enterUserName(String username){
        userNameLocator.sendKeys(username);
    }

    public void enterPw(String pw){
        passWordLocator.sendKeys(pw);
    }

    public void clickOnSublit(){
        submitBtn.click();
    }
}
