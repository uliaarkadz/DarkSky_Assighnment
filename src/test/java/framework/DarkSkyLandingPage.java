

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
    private By lowTempToday = By.xpath("//div[@class='dayDetails revealed']//span[@class='highTemp swip']//span[@class='temp']");
    private By highTempToday = By.xpath("/html[1]/body[1]/div[6]/a[1]/span[2]/span[3]");


    //a[@class='day revealed']//span[@class='tempRange']//span[@class='minTemp']


    CalendarActions calendarActions = new CalendarActions();


    @Step
    public void clickOnSearchField() {
        clickOn(searchField);
    }

    public void clearSearchField() {
        clearTextField(searchField);
    }

    public void enterZipCode(String zip) {
        sendText(searchField, zip);
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

        int temp = calendarActions.converTextIntoInt(currentTemperature, 0, 2);
        int tempLow = calendarActions.converTextIntoInt(lowTemperature, 5, 7);
        int tempHigh = calendarActions.converTextIntoInt(highTemperature, 6, 8);
        if (temp >= tempLow && temp <= tempHigh) {
            System.out.println("The current temperature is between low and high value");
        } else {
            Assert.fail("The current temperature is above high value");
        }
    }

    public void verifyTimeline(int hour) {
        Assert.assertEquals(calendarActions.getCurrentTime(hour), calendarActions.getHoursFromTimeline(timeLine), "The element are not equal");
        System.out.println("Timeline is displayed with 2 hours incremented");
    }

    public void expandTodaysTimeline() throws InterruptedException {
        Thread.sleep(4000L);
        scrollOnThePage();
        this.clickOn(todaysTimeline);
    }

    public void verifyTodaysTimelineTemp() {
        int tempLowTimeline = calendarActions.converTextIntoInt(lowTemperature, 5, 7);
        int tempHighTimeline = calendarActions.converTextIntoInt(highTemperature, 6, 8);

        int tempLowToday = calendarActions.converTextIntoInt(lowTempToday, 0, 2);
        int tempHighToday = calendarActions.converTextIntoInt(highTempToday, 0, 2);

        Assert.assertTrue(tempLowToday == tempLowTimeline
                || tempHighTimeline == tempHighToday, "Lowest and highest temp is displayed correctly");
    }
}
