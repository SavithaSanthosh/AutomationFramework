package testNG_Package;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;
@Listeners(listener_TestNG.class)

public class loginValidation {
    WebDriver driver;
    @BeforeMethod
    public void initialize() throws InterruptedException {
        //System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }
    @Test
    public void login() {

        driver.findElement(By.xpath("//a[@title='Log in to your customer account']")).click();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("automatizeanything@gmail.com");
        driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("Techmasters@123");
        driver.findElement(By.xpath("//button[@id='SubmitLogin']")).click();
        String expectedTitle = "My account - My Store";
        String actualTitle = driver.getTitle();
        if (expectedTitle.contentEquals(actualTitle)) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }
    }
    @AfterMethod
    public void Close()
    {
        driver.quit();
    }
}
