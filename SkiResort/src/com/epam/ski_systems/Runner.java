package com.epam.ski_systems;

import com.epam.ski_cards.DaysCard;
import com.epam.ski_cards.enums.CardType;
import java.util.ArrayList;
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
        int i = 0;
        int j = 0;
        LinkedList l = new LinkedList();
        Random rand = new Random();

        Calendar c1 = new GregorianCalendar();
        System.out.println(c1.getTime());
        System.out.println(c.getTime().toString().
                startsWith(new GregorianCalendar().
                        getTime().toString().substring(0, 10)));

        System.out.println(new GregorianCalendar().
                getTime().toString().substring(0, 10));

        System.out.println(c.getTime().toString().
                endsWith(new GregorianCalendar().
                        getTime().toString().substring(24)));

        System.out.println(new GregorianCalendar().
                getTime().toString().substring(11, 19));
        String time = new GregorianCalendar().
                getTime().toString().substring(11, 19);
        Integer hours = new Integer(time.substring(0, 2));
        Integer minutes = new Integer(time.substring(3, 5));

        if (minutes > 0) {
            hours++;
        }

        System.out.println(hours + " " + minutes);
        Calendar c2 = new GregorianCalendar();
        Calendar c3 = (Calendar) c2.clone();
        System.out.println(c2.getTime());
        c3.add(Calendar.DAY_OF_WEEK, 5);
        System.out.println("c3 " + c3.getTime());
        System.out.println("c2 " + c2.getTime());
        System.out.println(c2.compareTo(c3));
        Calendar c4 = new GregorianCalendar();
        c4.add(Calendar.DAY_OF_WEEK, 5);
        System.out.println(c3.compareTo(c4));
        ArrayList a = new ArrayList();
        Object o = a.toArray();
        if (o == null) {
            System.out.println("null");
        }
        System.out.println(new Object().equals(new Object()));

        ArrayList a1 = new ArrayList();
        ArrayList a2 = new ArrayList();
        for (int m = 0; m < 10; m++) {
            a1.add(m);
            a2.add(m);
        }
        a2.set(0, 9);
        a2.set(9, 0);
        System.out.println("ArrayEquals");
       
    }
}
