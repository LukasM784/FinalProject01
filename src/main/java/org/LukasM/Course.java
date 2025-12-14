package org.LukasM;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

import static org.LukasM.Assignment.*;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class Course {
    private String courseId;
    private String courseName;
    private double credits;
    private Department department;
    private ArrayList<Student> registeredStudents;
    private ArrayList<Assignment> assignments;
    private static int nextId = 1;

    public boolean isAssignmentWeightValid() {
        int sum = 0;
        for (Assignment a : assignments) {
            sum += a.getWeight();
        }
        if (sum != 100) {
            return false;
        }
        return true;
    }

    public boolean registerStudent(Student student) {
        if (student.registerCourse(this)) {
            registeredStudents.add(null);
            return true;
        }
        return false;
    }

    int[] calcStudentsAverage() {
        int[] finalAverage = new int[registeredStudents.size()];
        if (!isAssignmentWeightValid()) {
            return finalAverage;
        }

        for (int i = 0; i < registeredStudents.size(); i ++) {
            for (Assignment j : assignments) {
                if (j.getScores() != null) {
                    finalAverage[i] += (int) ((j.getScores().get(i) * j.getWeight()) / 100);
                }
            }
        }
        return finalAverage;
    }
}
