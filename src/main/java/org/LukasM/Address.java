package org.LukasM;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Getter
@Setter
public class Address {
    private int streetNo;
    private String street;
    private String city;
    private Province province;
    private String postalCode;

    public static boolean isPostalCodeValid(String postalCode) {
        if (postalCode.length() != 6) {
            return false;
        }
        char[] postalCode1 = postalCode.toCharArray();
        for (int i = 0; i < postalCode1.length; i++) {
            if (i % 2 == 0 && !Character.isLetter(postalCode1[i])){
                return false;
            }
            if (i % 2 == 1 && !Character.isDigit(postalCode1[i])) {
                return false;
            }
        }
        return true;
    }

    public enum Province {
        AB, BC, MB, NB, NL, NS, ON, PE, QC, SK

    }
}
