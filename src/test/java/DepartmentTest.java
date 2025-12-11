import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.lucy.Department;

public class DepartmentTest {

    @Test
    @DisplayName("English -> true")
    void isDepartmentNameValidTest1() {
        String departmentName = "English";
        boolean expected = true;
        boolean actual = Department.isDepartmentNameValid(departmentName);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Computer Science -> true")
    void isDepartmentNameValidTest2() {
        String departmentName = "Computer Science";
        boolean expected = true;
        boolean actual = Department.isDepartmentNameValid(departmentName);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Math1 -> false")
    void isDepartmentNameValidTest3() {
        String departmentName = "Math1";
        boolean expected = false;
        boolean actual = Department.isDepartmentNameValid(departmentName);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Math! -> false")
    void isDepartmentNameValidTest4() {
        String departmentName = "Math!";
        boolean expected = false;
        boolean actual = Department.isDepartmentNameValid(departmentName);

        Assertions.assertEquals(expected, actual);
    }
}
