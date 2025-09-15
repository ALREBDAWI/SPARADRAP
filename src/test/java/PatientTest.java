import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.sparadrap.model.Doctor;
import org.sparadrap.model.Insurance;
import org.sparadrap.model.Patient;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class PatientTest {
    private Patient patient;
    private Doctor doctor;
    private Insurance insurance;
    @BeforeEach
    public void setup() {
        insurance = new Insurance(
                "HealthPlus", "1 Health St", "5000", "CityX",
                "contact@healthplus.com", "5555555555", "54"
        );

        doctor = new Doctor(
                "Mohamad", "123 Happiness St", "1000", "CityA",
                "mo.yo@example.com", "1234567890", "Yosef", "APP123"
        );

        patient = new Patient("Adam", "12 Elm St", "1010", "CityX", "adam@example.com", "1111111111",
                "1231231231235", "Omar", LocalDate.of(1990, 5, 10), doctor, insurance, 10);
    }

    //------------------------------------------------------
    //---------------- Valid cases test -----------------
    //------------------------------------------------------
    //testing name, lastname, address, phone number, email works for all other classes as it is inherited from Abstract Entity class

    @Test
    public void patientTestValidName(){
        assertEquals("Adam", patient.getName());
    }

    @Test
    void patientTestValidLastName(){
        assertEquals("Omar", patient.getLastName());
    }

    @Test
    void patientTestValidAddress(){
        assertEquals("12 Elm St", patient.getAddress());
    }

    @Test
    void patientTestValidEmail(){
        assertEquals("adam@example.com", patient.getEmail());
    }

    @Test
    void patientTestValidPhoneNumber(){
        assertEquals("1111111111", patient.getTelephone());
    }

    @Test
    void patientTestValidDateOfBirth(){
        assertEquals(LocalDate.of(1990, 5, 10), patient.getDateOfBirth());
    }

    @Test
    void patientTestValidSocialSecurityNumber(){
        assertEquals("1231231231235", patient.getSocialSecurityNumber());
    }

    @Test
    void patientTestValidDoctor(){
        assertEquals(doctor, patient.getTreatingDoctor());
    }

    @Test
    void patientTestValidInsurance(){
        assertEquals(insurance, patient.getInsurance());
    }

    @Test
    void patientTestValidPostCode(){
        assertEquals("1010", patient.getPostalCode());
    }

    //------------------------------------------------------
    //---------------- Invalid cases test -----------------
    //------------------------------------------------------

    @Test
    void invalidNameTest(){
        assertThrows(IllegalArgumentException.class,
                () -> { patient.setName("1Adam"); //starts with a digit
        });
    }

    @Test
    void invalidLastNameTest(){
        assertThrows(IllegalArgumentException.class,
                () -> {patient.setLastName("@Rami"); // starts with @
        });
    }

    @Test
    void invalidSocialSecurityNumberTest(){
        assertThrows(IllegalArgumentException.class,
                () -> {patient.setSocialSecurityNumber("123456"); //too short
        });
    }

    @Test
    void invalidAddressTest(){
        assertThrows(IllegalArgumentException.class,
                () -> {patient.setAddress("_90 my address"); //starts with -
        });
    }

    @Test
    void invalidEmailTest(){
        assertThrows(IllegalArgumentException.class,
                () -> {patient.setEmail("rami@gmail.c"); //TLD too short
        });
    }

    @Test
    void invalidEmailTest2(){
        assertThrows(IllegalArgumentException.class,
                () -> {patient.setEmail("@rami@gmail.com"); // starts with @
        });
    }

    @Test
    void invalidEmailTest3(){
        assertThrows(IllegalArgumentException.class,
                () -> {patient.setEmail(".rami@gmail.com"); //starts with a dot
        });
    }

    @Test
    void invalidPhoneNumberTest(){
        assertThrows(IllegalArgumentException.class,
                () -> {patient.setTelephone("1234"); //7 digits minimum
        });
    }

    @Test
    void invalidPostCodeTest(){
        assertThrows(IllegalArgumentException.class,
                () -> {patient.setPostalCode("15"); //too short
        });
    }
}
