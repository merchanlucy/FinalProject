import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.lucy.Address;

public class AddressTest {

    @Test
    @DisplayName("H4R2M9 -> true")
    void isPostalCodeValidTest1() {
        String postalCode = "H4R2M9";
        boolean expected = true;
        boolean actual = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("h4r2m9 -> true")
    void isPostalCodeValidTest2() {
        String postalCode = "h4r2m9";
        boolean expected = true;
        boolean actual = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("null -> false")
    void isPostalCodeValidTest3() {
        String postalCode = null;
        boolean expected = false;
        boolean actual = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("0x0x0x -> false")
    void isPostalCodeValidTest4() {
        String postalCode = "0x0x0x";
        boolean expected = false;
        boolean actual = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expected, actual);
    }
}
