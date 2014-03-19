package com.epam.exceptions;

/**
 *
 * @author Anatolii_Hlazkov
 */
public class WrongCardTypeException extends RuntimeException {

    private String message;

    public WrongCardTypeException() {
        super();
        message = "You send wrong card type";
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
