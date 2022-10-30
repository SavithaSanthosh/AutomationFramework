package testNG_Package;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProvider_Login {
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
    @DataProvider(name = "logindataprovider")
    public static Object[][] credentials() {

        return new Object[][] { { "automatizeanything@gmail.com", "Techmasters@123" }, { "testuser_1", "Test@123" }};

    }
    @Test(dataProvider = "logindataprovider")
    public void login() {

        driver.findElement(By.xpath("//a[@title='Log in to your customer account']")).click();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("automatizeanything@gmail.com");
        driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("Techmasters@123");
        driver.findElement(By.xpath("//button[@id='SubmitLogin']")).click();
        String expectedTitle = "My account - My Store";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
        /*if (expectedTitle.contentEquals(actualTitle)) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }*/
    }
    @AfterMethod
    public void Close()
    {
        driver.quit();
    }
}
