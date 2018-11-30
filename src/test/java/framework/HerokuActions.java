package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import stepdefinition.SharedSD;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HerokuActions {

    public void getContainerElements(By locator, String parameter) {

        List<WebElement> listOfElements = SharedSD.getDriver().findElements(locator);
        List<String> allElements = new ArrayList<String>();
        for (WebElement option : listOfElements) {
            String element = option.getText();
            allElements.add(element);
        }
        System.out.println("Elements are" + allElements);
        List<String> allElementMod = new ArrayList<String>();
        allElementMod.addAll(allElements);
        Iterator<String> i = allElementMod.iterator();
        while (i.hasNext()) {
            String o = i.next();
            if (o.equals(parameter))
                i.remove();
        }
        System.out.println("new list" + allElements);
        System.out.println("Total elements " + allElementMod.size());
        Assert.assertNotEquals(allElements != allElementMod, "All post do not have attribute");
    }

    public void getAttributeFromElement(By locator, String parameter) {
        List<WebElement> listOfElements1 = SharedSD.getDriver().findElements(locator);
        List<String> newElements = new ArrayList<String>();
        for (WebElement option : listOfElements1) {
            String element = option.getAttribute("src");
            newElements.add(element);
            System.out.println("Images " + element);
            if (element.equals("https://floating-anchorage-58495.herokuapp.com/img/copywrite.jpg")) {
                newElements.remove(element);
            }
        }
        Assert.assertNotEquals(listOfElements1.size(), newElements.size(), "All post do not have attribute");
    }
    public void verifyInvalidEmail (){
        String myWindowHandle = SharedSD.getDriver().getWindowHandle();
        SharedSD.getDriver().switchTo().window(myWindowHandle);
        System.out.println("Text" + myWindowHandle);

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

        //Alert alert = SharedSD.getDriver().switchTo().alert();
        //String alertText = alert.getText();

        //return alertText;
    }
}

