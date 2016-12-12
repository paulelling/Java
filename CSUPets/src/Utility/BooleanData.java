package Utility;

public class BooleanData {
    
    public static int convertBooleanToInt(boolean value) {
        int returnValue = 0;
        
        if (value) {
            returnValue = 1;
        }
        
        return returnValue;
    }
    
    public static boolean convertIntToBoolean(int value) {
        boolean returnValue = false;
        
        if (value != 0) {
            returnValue = true;
        }
        
        return returnValue;
    }
    
}
