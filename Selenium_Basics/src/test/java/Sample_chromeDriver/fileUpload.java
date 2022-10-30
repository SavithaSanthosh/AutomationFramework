package Sample_chromeDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class fileUpload {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/upload");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.findElement(By.id("file-upload")).sendKeys("file upload test.jpg");
        driver.findElement(By.id("file-submit")).submit();
        if(driver.getPageSource().contains("File Uploaded!"))
        {
            System.out.println("file uploaded");
        }
        else
        {
            System.out.println("file not uploaded");
        }
        driver.quit();
    }
}
