package org.sparadrap;

import org.sparadrap.logConfig.LogConfig;
import org.sparadrap.model.DummyData.DummyData;
import org.sparadrap.view.MainPage;

import java.io.File;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 * Main class - entry point of the application.
 * <p>
 * This class initializes dummy data and launches the main menu of the application.
 */
public class Main {

    /**
     * Main method - starts the program.
     * <p>
     * It first loads dummy data into the system using {@link DummyData#dummyData()},
     * then displays the main menu via {@link MainPage#menu()}.
     *
     * @param args command-line arguments (not used)
     */

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) throws SQLException {

        LogConfig.setup();
        LOGGER.info("application is started");
        DummyData.dummyData();
        MainPage.menu();


    }
}