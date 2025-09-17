import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sparadrap.model.DoctorModel.Doctor;
import org.sparadrap.model.InsuranceModel.Insurance;
import org.sparadrap.model.InsuranceModel.InsurancePlan;
import org.sparadrap.model.MedicineModel.Medicine;
import org.sparadrap.model.MedicineModel.MedicineCategory;
import org.sparadrap.model.PatientModel.Patient;
import org.sparadrap.model.PurchaseModel.Prescription;
import org.sparadrap.model.PurchaseModel.Purchase;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class PurchaseTest {

    private Patient patient;
    private Doctor doctor;
    private Prescription prescription;
    private Medicine med1;
    private Medicine med2;
    private ArrayList<Medicine> meds;

    @BeforeEach
    void setUp(){

        doctor = new Doctor(
                "Alice", "789 Pine St", "3000", "CityC",
                "alice@example.com", "1122334455", "Brown", "APP789"
        );

        // adding incurance plans to insurance company
        ArrayList<InsurancePlan> plans = new ArrayList<>();
        plans.add(InsurancePlan.STANDARD);
        plans.add(InsurancePlan.PREMIUM);

        Insurance insurance = new Insurance(
                "HealthPlus", "1 Health St", "5000", "CityX",
                "contact@healthplus.com", "5555555555", "54", plans
        );

        patient = new Patient("Michael", "12 Elm St", "1010", "CityX", "michael@example.com", "1111111111",
                "1231231231235", "Johnson", LocalDate.of(1990, 5, 10), doctor, insurance, 10);

        med1 = new Medicine("Amoxicillin", MedicineCategory.ANTIBIOTIC, 15, LocalDate.of(2023, 3, 1), 20, true);
        med2 = new Medicine("Ibuprofen", MedicineCategory.PAINKILLER, 8, LocalDate.of(2022, 10, 15), 50, false);

        meds = new ArrayList<>();
        meds.add(med1);
        meds.add(med2);

        prescription = new Prescription(
                LocalDate.of(2025, 5, 5),
                doctor,
                patient,
                meds
        );

    }

    //------------------------------------------------------
    //---------------- Valid cases test -----------------
    //------------------------------------------------------

    // with prescription valid test
    @Test
    void purchaseWithPrescriptionTest(){
        Purchase purchase = new Purchase(prescription,LocalDate.of(2024,5,5),meds);

        assertTrue(purchase.getIsWithPrescription());
        assertEquals(prescription,purchase.getPrescription());
        assertEquals(meds, purchase.getPurchasedMeds());
        assertEquals(LocalDate.of(2024,5,5), purchase.getPurchaseDate());
    }

    // without prescription valid test
    @Test
    void purchaseWithoutPrescriptionValidTest() {
        Purchase purchase = new Purchase(LocalDate.of(2024, 5, 10), meds);

        assertFalse(purchase.getIsWithPrescription());
        assertThrows(IllegalArgumentException.class, () -> purchase.getPrescription());
        assertEquals(meds, purchase.getPurchasedMeds());
        assertEquals(LocalDate.of(2024, 5, 10), purchase.getPurchaseDate());
    }

    //------------------------------------------------------
    //---------------- Invalid cases test -----------------
    //------------------------------------------------------

    @Test
    void purchaseWithNullPurchaseDate() {
        assertThrows(IllegalArgumentException.class, () ->
                new Purchase(prescription, null, meds));
    }

    @Test
    void purchaseWithFutureDate() {
        LocalDate futureDate = LocalDate.now().plusDays(5);
        assertThrows(IllegalArgumentException.class, () ->
                new Purchase(futureDate, meds));
    }


}
