package part3_4.com.demoqa.base;

import com.demoqa.pages.HomePage;
import com.base.BasePage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

import static com.base.BasePage.delay;
import static utilities.Utility.setUtilityDriver;

public class BaseTest {
    private WebDriver driver;
    protected BasePage basePage;
    protected HomePage homePage;
    private String DEMOQA_URL = "https://demoqa.com/";

    @BeforeClass
    public void setUp(){
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void loadApplication(){
        driver.get(DEMOQA_URL);
        basePage = new BasePage();
        basePage.setDriver(driver);
        setUtilityDriver();
        homePage = new HomePage();
    }

    @AfterMethod
    public void takeFailedResultScreenshot(ITestResult testResult){
        if(ITestResult.FAILURE == testResult.getStatus()){
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            File destination = new File(System.getProperty("user.dir") +
                    "/resources/screenshots/(" +
                    LocalDate.now() + testResult.getName() + ".png");
            try{
                FileHandler.copy(source, destination);
            } catch (IOException e){
                throw new RuntimeException(e);
            }
            System.out.println("Screenshot Located At: " + destination);

        }
    }

    @AfterClass
    public void tearDown(){
        try {
            delay(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
