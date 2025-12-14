package org.lucy;

public class Main {
    public static void main(String[] args) {
        Address address = new Address(1, "Rue", "Montreal", Address.Province.QC, "X1X2X3");
        Department department = new Department("Computer Science");
        Student student1 = new Student("Luciana Merchan", Student.Gender.FEMALE, address, department);
        Student student2 = new Student("Juan Garcia", Student.Gender.MALE, address, department);
        Student student3 = new Student("Valentina Vera", Student.Gender.FEMALE, address, department);
        Course course = new Course("Intro to Programming", 2.66, department);

        course.registerStudent(student1);
        course.registerStudent(student3);
        course.registerStudent(student2);

        course.addAssignment("Lab01", 20);
        course.addAssignment("Lab02", 20);
        course.addAssignment("Exam01", 30);
        course.addAssignment("Exam02", 30);
        course.generateScores();

        course.displayScores();
    }
}
