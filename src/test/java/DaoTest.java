import org.junit.function.ThrowingRunnable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.sparadrap.dao.DaoDoctor;
import org.sparadrap.dao.DaoPatient;
import org.sparadrap.model.DoctorModel.Doctor;
import org.sparadrap.model.PatientModel.Patient;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class DaoTest {
    @Test
    void getAllDoctors() throws SQLException, IOException {
        ArrayList<Doctor> doctors = new ArrayList<>();
        doctors = DaoDoctor.getAllDoctors();
        assertFalse(doctors.isEmpty());
    }
    @Test
    void getDoctorById() throws SQLException, IOException {
        Doctor doctor = DaoDoctor.getDoctorById(1);
        assertNotNull(doctor);
    }
    @Test
    void getAllPatients() throws SQLException, IOException {
        ArrayList<Patient> patients = new ArrayList<>();
        patients = DaoPatient.getAllPatients();
        assertFalse(patients.isEmpty());
    }
    @Test
    void getPatientById() throws SQLException, IOException {
        Patient patient = DaoPatient.getPatientById(1);
        assertNotNull(patient);
    }

}
