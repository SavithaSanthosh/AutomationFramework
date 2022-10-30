package Sample_chromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.netty.util.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.tracing.opentelemetry.SeleniumSpanExporter;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class loginValidation {
    public static void main(String[] args) throws InterruptedException {
        //System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
        //Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@title='Log in to your customer account']")).click();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("automatizeanything@gmail.com");
        driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("Techmasters@123");
        driver.findElement(By.xpath("//button[@id='SubmitLogin']")).click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(50));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='SubmitLogin']")));
        String expectedTitle = "My account - My Store";
        String actualTitle = driver.getTitle();
        if (expectedTitle.contentEquals(actualTitle))
        {
            System.out.println("Passed");
        }
        else
        {
            System.out.println("Failed");
        }
        driver.close();

    }
}
