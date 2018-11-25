package framework;



import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class TestCal {


    public static void main(String[] args) {

                int counter =0;
        //String [] calendars = new String[11];

        ArrayList<String> calen = new ArrayList<>();
            for (int i=2; i < 24; i += 2) {
                counter+=1;
                SimpleDateFormat sdf1 = new SimpleDateFormat("h aa");
                Calendar cl1 = Calendar.getInstance();
                // Date date = new Date();
                cl1.add(Calendar.HOUR_OF_DAY, i);
                Date date1=cl1.getTime();
                String strDate1 = sdf1.format(date1);
                calen.add(strDate1.toLowerCase().replaceAll("\\s", ""));

                    System.out.println(calen);
                if (counter==13)
                {
                    break;
                }

//calen.remove(1);
            }
        //System.out.println(Arrays.asList(calendars));
        }



}

