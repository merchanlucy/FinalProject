package org.lucy;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
@Getter
@Setter
public class Course {
    private String courseId;
    private String courseName;
    private double credits;
    private Department department;
    private List<Assignment> assignments;
    private List<Student> registeredStudents;
    private static int nextId = 1;
    private List<Integer> finalScores;

    public Course(String courseName, double credits, Department department) {
        this.courseId = String.format("C-%s-%02d", department.getDepartmentId(), nextId++);
        this.courseName = courseName;
        this.credits = credits;
        this.department = department;
        this.assignments = new ArrayList<>();
        this.registeredStudents = new ArrayList<>();
        this.finalScores = new ArrayList<>();
    }

    /**
     * checks if the sum of the weights of all assignments of that course equals to 100%
     * @return true if assignment weight is valid, false if not the total is over %100.
     */
    public boolean isAssignmentWeightValid() {
        double sum = 0;

        for (Assignment assignment : assignments) {
            sum += assignment.getWeight();
        }

        return !(sum > 100);
    }

    /**
     * calculates student average with assignment weight
     * @return the students average
     */
    public int[] calcStudentAverage() {
        int[] studentsAvg = new int[registeredStudents.size()];

        for (int i = 0; i < registeredStudents.size(); i++) {
            double sum = 0;

            for (Assignment assignment : assignments) {
                Integer score = assignment.getScores().get(i);
                if (score != null) {
                    sum += score * assignment.getWeight();
                }
            }

            studentsAvg[i] = (int) Math.round(sum / 100);
        }

        return studentsAvg;
    }

    /**
     * register student to a course
     * append null to all assignments in course
     * add a null final score
     * @param student registered student
     * @return true if student registers, false if student already registered
     */
    public boolean registerStudent(Student student) {
        if (student == null || registeredStudents.contains(student)) {
            return false;
        }

        registeredStudents.add(student);
        for (Assignment assignment : assignments) {
            assignment.getScores().add(null);
        }

        finalScores.add(null);
        return true;
    }

    /**
     * adds an assignment to course
     * @param assignmentName input assignment name
     * @param assigmentWeight input assignment weight
     * @return always true
     */
    public boolean addAssignment(String assignmentName, double assigmentWeight) {
        Assignment assignment = new Assignment(assignmentName, assigmentWeight);
        this.assignments.add(assignment);

        return true;
    }

    /**
     * generates random scores for each assignment and student, calculates the final score for each student
     */
    public void generateScores() {
        for (Assignment assignment : assignments) {
            for (int i = 0; i < registeredStudents.size(); i++) {
                assignment.generateRandomScore();
            }
        }

        for (int i = 0; i < registeredStudents.size(); i++) {
            double weightSum = 0;

            for (Assignment a : assignments) {
                Integer score = a.getScores().get(i);
                if (score != null) {
                    weightSum += score * a.getWeight();
                }
            }

            int finalScore = (int) Math.round(weightSum / 100);
            finalScores.set(i, finalScore);
        }
    }

    /**
     * display the scores of a course in a table, with the assignment averages and student weighted average
     */
    public void displayScores() {
        System.out.printf("Course: %s(%s)\n", getCourseName(), getCourseId());
        int[] finalAvg = calcStudentAverage();

        System.out.printf("%-20s", "");
        for (Assignment assignment : assignments) {
            System.out.printf("%15s", assignment.getAssignmentName());
        }

        System.out.printf("%15s\n", "Final Score");
        System.out.println();

        for (int i = 0; i < registeredStudents.size(); i++) {
            Student student = registeredStudents.get(i);
            System.out.printf("%-20s", student.getStudentName());

            for (Assignment assignment : assignments) {
                Integer score = assignment.getScores().get(i);
                System.out.printf("%15s", score);
            }

            System.out.printf("%15d\n", finalAvg[i]);
        }

        System.out.printf("%-20s", "Average");
        for (Assignment assignment : assignments) {
            double avg = assignment.calcAssignmentAverage();
            System.out.printf("%15.0f", avg);
        }

        System.out.println();
    }

    /**
     * simplified string to prevent infinity loop
     * @return string with course id, coursename, credits and department
     */
    public String toSimplifiedString() {
        return "Course{" +
                "courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", credits=" + credits +
                ", department=" + department +
                '}';
    }

    @Override
    public String toString() {
        String students = "{";

        for (Student student : registeredStudents) {
            students += student.toSimplifiedString() + "\n";
        }
        students += "}";

        String assignmentWeight = isAssignmentWeightValid() ? "Yes" : "No";

        String str = "Course{" +
                "courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", credits=" + credits +
                ", department=" + department +
                ", assignments=" + assignments +
                ", isAssignmentWeightValid=" + assignmentWeight +
                ", registeredStudents=" + students +
                '}';

        return str;
    }
}
