package com.gameofthrones.ironbank.services;

/**
 * @author Evgeny Borisov
 */
public class NotEnoughMoneyException extends IllegalStateException {
    public NotEnoughMoneyException(String s) {
        super(s);
    }
}
