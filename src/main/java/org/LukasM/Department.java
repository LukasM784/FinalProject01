package org.LukasM;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Getter
public class Department {
    private String departmentId;
    @Setter private String departmentName;
    private static int nextId;

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
        }
        else {
            this.departmentName = null;
        }
    }
}