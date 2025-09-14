package loggingutils;

public class Logger {
    private static java.util.logging.Logger instance = java.util.logging.Logger.getLogger("");

    public void logInfo (String info) {
        instance.info(info);
    }

    public void logWarning (String warning) {
        instance.warning(warning);
    }

    public void logError (String error) {
        instance.severe(error);
    }

}
