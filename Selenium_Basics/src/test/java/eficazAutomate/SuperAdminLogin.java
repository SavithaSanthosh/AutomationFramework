package eficazAutomate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SuperAdminLogin {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://ebl.eficaztechsol.com/superadmin");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("superadmin@gmail.com");
        driver.findElement(By.xpath("//input[@id='password-field']")).sendKeys("12345678");
        driver.findElement(By.xpath("//button[@class='btn btn-primary au-btn--blue w-100 super_submit']")).click();
        Thread.sleep(3000);
        String expectedURL="http://ebl.eficaztechsol.com/dashboard";
        String actualURL= driver.getCurrentUrl();
        if (expectedURL.equals(actualURL))
        {
            System.out.println("Testcase of url passed");
        }
        else
        {
            System.out.println("Testcase of url failed");
        }
    }
}
