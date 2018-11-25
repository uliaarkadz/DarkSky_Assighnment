//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package framework;

import org.openqa.selenium.By;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;


public class DarkSkyLandingPage extends BasePage {
    private By searchField = By.xpath("//input[@type='text']");
    private By magniFyingGlass = By.xpath("//a[@class='searchButton']");
    private By currentTemperature = By.xpath("//span[@class='summary swap']");
    private By lowTemperature = By.xpath("//span[@class='currently']//span[2]//span[2]//span[2]");
    private By highTemperature = By.xpath("//span[@class='summary-high-low']//span[3]");
    private By timeLine = By.xpath("//span[@class='hour']//descendant::*");
    private By todaysTimeline = By.xpath("//body[@class='forecast']/div[@id='week']/a[1]/span[3]/span[1]/*[1]");
    private By lowTempToday = By.xpath("/html[1]/body[1]/div[6]/a[1]/span[2]/span[1]");
    private By highTempToday = By.xpath("/html[1]/body[1]/div[6]/a[1]/span[2]/span[3]");

    @Step
    public void clickOnSearchField() {
        clickOn(searchField);
    }

    public void clearSearchField() {
        clearTextField(searchField);
    }

    public void enterZipCode(String zip) {
        this.sendText(searchField, zip);
    }

    public void clickOnMagnifyingGlass() {
        clickOn(magniFyingGlass);
    }

    public void verifyCurrentTemperature() {
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException var4) {
            var4.printStackTrace();
        }
        int temp = converTextIntoInt(currentTemperature, 0, 2);
        int tempLow = converTextIntoInt(lowTemperature, 5, 7);
        int tempHigh = converTextIntoInt(highTemperature, 6, 8);
        if (temp >= tempLow && temp <= tempHigh) {
            System.out.println("The current temperature is between low and high value");
        } else {
            Assert.fail("The current temperature is above high value");
        }
    }

    public void verifyTimeline(int hour) {
        Assert.assertEquals(getCurrentTime(hour), getHoursFromTimeline(timeLine), "The element are not equal");
        System.out.println("Timeline is displayed with 2 hours incremented");
    }

}
