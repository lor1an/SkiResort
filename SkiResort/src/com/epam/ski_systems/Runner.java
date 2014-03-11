package com.epam.ski_systems;

import com.epam.ski_cards.DaysCard;
import com.epam.ski_cards.enums.CardType;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author Anatolii_Hlazkov
 */
public class Runner {

    public static void main(String[] args) {
        int id = 1;
        String str = CardType.DAY.toString() + " card, id = " + id
                + ".\nWas blocked.";
        System.out.println(str);
        Date d = new Date();
        Calendar c = new GregorianCalendar();
        System.out.println(c);
        System.out.println(c.getTime());
        System.out.println(c.getTimeInMillis());
        int i = 0;
        int j = 0;
        LinkedList l = new LinkedList();
        Random rand = new Random();
        while (i < 10000) {
            while (j < 1000) {
                l.add(rand.nextInt(1000));
                j++;
            }
            j = 0;
            i++;
        }
        Calendar c1 = new GregorianCalendar();
        System.out.println(c1.getTimeInMillis());
        Date d1 = c1.getTime();
        d1.ge
        
    }
}
