package org.sparadrap;

import org.sparadrap.dao.DaoDoctor;
import org.sparadrap.gui.DoctorDisplay;
import org.sparadrap.gui.PatientDisplay;
import org.sparadrap.logConfig.LogConfig;
import org.sparadrap.model.DummyData.DummyData;
import org.sparadrap.model.PatientModel.Patient;
import org.sparadrap.view.MainPage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
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

        private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws SQLException, IOException {
            LogConfig.setup();

                //============= swing ===============//
                //PatientDisplay.allPatientsDisplay();
                //DoctorDisplay.allDoctorsDisplay();

                logger.log(Level.INFO, "Starting SPARADRAP");

                logger.info("loading dummy data");
                DummyData.dummyData();
                logger.log(Level.INFO, "dummy data loaded successfully");

                logger.log(Level.INFO, "Loading main page");
                MainPage.menu();
                logger.log(Level.INFO, "main page loaded successfully");

                logger.info("application started");


    }
}