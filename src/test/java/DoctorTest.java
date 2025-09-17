import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sparadrap.model.DoctorModel.Doctor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class DoctorTest {

    private Doctor doctor;

    @BeforeEach
    public void setup() {
        doctor = new Doctor(
                "Samer", "123 Happiness St", "1000", "CityA",
                "mo.yo@example.com", "1234567890", "Aram", "APP123"
        );
    }

    @Test
    void doctorValidApprovalNumberTest(){
        assertEquals("APP123", doctor.getApprovalNumber());
    }

    @Test
    void doctorValidFullNameTest(){
        assertEquals("Samer Aram", doctor.getFullName());
    }

    @Test
    void doctorInvalidApprovalNumberTest(){
        assertThrows(IllegalArgumentException.class,
                () -> {doctor.setApprovalNumber("12"); // too short
        });
    }
}
