package com.gameofthrones.ironbank.services;

/**
 * @author Evgeny Borisov
 */
public interface LoanService {


    Answer loan(LoanRequest loanRequest);
}
