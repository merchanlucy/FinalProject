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
     * calculates average of assignments and ignore null scores
     * @return the average of assignments
     */
    public double calcAssignmentAverage() {
        double sum = 0;
        int count = 0;

        for (Integer score : scores) {
            if (score != null) {
                sum += score;
                count++;
            }
        }

        return count == 0 ? 0 : Math.round(sum / count);
    }


    /**
     * generates random scores for students in an assignment from 0, 100
     */
    public void generateRandomScore() {
        Random random = new Random();
        int num = random.nextInt(0, 11);
        int score;

        switch (num) {
            case 1, 2 -> score = random.nextInt(60, 70);
            case 3, 4 -> score = random.nextInt(70, 80);
            case 5, 6, 7, 8 -> score = random.nextInt(80, 90);
            case 9, 10 -> score = random.nextInt(90, 101);
            default -> score = random.nextInt(0,60);
            }

        int idx = scores.indexOf(null);
        if (idx >= 0) {
            scores.set(idx, score);
        } else {
            scores.add(score);
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
