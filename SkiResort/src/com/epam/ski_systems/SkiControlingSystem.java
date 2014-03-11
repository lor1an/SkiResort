package com.epam.ski_systems;

import com.epam.my_arraylist.MyArrayList;
import com.epam.ski_cards.DaysCard;
import com.epam.ski_cards.LiftsCard;
import com.epam.ski_cards.SeasonCard;
import com.epam.ski_cards.SkiCard;
import com.epam.ski_cards.enums.CardType;
import com.epam.ski_cards.enums.DayCounts;
import com.epam.ski_cards.enums.LiftCounts;
import java.util.Calendar;

/**
 *
 * @author Anatolii_Hlazkov
 */
public class SkiControlingSystem {

    private static SkiControlingSystem instance;
    public final MyArrayList<String> log = new MyArrayList();
    private static int id;
    public boolean weekend;

    public static SkiControlingSystem getInstance() {
        if (instance == null) {
            instance = new SkiControlingSystem();
        }
        return instance;
    }

    public SkiCard makeCard(CardType ct, Calendar regDate, Boolean weekend, DayCounts dc) {
        if (!ct.equals(CardType.DAY)) {
            throw new NullPointerException();
        }
        return new DaysCard(id++, ct, regDate, weekend, dc);
    }

    public SkiCard makeCard(CardType ct, Calendar regDate, Boolean weekend, LiftCounts lc) {
        if (!ct.equals(CardType.LIFT)) {
            throw new NullPointerException();
        }
        return new LiftsCard(id++, ct, regDate, weekend, lc);
    }

    public SkiCard makeCard(CardType ct, Calendar regDate, Calendar endOfSeason) {
        if (!ct.equals(CardType.SEASON)) {
            throw new NullPointerException();
        }
        return new SeasonCard(id++, ct, regDate, endOfSeason);
    }

    public void writeData(String message) {
        log.add(message);
    }

    public void blockCard(SkiCard sk) {
        if (sk.isWorking()) {
            sk.set(false);
            System.out.println("Card was blocked.");
            writeData(sk.CARD_TYPE.toString() + " card, id = " + sk.id
                    + ".\nWas blocked.");
        } else {
            System.out.println("Card already blocking.");

        }
    }

    public MyArrayList getLog() {
        return log;
    }

    public void printWholeLog() {
        for (int i = 0; i < log.size(); i++) {
            System.out.println(log.get(i));
        }
    }

    public void printDaysCardLog() {
        for (int i = 0; i < log.size(); i++) {
            if (log.get(i).startsWith("DAYS")) {
                System.out.println(log.get(i));
            }
        }

    }

    public void printLiftsCardLog() {
        for (int i = 0; i < log.size(); i++) {
            if (log.get(i).startsWith("LIFTS")) {
                System.out.println(log.get(i));
            }
        }
    }

    public void printSeasonCardLog() {
        for (int i = 0; i < log.size(); i++) {
            if (log.get(i).startsWith("SEASON")) {
                System.out.println(log.get(i));
            }
        }
    }

}
