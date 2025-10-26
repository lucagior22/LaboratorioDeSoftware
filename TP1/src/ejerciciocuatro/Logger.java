package ejerciciocuatro;

public class Logger {

    private static Logger instance = null;


    private Logger(){}

    public static Logger getInstance(){
        if (instance == null){
            instance = new Logger();
        }
        return instance;
    }

    public void logInfo(String mensaje){
        System.out.println("Info: " + mensaje);
    }

    public void logWarning(String mensaje){
        System.out.println("Warning: " + mensaje);
    }

    public void logError(String mensaje){
        System.out.println("Error: " + mensaje);
    }


}
