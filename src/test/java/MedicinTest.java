import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sparadrap.model.Medicine;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.sparadrap.model.MedicineCategory.PAINKILLER;

public class MedicinTest {
    private Medicine med;
    @BeforeEach
    void setUp(){
        med = new Medicine("Paracetamol", PAINKILLER, 5, LocalDate.of(2023, 1, 10), 2, false);
    }

    //------------------------------------------------------
    //---------------- Valid cases test -----------------
    //------------------------------------------------------

    @Test
    void medicineValidNameTest(){
        assertEquals("Paracetamol", med.getMedicineName());
    }

    @Test
    void medicineValidCategoryTest(){
        assertEquals(PAINKILLER, med.getCategory());
    }

    @Test
    void medicineValidPriceTest(){
        assertEquals(5, med.getPrice(), 0.001);
    }

    @Test
    void medicineValidQuantityTest(){
        assertEquals(2, med.getQuantity());
    }

    @Test
    void medicineValidDateTest(){
        assertEquals(LocalDate.of(2023, 1, 10), med.getStartDate());
    }


    //------------------------------------------------------
    //---------------- Invalid cases test -----------------
    //------------------------------------------------------

    @Test
    void invalidNameTest(){
        assertThrows(IllegalArgumentException.class,
                () -> med.setMedicineName("@@@"));
    }

    @Test
    void invalidPriceNegativeTest(){
        assertThrows(IllegalArgumentException.class,
                () -> med.setPrice(-10));
    }

    @Test
    void invalidQuantityNegativeTest(){
        assertThrows(IllegalArgumentException.class,
                () -> med.setQuantity(-1));
    }

    @Test
    void invalidFutureDateTest(){
        LocalDate futureDate = LocalDate.now().plusDays(5);
        assertThrows(IllegalArgumentException.class,
                () -> med.setStartDate(futureDate));
    }
}
