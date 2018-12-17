package framework;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import stepdefinition.SharedSD;

import java.io.File;
import java.io.IOException;

public class ScreenShot extends SharedSD{

    public static String driverPath = (new java.io.File("").getAbsolutePath());

    public  static void takeScreenShot() throws IOException {
        // Take screenshot and store as a file format
        File src= ((TakesScreenshot)SharedSD.getDriver()).getScreenshotAs(OutputType.FILE);
        try {
// now copy the  screenshot to desired location using copyFile //method
            FileUtils.copyFile(src, new File(driverPath+ "/Images/errorMessage.png"));
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());

        }
    }

}