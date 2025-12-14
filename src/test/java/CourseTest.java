import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.lucy.Address;
import org.lucy.Course;
import org.lucy.Department;
import org.lucy.Student;

public class CourseTest {

    @Test
    @DisplayName("student = null -> false")
    void testRegisterStudent1() {
        Department department = new Department("Computer Science");
        Course course = new Course("Intro to Programming", 2.66, department);

        boolean expected = false;
        boolean actual = course.registerStudent(null);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("register student -> true")
    void testRegisterStudent2() {
        Address address = new Address(1, "Rue", "Montreal", Address.Province.QC, "X1X2X3");
        Department department = new Department("Computer Science");
        Student student = new Student("Luciana Merchan", Student.Gender.FEMALE, address, department);
        Course course = new Course("Intro to Programming", 2.66, department);

        boolean expected = true;
        boolean actual = course.registerStudent(student);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("student already registered -> false")
    void testRegisterStudent3() {
        Address address = new Address(1, "Rue", "Montreal", Address.Province.QC, "X1X2X3");
        Department department = new Department("Computer Science");
        Student student = new Student("Luciana Merchan", Student.Gender.FEMALE, address, department);
        Course course = new Course("Intro to Programming", 2.66, department);
        course.registerStudent(student);

        boolean expected = false;
        boolean actual = course.registerStudent(student);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("assignment weight total = 100 -> true")
    void testIsAssignmentWeightValid1() {
        Department department = new Department("Computer Science");
        Course course = new Course("Intro to Programming", 2.66, department);

        course.addAssignment("Exam01", 50);
        course.addAssignment("Exam02", 50);

        boolean expected = true;
        boolean actual = course.isAssignmentWeightValid();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("assignment weight total = 101 -> false")
    void testIsAssignmentWeightValid2() {
        Department department = new Department("Computer Science");
        Course course = new Course("Intro to Programming", 2.66, department);

        course.addAssignment("Exam01", 50);
        course.addAssignment("Exam02", 51);

        boolean expected = false;
        boolean actual = course.isAssignmentWeightValid();

        Assertions.assertEquals(expected, actual);
    }
}
