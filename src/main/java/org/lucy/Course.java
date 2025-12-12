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

    public boolean registerStudent(Student student) {
        if (registeredStudents.contains(student)) {
            return false;
        }

        registeredStudents.add(student);
        for (Assignment assignment : assignments) {
            assignment.getScores().add(null);
        }

        finalScores.add(null);
        return true;
    }
}
