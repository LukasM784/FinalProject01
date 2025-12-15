package org.LukasM;

import lombok.*;

import java.util.ArrayList;
@NoArgsConstructor
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

    /**
     * Checks to see if the weight of all the assignments is valid
     * @return if the weight is valid or not
     */
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

    /**
     * Registers students to a course
     * @param student the student being registered
     * @return if it was able to register the student or not
     */
    public boolean registerStudent(Student student) {
        if (student.registerCourse(this)) {
            registeredStudents.add(null);
            return true;
        }
        return false;
    }

    /**
     * Calculates the student average
     * @return the final average for all the students
     */
    public int[] calcStudentsAverage() {
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

    /**
     * Adds assignment to the course
     * @param assignmentName Name of the assignment
     * @param weight of the assignment
     * @param maxScore of the assignment
     * @return if it was able to add an assignment or not
     */
    public boolean addAssignment(String assignmentName, double weight, int maxScore) {
        String assignmentId = String.format("%02d", Assignment.nextId++);
        Assignment newAssignment = new Assignment(assignmentId, assignmentName,weight,new ArrayList<>());
        for (int i = 0; i< registeredStudents.size(); i++) {
            newAssignment.getScores().add(null);
        }
        assignments.add(newAssignment);
        return true;
    }

    /**
     * Generates the scores for the all the assignment and all the students
     */
    public void generateScores() {
        for (int i = 0; i < registeredStudents.size();i ++) {
            for (Assignment j : assignments) {
                j.generateRandomScore();
            }
        }
        calcStudentsAverage();
    }

    /**
     * This Displays the score in a table
     */
    public void displayScores() {
        generateScores();
        int[] finalAverages = calcStudentsAverage();
        System.out.printf("Course: %s(%s)",courseName,String.format("C-%s-%01d",department.getDepartmentId(),nextId++));
        System.out.printf("%-25s","");
        for (Assignment assignment : assignments) {
            System.out.printf("%-15s",assignment.getAssignmentName());
        }
        System.out.printf("%-15s","Final Score");
        for (int i = 0; i < registeredStudents.size(); i++) {
            Student s = registeredStudents.get(i);
            System.out.printf("%-25s",s.getStudentName());

            for (Assignment a : assignments) {
                Integer score = a.getScores().get(i);
                System.out.printf("%-15d",score);
            }
            System.out.printf("%-15d",finalAverages[i]);
        }
        System.out.print("Average");
        for (Assignment a : assignments) {
            System.out.printf("%-15s",a.calcAssignmentAvg() );
        }
    }

    public String toSimplifiedString() {
        return "Course{" +
                "department=" + department +
                ", courseName='" + courseName + '\'' +
                ", courseId='" + String.format("C-%s-%01d", department.getDepartmentId(), nextId++) + '\'' +
                '}';
    }

    public String toString() {
        Student s = new Student();
        return "Course{" +
                "courseId='" + String.format("C-%s-%01d", department.getDepartmentId(), nextId++) + '\'' +
                ", courseName='" + courseName + '\'' +
                ", credits=" + credits +
                ", assignments=" + assignments +
                ", weight of the assignments is valid =" + isAssignmentWeightValid() +
                s.toSimplifiedString() +
                '}';
    }
}
