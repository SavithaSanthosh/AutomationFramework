package AmazonApplication;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class loginAmazon {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2Fyour-account%3Fref_%3Dnav_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys("vssavia705@gmail.com");
        driver.findElement(By.xpath("//input[@id='continue']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys("SaViTHa@23");
        driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();

        String expectedURL="https://www.amazon.in/gp/yourstore/home?path=%2Fgp%2Fyourstore%2Fhome&signIn=1&useRedirectOnSuccess=1&action=sign-out&ref_=nav_AccountFlyout_signout";
        String actualURL= driver.getCurrentUrl();
        if (expectedURL.equals(actualURL))
        {
            System.out.println("Testcase passed");
        }
        else
        {
            System.out.println("Testcase failed");
        }
        Thread.sleep(3000);
       // driver.close();
    }
}
