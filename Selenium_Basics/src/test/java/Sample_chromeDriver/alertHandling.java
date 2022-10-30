package Sample_chromeDriver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class alertHandling {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Savitha");
        driver.findElement(By.xpath("//input[@id='confirmbtn']")).click();
        Alert al = driver.switchTo().alert();
        String alertMsg=al.getText();
        System.out.println(alertMsg);
        //Thread.sleep(3000);
        al.accept();
        driver.close();
        //al.dismiss();
    }
}
