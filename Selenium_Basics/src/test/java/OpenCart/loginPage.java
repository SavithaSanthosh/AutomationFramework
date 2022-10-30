package OpenCart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class loginPage {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.opencart.com/index.php?route=account/login");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("camaveh781@canyona.com");
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("TechMasters@123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        String expURL="https://www.opencart.com/index.php?route=account/pin&member_token=5801c1b9248bb706ff8ef95e4a3355a4";
        String actualURL=driver.getCurrentUrl();
        if (expURL.equals(actualURL))
        {
            System.out.println("URL Passed");

        }
        else
        {
            System.out.println("URL Failed");
            String expTitle="Account PIN";
            String actualTitle=driver.getTitle();
            if (expTitle.equals(actualTitle))
            {
                System.out.println("Title is correct");
            }
            else
            {
                System.out.println("Title is wrong");
            }
        }
        Thread.sleep(3000);
        driver.close();

    }
}
