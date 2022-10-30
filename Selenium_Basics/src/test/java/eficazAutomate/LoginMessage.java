package eficazAutomate;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginMessage {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
        driver.get("http://ebl.eficaztechsol.com/superadmin");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("superadmin@gmail.com");
        driver.findElement(By.xpath("//input[@id='password-field']")).sendKeys("12345678");
        driver.findElement(By.xpath("//button[@class='btn btn-primary au-btn--blue w-100 super_submit']")).click();
        Alert al = driver.switchTo().alert();
        String alertMsg=al.getText();
        System.out.println(alertMsg);
        //Thread.sleep(3000);
        al.accept();
        driver.close();
        //al.dismiss();

    }
}
