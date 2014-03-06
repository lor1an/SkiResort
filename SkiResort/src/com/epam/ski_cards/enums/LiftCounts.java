package com.epam.ski_cards.enums;

/**
 *
 * @author Anatolii_Hlazkov
 */
public enum LiftCounts {

    TEN(10), TWENTY(20), FIFTY(50), HUNDRED(100);

    int lcounts;

    LiftCounts(int lcounts) {
        this.lcounts = lcounts;
    }

    public int getCounts() {
        return lcounts;
    }

    public void setLCounts(int lcounts) {
        this.lcounts = lcounts;
    }
}
