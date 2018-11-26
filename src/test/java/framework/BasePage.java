//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package framework;

import java.text.SimpleDateFormat;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import stepdefinition.SharedSD;

public class BasePage {


    public void clickOn(By locator) {
        try {
            SharedSD.getDriver().findElement(locator).click();
        } catch (NoSuchElementException var3) {
            Assert.fail("Element is not found with this locator: " + locator.toString());
            var3.printStackTrace();
        }

    }

    public void sendText(By locator, String text) {
        try {
            SharedSD.getDriver().findElement(locator).sendKeys(new CharSequence[]{text});
        } catch (NoSuchElementException var4) {
            Assert.fail("Element is not found with this locator: " + locator.toString());
            var4.printStackTrace();
        }

    }

    public String getTextFromElement(By locator) {
        String text = null;

        try {
            text = SharedSD.getDriver().findElement(locator).getText();
        } catch (NoSuchElementException var4) {
            Assert.fail("Element is not found with this locator: " + locator.toString());
            var4.printStackTrace();
        }

        return text;
    }

    public void clickOnBrowserBackArrow() {
        SharedSD.getDriver().navigate().back();
    }

    public void clickOnBrowserForwardArrow() {
        SharedSD.getDriver().navigate().forward();
    }

    public void refreshBrowser() {
        SharedSD.getDriver().navigate().refresh();
    }

    public void autoComplete(By locator, String destination) {
        List<WebElement> list = SharedSD.getDriver().findElements(locator);
        Iterator var4 = list.iterator();

        while (var4.hasNext()) {
            WebElement ele = (WebElement) var4.next();
            if (ele.getText().contains(destination)) {
                ele.click();
                break;
            }
        }

    }

    public static void selectingDropDown(By locator, String value) {
        WebElement dropDown = SharedSD.getDriver().findElement(locator);
        Select s = new Select(dropDown);
        s.selectByValue(value);
    }

    public void clearTextField(By locator) {
        try {
            SharedSD.getDriver().findElement(locator).clear();
        } catch (NoSuchElementException var3) {
            Assert.fail("Element is not found with this locator: " + locator.toString());
            var3.printStackTrace();
        }

    }
}

