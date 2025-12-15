import org.LukasM.*;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
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
        Course c = new Course(null, "Computer", 50, d, new ArrayList<>(), new ArrayList<>());
        Student s = new Student("Lukas",Gender.MALE, a, d);
        boolean expected = true;
        boolean actual = s.registerCourse(c);
        assertEquals(expected,actual);
    }

}
