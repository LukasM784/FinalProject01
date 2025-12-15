package org.LukasM;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Random;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Assignment {
    private String assignmentId;
    private String assignmentName;
    private double weight;
    private ArrayList<Integer> scores;
    public static int nextId = 1;
    public int calcAssignmentAvg() {
        int sum = 0;
        for (int i = 0; i < scores.size(); i++) {
             sum += scores.get(i);
        }
        return sum / scores.size();
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
                ", assignmentId='" + String.format("%02d",nextId ++) + '\'' +
                '}';
    }
}
