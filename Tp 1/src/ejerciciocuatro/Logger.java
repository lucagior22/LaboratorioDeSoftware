package ejerciciocuatro;

public class Logger {
    private static Logger instance;

    private Logger() {}

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void logInfo (String info) {
        System.out.println(info);
    }

    public void logWarning (String warning) {
        System.out.println("\u001B[33m" + warning + "\u001B[0m");
    }

    public void logError (String error) {
        System.out.println("\u001B[31m" + error + "\u001B[0m");
    }

}
