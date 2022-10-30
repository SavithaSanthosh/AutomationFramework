package testNG_Package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class dropdownHandling {
    WebDriver driver;
    @BeforeMethod
    public void initialize() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }
    @Test
    public void dropdownSelection() throws InterruptedException {

        Select objSelect = new Select(driver.findElement(By.xpath("//select[@id='dropdown-class-example']")));
        objSelect.selectByVisibleText("Option1");
        Thread.sleep(3000);
        //objSelect.selectByValue("option2");
    }
    @AfterMethod
    public void Close(){
        driver.quit();
    }
}
