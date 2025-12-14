package org.lucy;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import util.Util;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
@Getter
public class Student {
    private String studentId;
    private String studentName;
    @Setter private Gender gender;
    @Setter private Address address;
    @Setter private Department department;
    @Setter List<Course> registeredCourses;
    private static int nextId = 1;

    public Student(String studentName, Gender gender, Address address, Department department) {
        this.studentId = generateNewId();
        this.studentName = Util.toTitleCase(studentName);
        this.gender = gender;
        this.address = address;
        this.department = department;
        this.registeredCourses = new ArrayList<>();
    }

    /**
     * add 1 course to student's registeredCourses
     * adds the student to the course's registeredStudents
     * appends null for the scores of each assignment
     * @param course course to be registered
     * @return true after registering course, false if course is already registered
     */
    public boolean registerCourse(Course course) {
        if (course == null || registeredCourses.contains(course)) {
            return false;
        }

        registeredCourses.add(course);
        course.registerStudent(this);
        course.getAssignments().add(null);

        return true;
    }

    /**
     * remove a course from the student's list of registered courses
     * @param course course to be removed
     * @return true if course was removed,
     */
    public boolean dropCourse(Course course) {
        if (course == null || !registeredCourses.contains(course)) {
            return false;
        }

        registeredCourses.remove(course);
        course.getRegisteredStudents().remove(this);

        return true;
    }

    public void setStudentName(String studentName) {
        this.studentName = Util.toTitleCase(studentName);
    }

    /**
     * generate a new id for student
     * @return the new id
     */
    private static String generateNewId() {
        return String.format("s%06d", nextId++);
    }

    public enum Gender {
        FEMALE, MALE
    }

    /**
     * simplified to string to prevent infinity loop
     * @return simplified string
     */
    public String toSimplifiedString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", department=" + department +
                '}';
    }

    @Override
    public String toString() {
        String courses = "{";

        for (Course course : registeredCourses) {
            courses += course.toSimplifiedString() + "\n";
        }
        courses += "}";

        String str = "Student{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", gender=" + gender +
                ", address=" + address +
                ", department=" + department +
                ", registeredCourses=" + courses +
                '}';

        return str;
    }
}
