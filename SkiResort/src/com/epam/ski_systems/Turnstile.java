package com.epam.ski_systems;

import com.epam.ski_cards.DaysCard;
import com.epam.ski_cards.LiftsCard;
import com.epam.ski_cards.SeasonCard;
import com.epam.ski_cards.SkiCard;
import static com.epam.ski_cards.enums.CardType.SEASON;
import static com.epam.ski_cards.enums.DayCounts.FIRST_HALF;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Anatolii_Hlazkov
 */
public class Turnstile {

    SkiControlingSystem sks = SkiControlingSystem.getInstance();

    public boolean passingTurnstile(SkiCard sc) {
        if (!sc.CARD_TYPE.equals(SEASON)) {
            if (sc.WEEKEND != sks.weekend) {
                String str = sks.weekend ? "weekend" : "workaday";
                System.out.println("You shall not pass.");
                sks.writeData(sc.CARD_TYPE.toString() + " card, id = " + sc.id
                        + ".\nCard has not pass. Reason: it is not " + str + ".");
                return false;
            }
        }
        if (check(sc)) {
            System.out.println("You may pass.");
            sks.writeData(sc.CARD_TYPE.toString() + " card, id = " + sc.id
                    + ".\nCard has pass.");
            return true;
        } else {
            return false;
        }
    }

    public boolean check(SkiCard sc) {
        if (!sc.isWorking()) {
            System.out.println("Your card was blocked.");
            sks.writeData(sc.CARD_TYPE.toString() + " card, id = " + sc.id
                    + ".\nCard has not pass. Reason: blocked.");
            return false;
        } else {
            switch (sc.CARD_TYPE) {
                case DAY:
                    DaysCard dc = (DaysCard) sc;
                    return check(dc);
                case LIFT:
                    LiftsCard lc = (LiftsCard) sc;
                    return check(lc);
                case SEASON:
                    SeasonCard sec = (SeasonCard) sc;
                    return check(sec);
                default:
                    return false;
            }
        }
    }

    private boolean check(DaysCard dc) {
        switch (dc.DC) {
            case FIRST_HALF:
            case SECOND_HALF:
                return checkHalfDayCards(dc);
            default:
                return checkFullDayCards(dc);
        }
    }

    private boolean checkHalfDayCards(DaysCard dc) {
        String currentDateInString = new GregorianCalendar().getTime().toString();
        String regDateInString = dc.REG_DATE.getTime().toString();
        if (regDateInString.startsWith(currentDateInString.substring(0, 10))
                && regDateInString.endsWith(currentDateInString.substring(24))) {
            String time = regDateInString.substring(11, 19);
            Integer hours = new Integer(time.substring(0, 2));
            Integer minutes = new Integer(time.substring(3, 5));
            if (minutes > 0) {
                hours++;
            }
            //Определение условия по которому нужно проверять карточку
            boolean flag;
            if (dc.DC.equals(FIRST_HALF)) {
                flag = hours >= 9 && hours <= 13;
            } else {
                flag = hours >= 13 && hours <= 17;
            }
            //Запись в ArrayList
            if (!flag) {
                writeOldCardDenialData(dc);
                return false;
            } else {
                return true;
            }
        } else {
            writeOldCardDenialData(dc);
            return false;
        }
    }

    private boolean checkFullDayCards(DaysCard dc) {
        Calendar endCardDate = (Calendar) dc.REG_DATE.clone();
        endCardDate.add(Calendar.DAY_OF_WEEK, dc.DC.getDays());
        if (endCardDate.compareTo(new GregorianCalendar()) >= 0) {
            return true;
        } else {
            writeOldCardDenialData(dc);
            return false;
        }
    }

    private void writeOldCardDenialData(SkiCard sc) {
        System.out.println("Old Card");
        sks.writeData(sc.CARD_TYPE.toString() + " card, id = " + sc.id
                + ".\nCard has not pass. Reason: Old card.");
    }

    private boolean check(LiftsCard lc) {
        if (lc.lc.getCounts() <= lc.getTrips()) {
            System.out.println("You shall not pass.");
            sks.writeData(lc.CARD_TYPE.toString() + " card, id = " + lc.id
                    + ".\nCard has not pass. Reason: over trips.");
            return false;
        } else {
            lc.setTrips(lc.getTrips() + 1);
            return true;
        }

    }

    private boolean check(SeasonCard sc) {
        if (sc.END_OF_THE_SEASON.compareTo(new GregorianCalendar()) >= 0) {
            return true;
        } else {
            writeOldCardDenialData(sc);
            return false;
        }
    }
}
