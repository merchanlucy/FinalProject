package org.lucy;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Getter
public class Address {
    @Setter private int streetNo;
    @Setter private String street;
    @Setter private String city;
    @Setter private Province province;
    private String postalCode;

    public Address(int streetNo, String street, String city, Province province, String postalCode) {
        if (isPostalCodeValid(postalCode)) {
            this.postalCode = postalCode.toUpperCase();
            this.streetNo = streetNo;
            this.street = street;
            this.city = city;
            this.province = province;
        } else {
            this.postalCode = null;
            this.streetNo = -1;
            this.street = null;
            this.city = null;
            this.province = null;
        }
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = isPostalCodeValid(postalCode) ? postalCode.toUpperCase() : null;
    }

    /**
     * check if a postal code is valid or not
     * a valid postal code has a length of 6 characters
     * and is in the format CDCDCD, where C is a character, while D is a digit, such as A1B2C3
     * @param postalCode the input postal code
     * @return true if the postal code is valid, false if it is not
     */
    public static boolean isPostalCodeValid(String postalCode) {
        if (postalCode == null || postalCode.length() != 6) {
            return false;
        }

        for (int i = 0; i < postalCode.length(); i++) {
            if (i % 2 == 0) {
                if (!Character.isLetter(postalCode.charAt(i))) {
                    return false;
                }
            } else {
                if (!Character.isDigit(postalCode.charAt(i))) {
                    return false;
                }
            }
        }

        return true;
    }

    public enum Province {
        AB,
        BC,
        MB,
        NB,
        NL,
        NS,
        ON,
        PE,
        QC,
        SK
    }
}
