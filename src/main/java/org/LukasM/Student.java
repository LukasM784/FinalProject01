package org.LukasM;

import java.util.ArrayList;

public class Student {
    private String studentId;
    private String studentName;
    private Gender gender;
    private Address address;
    private Department department;
    private ArrayList<Course> registeredCourses;
    private static int nextId = 1;



    public boolean registerCourse(Course course) {
        if (registeredCourses.contains(course)) {
            return false;
        }
        registeredCourses.add(course);
        course.getRegisteredStudents().add(this);

        ArrayList<Assignment> assignments = course.getAssignments();
        for (int i = 0; i < assignments.size(); i++) {
            Assignment assignment = assignments.get(i);
            assignment.getScores().add(null);
        }


        return true;
    }


}
