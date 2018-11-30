package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import stepdefinition.SharedSD;
import java.text.SimpleDateFormat;
import java.util.*;

public class CalendarActions extends BasePage{


    public void autoComplete(By locator, String text) {

        List<WebElement> list = SharedSD.getDriver().findElements(locator);
        for (WebElement ele : list) {
            if (ele.getText().contains(text)) {
                ele.click();
                break;}
        }
    }

    public static void pickDate(By locator, int noOfDays) {
        SimpleDateFormat sdf = new SimpleDateFormat("d");
        Calendar cl = Calendar.getInstance();
        cl.setTime(new Date());
        cl.add(5, noOfDays);
        String futureDate = sdf.format(cl.getTime());
        List<WebElement> days = SharedSD.getDriver().findElements(locator);
        Iterator var6 = days.iterator();
        while (var6.hasNext()) {
            WebElement day = (WebElement) var6.next();
            String expectedDay = day.getText();
            if (expectedDay.equals(futureDate)) {
                day.click();
                break;
            }
        }
    }
    public int converTextIntoInt(By locator, int end, int finish) {
        int convertedValue = 0;

        try {
            String value = getTextFromElement(locator);
            String modified = value.substring(end, finish);
            convertedValue = Integer.parseInt(modified);
        } catch (NumberFormatException var7) {
            ;
        }return convertedValue;
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
        }return calendar;
    }

    public List<String> getHoursFromTimeline(By locator) {

        List<WebElement> hoursWeb = SharedSD.getDriver().findElements(locator);
        List<String> hourList = new ArrayList<String>();
        for (WebElement hour : hoursWeb) {
            String displayedHours = hour.getText();
            hourList.add(displayedHours);
        }return hourList;
    }



}

