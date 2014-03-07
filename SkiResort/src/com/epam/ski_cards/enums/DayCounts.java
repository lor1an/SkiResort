package com.epam.ski_cards.enums;

/**
 *
 * @author Anatolii_Hlazkov
 */
public enum DayCounts {

    FIRST_HALF, SECOND_HALF, ONE(1), TWO(2), FIVE(5);

    int days;

    DayCounts(){
        this(0);
    }
    
    DayCounts(int days) {
        this.days = days;

    }
}
