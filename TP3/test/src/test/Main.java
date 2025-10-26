package test;

import loggingutils.Logger;

public class Main {
    public static void main(String[] args) {
        Logger l = new Logger();

        l.logInfo("Información");
        l.logWarning("Advertencia");
        l.logError("Error");
    }
}