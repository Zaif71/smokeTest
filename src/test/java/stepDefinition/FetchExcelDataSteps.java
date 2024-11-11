package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;

public class FetchExcelDataSteps {
        private WebDriver driver;
        private String excelPath = "C:\\Users\\zaffar\\exceldata\\src\\test\\TestData\\OrangeHrm.xlsx";
        private Workbook workbook;

        @Given("user navigates to the application")
        public void userNavigatesToTheApplication() {

            System.setProperty("webdriver.chrome.driver", "C:\\Users\\zaffar\\paytm\\Drivers\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        }

        @Then("user enters valid username  and password from excel")
        public void userEntersValidUsernameAndPasswordFromExcel() throws IOException {
            // Load the Excel file
            FileInputStream file = new FileInputStream(excelPath);
            workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0);


            String username = sheet.getRow(0).getCell(0).getStringCellValue();
            String password = sheet.getRow(0).getCell(1).getStringCellValue();

            // Enter username and password
            driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username); // Adjust the selector as needed
            driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password); // Adjust the selector as needed
            driver.findElement(By.xpath("//button[@type='submit']")).click(); // Adjust the selector as needed

            // Close the Excel file
            workbook.close();
            file.close();


            driver.quit();
        }
    }

