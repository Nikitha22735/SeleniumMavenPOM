import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class seleniumJavaChildClass {
    WebDriver driver;

    @FindBy(xpath = "//input[@data-testid='typeahead-input']")
    WebElement searchBox;

    public seleniumJavaChildClass(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    public void enterValueInSearchBox(){
        searchBox.sendKeys("testing");
    }
}
