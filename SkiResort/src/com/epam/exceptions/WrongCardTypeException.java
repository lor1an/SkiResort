/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
