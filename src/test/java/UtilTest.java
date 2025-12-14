import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.Util;

public class UtilTest {
    @Test
    @DisplayName("hello how are you -> Hello How Are You")
    void testUtil1() {
        String str = "hello how are you";
        String expected = "Hello How Are You";
        String actual = Util.toTitleCase(str);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("null -> null")
    void testUtil2() {
        String str = null;
        String expected = null;
        String actual = Util.toTitleCase(str);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("\"\" -> \"\"")
    void testUtil3() {
        String str = "";
        String expected = "";
        String actual = Util.toTitleCase(str);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("HELLO -> Hello")
    void testUtil4() {
        String str = "HELLO";
        String expected = "Hello";
        String actual = Util.toTitleCase(str);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("\" \" -> \" \"")
    void testUtil5() {
        String str = " ";
        String expected = "";
        String actual = Util.toTitleCase(str);

        Assertions.assertEquals(expected, actual);
    }
}
