package testNG_Package;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class takeScreenshot {
    public static String getScreenshot(WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        String source = ts.getScreenshotAs(OutputType.BASE64);
        /*String path = "./screenshots/sample.png";
        File destination = new File(path);
        FileUtils.copyFile(source,destination);*/
        return source;
    }
}
