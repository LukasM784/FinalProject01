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

    /**
     * Checks to see if the postal code is valid
     * @param postalCode this is the postal code that is being checked
     * @return true is the code is valid and false if it's invalid
     */
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

    public Address(String street, String postalCode, Province province, String city, int streetNo) {
        if (isPostalCodeValid(postalCode)) {
            this.street = street;
            this.postalCode = postalCode;
            this.province = province;
            this.city = city;
            this.streetNo = streetNo;
        }
        else {
            this.street = null;
            this.postalCode = null;
            this.province = null;
            this.city = null;
            this.streetNo = 0;
        }
    }

    public void setPostalCode(String postalCode) {
        if (isPostalCodeValid(postalCode)) {
            this.postalCode = postalCode.toUpperCase();
        }
    }
}
