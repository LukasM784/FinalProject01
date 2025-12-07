import org.LukasM.Address;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.Assert.assertEquals;

public class FinalProjectTest {


    @Test
    @DisplayName("A1B1C -> False")
    public void isPostalCodeValidTest1() {
        String postalCode = "A1B1C";
        boolean expected = false;
        boolean actual = Address.isPostalCodeValid(postalCode);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("AB11C1 -> False")
    public void isPostalCodeValidTest2() {
        String postalCode = "AB11C1";
        boolean expected = false;
        boolean actual = Address.isPostalCodeValid(postalCode);
        assertEquals(expected, actual);

    }

    @Test
    @DisplayName("A1B1C1 -> True")
    public void isPostalCodeValidTest3() {
        String postalCode = "A1B1C1";
        boolean expected = true;
        boolean actual = Address.isPostalCodeValid(postalCode);
        assertEquals(expected, actual);

    }
}
