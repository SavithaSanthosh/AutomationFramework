package Sample_chromeDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class multipleWindowHandling {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        String parentWindowID = driver.getWindowHandle();
        driver.findElement(By.xpath("//button[text()='Open Window']")).click();
       Set <String> windows=driver.getWindowHandles();
        for (String handle:windows)
        {
            if (!handle.equalsIgnoreCase(parentWindowID))
            {
                driver.switchTo().window(handle);
                break;
            }
        }
        //driver.switchTo().newWindow(WindowType.WINDOW);//open new window and move control to new window
        driver.get("https://www.opencart.com/index.php?route=common/home");
        driver.quit();
    }
}
