package org.LukasM;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Getter
public class Department {
    private final String departmentId;
    private String departmentName;
    private static int nextId = 1;

    /**
     * Checks to see is the department name is valid
     * @param departmentName this is the department name that is being checked
     * @return true if the department name is valid and false it is invalid
     */
    public static boolean isDepartmentNameValid(String departmentName) {
        char[] departmentName1 = departmentName.toCharArray();
        for (int i = 0; i < departmentName.length(); i++) {
            if (!Character.isLetter(departmentName1[i]) && !Character.isSpaceChar(departmentName1[i])) {
                return false;
            }
        }
        return true;
    }

    public Department(String departmentName) {
        if (isDepartmentNameValid(departmentName)) {
            this.departmentName = departmentName;
            this.departmentId = String.format("D%02d", nextId++);
        }
        else {
            this.departmentName = null;
            this.departmentId = null;
        }
    }

    public void setDepartmentName(String departmentName) {
        if (isDepartmentNameValid(departmentName)) {
            this.departmentName = departmentName;
        }
    }
}