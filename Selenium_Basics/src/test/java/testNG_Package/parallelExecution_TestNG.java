package testNG_Package;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class parallelExecution_TestNG {

    @Test
    public void loginChrome() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@title='Log in to your customer account']")).click();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("automatizeanything@gmail.com");
        driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("Techmasters@123");
        driver.findElement(By.xpath("//button[@id='SubmitLogin']")).click();
        String expectedTitle = "My account - My Store";
        String actualTitle = driver.getTitle();
        if (expectedTitle.contentEquals(actualTitle)) {
            System.out.println("Passed");
        }
        else {
            System.out.println("Failed");
        }
    }
    @Test
    public void loginFirefox() throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@title='Log in to your customer account']")).click();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("automatizeanything@gmail.com");
        driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("Techmasters@123");
        driver.findElement(By.xpath("//button[@id='SubmitLogin']")).click();
        String expectedTitle = "My account - My Store";
        String actualTitle = driver.getTitle();
        if (expectedTitle.contentEquals(actualTitle)) {
            System.out.println("Passed");
        }
        else {
            System.out.println("Failed");
        }
    }
}
