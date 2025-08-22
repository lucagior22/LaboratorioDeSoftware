package ejerciciocuatro;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.logInfo("Esto es información");
        logger.logWarning("Esto es un aviso");
        logger.logError("Esto es un error");
    }
}
