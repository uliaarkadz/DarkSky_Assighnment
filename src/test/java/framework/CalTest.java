package framework;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalTest {
    public static void main(String[] args) {
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd");
        Calendar cl = Calendar.getInstance();
        //cl.add(Calendar.HOUR_OF_DAY, i);
        Date date = cl.getTime();
        String strDate = sdf1.format(date);
        System.out.println("Date " + strDate);
    }
}
