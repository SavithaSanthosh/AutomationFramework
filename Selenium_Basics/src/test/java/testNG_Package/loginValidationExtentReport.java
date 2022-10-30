package testNG_Package;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;

@Listeners(listener_TestNG.class)

public class loginValidationExtentReport {
    WebDriver driver;
    ExtentSparkReporter spark;
    ExtentReports report;
    ExtentTest test;

    @BeforeMethod
    public void initialize() throws InterruptedException {
        //System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        spark = new ExtentSparkReporter("./Reports/report.html");
        spark.config().setDocumentTitle("ReportSample");
        spark.config().setReportName("ReportNameSample");
    }

    @Test
    public void login() {
        report = new ExtentReports();
        report.setSystemInfo("OS", "Windows");
        report.setSystemInfo("Environment", "QA");
        report.attachReporter(spark);
        test = report.createTest("LoginValidation");
        test.log(Status.INFO, "SignIn to Customer");
        test.log(Status.INFO, "Enter email ********");
        test.log(Status.INFO, "Enter password ***********");
        test.log(Status.INFO, "Signin button click");
        driver.findElement(By.xpath("//a[@title='Log in to your customer account']")).click();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("automatizeanything@gmail.com");
        driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("Techmasters@123");
        driver.findElement(By.xpath("//button[@id='SubmitLogin']")).click();
        String expectedTitle = "My Store";
        String actualTitle = driver.getTitle();
        test.log(Status.INFO, "Verify Title of page");
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @AfterMethod
    public void generateReport(ITestResult result) throws IOException {
        if (result.getStatus()==ITestResult.SUCCESS)
        {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" testcase passed", ExtentColor.GREEN));
        }
        else if (result.getStatus()==ITestResult.FAILURE)
        {
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" testcase failed", ExtentColor.RED));
            test.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenshot.getScreenshot(driver)).build());
        }
        else
        {
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" testcase skipped", ExtentColor.LIME));
        }
    }

    @AfterClass
    public void Close()
    {
        report.flush();
        driver.quit();
    }
}
