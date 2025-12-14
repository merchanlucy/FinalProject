import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.lucy.Address;
import org.lucy.Course;
import org.lucy.Department;
import org.lucy.Student;

public class StudentTest {

    @Test
    @DisplayName("student = null -> false")
    void testRegisterCourse1() {
        Address address = new Address(1, "Rue", "Montreal", Address.Province.QC, "X1X2X3");
        Department department = new Department("Computer Science");
        Student student = new Student("Luciana Merchan", Student.Gender.FEMALE, address, department);

        boolean expected = false;
        boolean actual = student.registerCourse(null);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("register a student -> true")
    void testRegisterCourse2() {
        Address address = new Address(1, "Rue", "Montreal", Address.Province.QC, "X1X2X3");
        Department department = new Department("Computer Science");
        Student student = new Student("Luciana Merchan", Student.Gender.FEMALE, address, department);
        Course course = new Course("Intro to Programming", 2.66, department);

        boolean expected = true;
        boolean actual = student.registerCourse(course);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("registered student drops course -> true")
    void testDropCourse1() {
        Address address = new Address(1, "Rue", "Montreal", Address.Province.QC, "X1X2X3");
        Department department = new Department("Computer Science");
        Student student = new Student("Luciana Merchan", Student.Gender.FEMALE, address, department);
        Course course = new Course("Intro to Programming", 2.66, department);

        student.registerCourse(course);

        boolean expected = true;
        boolean actual = student.dropCourse(course);
        Assertions.assertEquals(expected, actual);
    }

   @Test
    @DisplayName("unregistered student drops course -> false")
    void testDropCourse2() {
        Address address = new Address(1, "Rue", "Montreal", Address.Province.QC, "X1X2X3");
        Department department = new Department("Computer Science");
        Student student = new Student("Luciana Merchan", Student.Gender.FEMALE, address, department);
        Course course = new Course("Intro to Programming", 2.66, department);

        boolean expected = false;
        boolean actual = student.dropCourse(course);
        Assertions.assertEquals(expected, actual);
    }
}
