import java.util.*;

import java.text.*;

 

public class DateExample {

    public static void main(String args[]) {

        // Instantiate a Date object

        Date date = new Date();

        // Get current date and time

        // 1st way: current time and date using toString()
        System.out.println("Today's date is: "+date.toString());
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        System.out.println("Today's date is: "+dateFormat.format(date));
        
        Date d = new Date(2017, 08, 23); // January 16, 1963
 System.out.println("Day of the week: " + d.getDay());
    }
}
