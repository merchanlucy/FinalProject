package org.lucy;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import util.Util;

@ToString
@EqualsAndHashCode
@Getter
public class Department {
    private String departmentId;
    private String departmentName;
    private static int nextId = 1;

    public Department(String departmentName) {
        if (isDepartmentNameValid(departmentName)) {
            this.departmentName = Util.toTitleCase(departmentName);
            this.departmentId = generateNewId();
        } else {
            this.departmentName = null;
            this.departmentId = null;
        }
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = isDepartmentNameValid(departmentName) ? Util.toTitleCase(departmentName) : null;
    }

    /**
     * generate new ID for department
     * @return the new ID for the department
     */
    private static String generateNewId() {
        return String.format("D%02d", nextId++);
    }

    /**
     * checks if a department name is valid
     * a valid department name only contains letters and spaces
     * @param departmentName input department name
     * @return true if department name is valid, false if department name is invalid.
     */
    public static boolean isDepartmentNameValid(String departmentName) {
        if (departmentName == null) {
            return false;
        }

        for (int i = 0; i < departmentName.length(); i++) {
            char c = departmentName.charAt(i);
            if (!Character.isLetter(c) && !Character.isSpaceChar(c)) {
                return false;
            }
        }

        return true;
    }
}
