package org.lucy;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
@EqualsAndHashCode
public class Assignment {
    private String assignmentId;
    private String assignmentName;
    private double weight;
    private List<Integer> scores;
    private static int nextId = 1;

    public Assignment(String assignmentName, double weight) {
        this.assignmentId = String.format("%01d", nextId++);
        this.assignmentName = assignmentName;
        this.weight = weight;
        this.scores = new ArrayList<>();
    }

    /**
     * generates random scores for all students in an assignment from 0, 100
     */
    public void generateRandomScore() {
        Random random = new Random();
        int num = random.nextInt(0, 11);

        switch (num) {
            case 1, 2 -> scores.add(random.nextInt(60, 70));
            case 3, 4 -> scores.add(random.nextInt(70, 80));
            case 5, 6, 7, 8 -> scores.add(random.nextInt(80, 90));
            case 9, 10 -> scores.add(random.nextInt(90, 101));
            default -> scores.add(random.nextInt(0,60));
        }
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "assignmentId='" + assignmentId + '\'' +
                ", assignmentName='" + assignmentName + '\'' +
                ", weight=" + weight +
                '}';
    }
}
