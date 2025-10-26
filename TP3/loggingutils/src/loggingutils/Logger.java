package loggingutils;

public class Logger {

    private java.util.logging.Logger instance =  java.util.logging.Logger.getLogger("");


    public void logInfo(String mensaje){
        instance.info(mensaje);
    }

    public void logWarning(String mensaje){
        instance.warning(mensaje);
    }

    public void logError(String mensaje){
        instance.severe(mensaje);
    }


}
