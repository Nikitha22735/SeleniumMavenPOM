import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.IExpectedExceptionsHolder;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;
import org.apache.poi.ss.usermodel.*;




public class practicetestcases {
    WebDriver driver;

//    @BeforeMethod
//    public void navigateToPage() throws InterruptedException {
//        driver = new ChromeDriver();
//        driver.get("https://practicetestautomation.com/practice-test-login/");
//        Thread.sleep(3000);
//    }

    @Test
    public void getData() throws IOException {
        FileInputStream fis = new FileInputStream("D:\\seleniumAutomation\\SeleniumMavenPOM\\src\\test_data\\test_data.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheet("test");

        Row row = sheet.getRow(2);
        Cell cell = row.getCell(0);

        String value = cell.toString();
        System.out.println(value);

        workbook.close();
    }

    @Test
    public void waits(){
        driver = new ChromeDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");
        //explicit wait
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit")));

        //implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }



}
