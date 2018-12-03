package framework;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import stepdefinition.SharedSD;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HerokuActions {


    public void verifyInvalidEmail (){


//        String myWindowHandle = SharedSD.getDriver().getWindowHandle();
//        SharedSD.getDriver().switchTo().window(myWindowHandle);
//        System.out.println("Text" + myWindowHandle);

//        String parentWindow =  SharedSD.getDriver().getWindowHandle();
//        Set<String> windowHandles =  SharedSD.getDriver().getWindowHandles();
//        Iterator<String> iterator = windowHandles.iterator();
//        while (iterator.hasNext()) {
//            String handle = iterator.next();
//            if (!handle.contains(parentWindow)) {
//                // Switch to popup
//                SharedSD.getDriver().switchTo().window(handle);
//                // Add code to find element
//            }
//            System.out.println("Size " + windowHandles);
//        }

        Alert alert = SharedSD.getDriver().switchTo().alert();
       String text = alert.getText();
        System.out.println("text " + text);

    }
}

