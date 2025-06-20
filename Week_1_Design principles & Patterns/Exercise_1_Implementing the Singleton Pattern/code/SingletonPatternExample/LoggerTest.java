

class Logger {
  
    private static Logger instance;
    //constructor 
    private Logger() {
        System.out.println("Logger instance created.");
    }

   
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // Logging method
    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}

public class LoggerTest {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        logger1.log("First log message");

        Logger logger2 = Logger.getInstance();
        logger2.log("Second log message");

        
        if (logger1 == logger2) { // Check if both references point to the same instance
            System.out.println("Both logger1 and logger2 are the same instance.");
        } else {
            System.out.println("Different instances exist. Singleton failed.");
        }
    }
}

