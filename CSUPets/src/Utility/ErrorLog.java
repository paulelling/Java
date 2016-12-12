package Utility;

public class ErrorLog {
    private static ErrorLog uniqueInstance;
    
    private ErrorLog() {}
    
    public static synchronized ErrorLog getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new ErrorLog();
        }
        return uniqueInstance;    
    }
}
