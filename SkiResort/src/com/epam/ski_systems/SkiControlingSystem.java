package com.epam.ski_systems;

import com.epam.my_arraylist.MyArrayList;
import com.epam.ski_cards.DaysCard;
import com.epam.ski_cards.LiftsCard;
import com.epam.ski_cards.SeasonCard;
import com.epam.ski_cards.SkiCard;
import com.epam.ski_cards.enums.CardType;
import com.epam.ski_cards.enums.DayCounts;
import com.epam.ski_cards.enums.LiftCounts;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Anatolii_Hlazkov
 */
public class SkiControlingSystem {

    private static SkiControlingSystem instance;
    public final ArrayList<String> log = new ArrayList();
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

    public ArrayList getLog() {
        return log;
    }

    public void printWholeLog() {
        for (String s : log) {
            System.out.println(s);
        }
    }

    public void printDaysCardLog() {
        for (String s : log) {
            if (s.startsWith("DAY")) {
                System.out.println(s);
            }
        }
    }

    public void printLiftsCardLog() {
        for (String s : log) {
            if (s.startsWith("LIFT")) {
                System.out.println(s);
            }
        }
    }

    public void printSeasonCardLog() {
        for (String s : log) {
            if (s.startsWith("SEASON")) {
                System.out.println(s);
            }
        }
    }

}
