import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sparadrap.model.DoctorModel.Doctor;
import org.sparadrap.model.InsuranceModel.Insurance;
import org.sparadrap.model.InsuranceModel.InsurancePlan;
import org.sparadrap.model.MedicineModel.Medicine;
import org.sparadrap.model.MedicineModel.MedicineCategory;
import org.sparadrap.model.PatientModel.Patient;
import org.sparadrap.model.PrescriptionModel.Prescription;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class PrescriptionTest {

    private Patient patient;
    private Doctor doctor;
    private Prescription prescription;
    private Medicine med1;
    private Medicine med2;

    @BeforeEach
    public void setUp(){

        // adding insurance plans to insurance company
        ArrayList<InsurancePlan> plans = new ArrayList<>();
        plans.add(InsurancePlan.STANDARD);
        plans.add(InsurancePlan.PREMIUM);

        doctor = new Doctor(
                "Alice", "789 Pine St", "3000", "CityC",
                "alice@example.com", "1122334455", "Brown", "APP789"
        );

        Insurance insurance = new Insurance(
                "HealthPlus", "1 Health St", "5000", "CityX",
                "contact@healthplus.com", "5555555555", "54", plans
        );

        patient = new Patient("Michael", "12 Elm St", "1010", "CityX", "michael@example.com", "1111111111",
                "1231231231235", "Johnson", LocalDate.of(1990, 5, 10), doctor, insurance, 10);

        med1 = new Medicine("Amoxicillin", MedicineCategory.ANTIBIOTIC, 15, LocalDate.of(2023, 3, 1), 20, true);
        med2 = new Medicine("Ibuprofen", MedicineCategory.PAINKILLER, 8, LocalDate.of(2022, 10, 15), 50, false);

        prescription = new Prescription(
                LocalDate.of(2025, 5, 5),
                doctor,
                patient,
                new ArrayList<>(List.of(med1, med2))
        );

    }

    //------------------------------------------------------
    //---------------- Valid cases test -----------------
    //------------------------------------------------------

    @Test
    void prescriptionValidDate(){
        assertEquals(LocalDate.of(2025, 5, 5), prescription.getPrescriptionDate());
    }

    @Test
    void prescriptionValidDoctor(){
        assertEquals(doctor, prescription.getTreatingDoctor());
    }

    @Test
    void prescriptionValidMedsList(){
        assertEquals(med1, prescription.getMedicineList().getFirst());
    }

    @Test
    void prescriptionValidMedsList2(){
        assertEquals(med2, prescription.getMedicineList().getLast());
    }

    //------------------------------------------------------
    //---------------- Invalid cases test -----------------
    //------------------------------------------------------

    //future prescription date
    @Test
    void prescriptionInvalidDate(){
        LocalDate futureDate = LocalDate.of(2026, 5, 5);
        assertThrows(IllegalArgumentException.class, () -> new Prescription(futureDate,doctor,patient,new ArrayList<>(List.of(med1,med2))));
    }

    // doctor is null
    @Test
    void prescriptionInvalidDoctor(){
        assertThrows(IllegalArgumentException.class, () -> new Prescription(LocalDate.of(2025,5,5),null,patient,new ArrayList<>(List.of(med1,med2))));
    }

    // patient is null
    @Test
    void prescriptionInvalidPatient(){
        assertThrows(IllegalArgumentException.class, () -> new Prescription(LocalDate.of(2025,5,5),doctor,null,new ArrayList<>(List.of(med1,med2))));
    }

    // empty medicines list
    @Test
    void setPrescriptionInvalidEmptyMedsList(){
        assertThrows(IllegalArgumentException.class, () -> new Prescription(LocalDate.of(2025,5,5),null,patient,new ArrayList<>(List.of())));
    }
}
