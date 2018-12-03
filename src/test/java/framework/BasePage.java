package framework;

import java.time.Duration;
import java.util.*;

import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import stepdefinition.SharedSD;

import static java.time.Duration.ofSeconds;

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

    public static void scrollOnThePage() throws InterruptedException {
        Thread.sleep(4000L);
        JavascriptExecutor js = (JavascriptExecutor) SharedSD.getDriver();
        js.executeScript("window.scrollBy(0,500)", new Object[0]);
        Thread.sleep(10000L);
    }

    public void actions(By locator) {
        try {
            Actions actions = new Actions(SharedSD.getDriver());
            actions.click(SharedSD.getDriver().findElement(locator));
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public void actionsMove(By locator) {
        try {
            Actions actions = new Actions(SharedSD.getDriver());
            //actions.perform();
            actions.moveToElement(SharedSD.getDriver().findElement(locator));
            //actions.pause(ofSeconds(6));
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public int getElementsCount(By locator) {
        List<WebElement> list = SharedSD.getDriver().findElements(locator);
        int sizeOfElements = list.size();
        return sizeOfElements;
    }

    public List<String> getContainerElements(By locator, String parameter) {

        List<WebElement> listOfElements = SharedSD.getDriver().findElements(locator);
        List<String> allElements = new ArrayList<String>();
        for (WebElement option : listOfElements) {
            String element = option.getText();
            allElements.add(element);
        }
        List<String> allElementMod = new ArrayList<String>();
        allElementMod.addAll(allElements);
        Iterator<String> i = allElementMod.iterator();
        while (i.hasNext()) {
            String o = i.next();
            if (o.equals(parameter))
                i.remove();
        }
        return allElements;
    }

    public List<String>  getAttributeFromElement(By locator, String parameter) {
        List<WebElement> listOfElements1 = SharedSD.getDriver().findElements(locator);
        List<String> newElements = new ArrayList<String>();
        for (WebElement option : listOfElements1) {
            String element = option.getAttribute("src");
            newElements.add(element);
            if (element.equals(parameter)) {
                newElements.remove(element);
            }
        }return newElements;

    }
    public String generateRandomName(){
        Faker faker = new Faker();
        String randomName = faker.internet().emailAddress();
    return randomName;
    }
}






