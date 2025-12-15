import org.LukasM.*;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class FinalProjectTest {


    @Test
    @DisplayName("A1B1C -> False")
    public void isPostalCodeValidTest1() {
        String postalCode = "A1B1C";
        boolean expected = false;
        boolean actual = Address.isPostalCodeValid(postalCode);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("AB11C1 -> False")
    public void isPostalCodeValidTest2() {
        String postalCode = "AB11C1";
        boolean expected = false;
        boolean actual = Address.isPostalCodeValid(postalCode);
        assertEquals(expected, actual);

    }

    @Test
    @DisplayName("A1B1C1 -> True")
    public void isPostalCodeValidTest3() {
        String postalCode = "A1B1C1";
        boolean expected = true;
        boolean actual = Address.isPostalCodeValid(postalCode);
        assertEquals(expected, actual);

    }

    @Test
    @DisplayName("Computer Science1 -> False")
    public void isDepartmentNameValidTest1() {
        String departmentName = "Computer Science1";
        boolean expected = false;
        boolean actual = Department.isDepartmentNameValid(departmentName);
        assertEquals(expected, actual);

    }

    @Test
    @DisplayName("Register Course -> True")
    public void isRegisterCourseValidTest1() {
        Department d = new Department("Computer Science");
        Address a = new Address();
        Course c = new Course(null, "Computer", 5, d, new ArrayList<>(), new ArrayList<>());
        Student s = new Student("Lukas",Gender.MALE, a, d);
        boolean expected = true;
        boolean actual = s.registerCourse(c);
        assertEquals(expected,actual);
    }

    @Test
    @DisplayName("Register Course -> False")
    public void isRegisterCourseValidTest2() {
        Department d = new Department("Computer Science");
        Address a = new Address();
        Course c = new Course(null, "Computer", 5, d, new ArrayList<>(), new ArrayList<>());
        Student s = new Student("Lukas",Gender.MALE, a, d);
        s.registerCourse(c);
        boolean expected = false;
        boolean actual = s.registerCourse(c);
        assertEquals(expected,actual);
    }

    @Test
    @DisplayName("Drop Course -> True")
    public void isDropCourseValidTest1() {
        Department d = new Department("Computer Science");
        Address a = new Address();
        Course c = new Course(null, "Computer", 5, d, new ArrayList<>(), new ArrayList<>());
        Student s = new Student("Lukas",Gender.MALE, a, d);
        s.registerCourse(c);
        boolean expected = true;
        boolean actual = s.dropCourse(c);
        assertEquals(expected,actual);
    }

    @Test
    @DisplayName("Drop Course -> False")
    public void isDropCourseValidTest2() {
        Department d = new Department("Computer Science");
        Address a = new Address();
        Course c = new Course(null, "Computer", 5, d, new ArrayList<>(), new ArrayList<>());
        Student s = new Student("Lukas",Gender.MALE, a, d);
        boolean expected = false;
        boolean actual = s.dropCourse(c);
        assertEquals(expected,actual);
    }

    @Test
    @DisplayName("Assignment Weight -> True")
    public void isAssignmentWeightValidTest1() {
        Department d = new Department("Computer Science");
        Course c = new Course(null, "Computer", 50, d, new ArrayList<>(), new ArrayList<>());
        c.addAssignment("Assignment1", 50,100);
        c.addAssignment("Assignment1", 50,100);
        boolean expected = true;
        boolean actual = c.isAssignmentWeightValid();
        assertEquals(expected,actual);
    }

    @Test
    @DisplayName("Assignment Weight -> False")
    public void isAssignmentWeightValidTest2() {
        Department d = new Department("Computer Science");
        Course c = new Course(null, "Computer", 5, d, new ArrayList<>(), new ArrayList<>());
        c.addAssignment("Assignment1", 50,100);
        boolean expected = false;
        boolean actual = c.isAssignmentWeightValid();
        assertEquals(expected,actual);
    }

    @Test
    @DisplayName("Register Student -> True")
    public void isRegisterStudentValidTest1() {
        Department d = new Department("Computer Science");
        Address a = new Address();
        Course c = new Course(null, "Computer", 5, d, new ArrayList<>(), new ArrayList<>());
        Student s = new Student("Lukas",Gender.MALE, a, d);
        boolean expected = true;
        boolean actual = c.registerStudent(s);
        assertEquals(expected,actual);
    }

    @Test
    @DisplayName("Register Student -> False")
    public void isRegisterStudentValidTest2() {
        Department d = new Department("Computer Science");
        Address a = new Address();
        Course c = new Course(null, "Computer", 5, d, new ArrayList<>(), new ArrayList<>());
        Student s = new Student("Lukas",Gender.MALE, a, d);
        c.registerStudent(s);
        boolean expected = false;
        boolean actual = c.registerStudent(s);
        assertEquals(expected,actual);
    }

    @Test
    @DisplayName("Add Assignment -> True")
    public void isAddAssignmentValidTest1() {
        String assignmentName = "Computer Science";
        double weight = 50;
        int maxScore = 100;
        Department d = new Department("Computer Science");
        Course c = new Course(null, "Computer", 5, d, new ArrayList<>(), new ArrayList<>());
        boolean expected = true;
        boolean actual = c.addAssignment(assignmentName, weight, maxScore);
        assertEquals(expected,actual);
    }

    @Test
    @DisplayName("Register Student -> True")
    public void isCalcStudentAverageValidTest1() {
        Department d = new Department("Computer Science");
        Address a = new Address();
        Course c = new Course(null, "Computer", 5, d, new ArrayList<>(), new ArrayList<>());
        Student s = new Student("Lukas",Gender.MALE, a, d);
        Assignment a1 = new Assignment(null,"Assignment1", 50,new ArrayList<>());
        Assignment a2 = new Assignment(null,"Assignment1", 50,new ArrayList<>());
        s.registerCourse(c);
        c.getAssignments().add(a1);
        c.getAssignments().add(a2);

        a1.getScores().add(0,80);
        a2.getScores().add(0,70);

        int[] expected = {75};
        int[] actual = c.calcStudentsAverage();
        assertArrayEquals(expected,actual);
    }


}
