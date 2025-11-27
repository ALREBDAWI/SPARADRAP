package org.sparadrap.logConfig;

import java.io.File;
import java.io.IOException;
import java.util.logging.*;

public class LogConfig {
    public static void setup(){
        Logger rootLogger = Logger.getLogger(""); //root log
        Handler fileHandler;
        try {
            fileHandler = new FileHandler("log/app.log",true);
            rootLogger.setLevel(Level.ALL);
            fileHandler.setFormatter(new SimpleFormatter());
        } catch (IOException e) {
            rootLogger.log(Level.SEVERE,"Error creating log file",e);
        }
    }
}
