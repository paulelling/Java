package Utility;

import java.util.*;
import java.text.*;

public class DateData {
    
    public static Date convertStringToDate(String value) {
        Date returnDate = null;
        DateFormat format = new SimpleDateFormat("MM/d/yyyy", Locale.ENGLISH);
        
        try {
            returnDate = format.parse(value);
        }
        catch (Exception e) {
            System.out.println("Exception DateData.convertStringToDate: " + e.getMessage());
        }
        
        return returnDate;    
    }
    
}
