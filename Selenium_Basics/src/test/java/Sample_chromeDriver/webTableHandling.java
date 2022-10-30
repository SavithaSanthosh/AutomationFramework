package Sample_chromeDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.List;

public class webTableHandling {
    public static void main(String[] args) throws InterruptedException, IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://seleniumpractise.blogspot.in/2016/08/how-to-handle-calendar-in-selenium.html");
        driver.manage().window().maximize();
        driver.findElement(By.id("datepicker")).click();
        List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//a"));
        for (WebElement ele : allDates) {
            String date = ele.getText();
            if (date.equalsIgnoreCase("31")) {
                ele.click();
                break;
            }

        }
        takeScreenshot screen = new takeScreenshot();
        screen.getScreenshot(driver);

    }
}


