package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import stepdefinition.SharedSD;
import java.text.SimpleDateFormat;
import java.util.*;

public class CalendarActions extends BasePage {

    public int converTextIntoInt(By locator, int end, int finish) {

        int convertedValue = 0;
        try {
            String value = getTextFromElement(locator);
            String modified = value.substring(end, finish);
            convertedValue = Integer.parseInt(modified);
        } catch (NumberFormatException var7) {
            ;
        }
        return convertedValue;
    }

    public ArrayList<String> getCurrentTime(int hour) {

        ArrayList<String> calendar = new ArrayList<>();
        int i;
        for (i = 2; i < 24; i += 2) {
            SimpleDateFormat sdf1 = new SimpleDateFormat("h aa");
            Calendar cl = Calendar.getInstance();
            cl.add(Calendar.HOUR_OF_DAY, i);
            Date date = cl.getTime();
            String strDate = sdf1.format(date);
            calendar.add(strDate.toLowerCase().replaceAll("\\s", ""));
        }
        return calendar;
    }

    public List<String> getHoursFromTimeline(By locator) {

        List<WebElement> hoursWeb = SharedSD.getDriver().findElements(locator);
        List<String> hourList = new ArrayList<String>();
        for (WebElement hour : hoursWeb) {
            String displayedHours = hour.getText();
            hourList.add(displayedHours);
        }
        return hourList;
    }

    public static void dateVerification(By locator) {
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd");
        Calendar cl = Calendar.getInstance();
        Date date = cl.getTime();
        String strDate = sdf1.format(date);
        System.out.println("Date " + strDate);

        List<WebElement> days = SharedSD.getDriver().findElements(locator);
        for (WebElement day : days) {
            String expectedDay = day.getText();
            if (expectedDay.equals(strDate)) {
                Assert.assertEquals(expectedDay,strDate, "The date is selected to todays date");
                break;}


        }
    }
}






