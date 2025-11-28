package org.sparadrap.logConfig;

import java.io.File;
import java.io.IOException;
import java.util.logging.*;

public class LogConfig {

    public static void setup() throws IOException {

        try {

            new File("./log").mkdirs();

            Logger rootLogger = Logger.getLogger("");
            rootLogger.setLevel(Level.ALL);

            ConsoleHandler consoleHandler = new ConsoleHandler();
            consoleHandler.setLevel(Level.ALL);
            consoleHandler.setFilter(record -> record.getLoggerName().startsWith("org.sparadrap"));
            rootLogger.addHandler(consoleHandler);

            FileHandler fileHandler = new FileHandler("./log/app-%g.log", 1024*1024, 1, true);
            fileHandler.setLevel(Level.ALL);
            fileHandler.setFormatter(new SimpleFormatter());
            fileHandler.setFilter(record -> record.getLoggerName().startsWith("org.sparadrap"));
            rootLogger.addHandler(fileHandler);

            rootLogger.info("LogConfig setup complete");
        }catch(IOException e){
            e.printStackTrace();
            System.err.println("problem while setting up Logger" + e.getMessage());
        }

    }
}
