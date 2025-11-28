package org.sparadrap.dao;

import org.sparadrap.logConfig.LogConfig;
import org.sparadrap.model.PatientModel.Patient;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class DaoRun {
    public static void main(String[] args) throws SQLException, IOException {
        LogConfig.setup();

        //ArrayList<Doctor> doctors = new ArrayList<Doctor>();
        //doctors = DaoDoctor.getAllDoctors();
        //System.out.println(doctors);

        //----------------------------------------------------//

        //System.out.println(DaoDoctor.getDoctorById(1));
        //System.out.println(DaoInsurance.getInsuranceById(2));
        System.out.println(DaoDoctor.getAllDoctors());
        //System.out.println(DaoPatient.getAllPatients());
        //System.out.println(DaoPatient.getPatientById(1));
        //DaoPatient.deletePatient(4);


        //====================================================//

        Patient patient = new Patient("Isabella", "Name", "1310258795297", LocalDate.of(1996, 1, 22), "0574255347", "is4@example.com",
                "no mans land", "25000", "70 rue rex", 1, 1 );
        //DaoPatient.addPatient(patient);

    }
}
