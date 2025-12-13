package org.LukasM;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Random;

@Getter
@Setter
public class Assignment {
    private String assignmentId;
    private String assignmentName;
    private double weight;
    private ArrayList<Integer> scores;
    private static int nextId = 1;

    public void calcAssignmentAvg() {
        int sum = 0;
        for (int i = 0; i < scores.size(); i++) {
            sum += scores.get(i);
        }
        int average = sum / scores.size();
    }

    public void generateRandomScore() {
        Random random = new Random(0);
        int num = random.nextInt(11);
        int score;
        switch (num) {
            case 0 -> score = random.nextInt(60);
            case 1,2 -> score = random.nextInt(60,70);
            case 3,4 -> score = random.nextInt(70,80);
            case 5,6,7,8 -> score = random.nextInt(80,90);
            case 9,10 -> score = random.nextInt(90,101);
            default -> score = 0;
        }
    }

    public String toString() {
        return "Assignment{" +
                "assignmentName='" + assignmentName + '\'' +
                ", weight=" + weight +
                ", assignmentId='" + assignmentId + '\'' +
                '}';
    }
}
