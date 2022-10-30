package eficazAutomate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrganisationAdminLogin {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://ebl.eficaztechsol.com/adminlogin");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("savitha.eficaz@gmail.com");
        driver.findElement(By.xpath("//input[@id='password-field']")).sendKeys("Admin@123");
        driver.findElement(By.xpath("//button[@class='btn btn-primary au-btn--blue w-100 btn_submit']")).click();
        Thread.sleep(3000);
        String expectedURL="http://ebl.eficaztechsol.com/org-admin/dashboard";
        String actualURL= driver.getCurrentUrl();
        if (expectedURL.equals(actualURL))
        {
            System.out.println("Testcase passed");
        }
        else
        {
            System.out.println("Testcase failed");
        }
        driver.close();
    }
}
