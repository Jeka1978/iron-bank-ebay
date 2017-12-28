package com.gameofthrones.ironbank.services;

import com.gameofthrones.ironbank.dao.BankDao;
import com.gameofthrones.ironbank.model.Bank;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.gameofthrones.ironbank.services.LoanStatus.FAIL;
import static com.gameofthrones.ironbank.services.LoanStatus.OK;

/**
 * @author Evgeny Borisov
 */
@Slf4j
@Service
public class LoanServiceImpl implements LoanService {
    @Autowired
    private BankDao bankDao;

    @Autowired
    private PredictionService predictionService;

    @Override
    public Answer loan(LoanRequest loanRequest) {
        Bank bank = bankDao.findByName(loanRequest.getFilialName());
        if (bank.getBalance() < loanRequest.getAmount()) {
            throw new NotEnoughMoneyException(bank.getName()+" don't have enough money");
        }
        if (predictionService.prohibited(loanRequest.getPersonName())) {
            return new Answer(FAIL, "you will not survive this winter. Rejected");
        }
        bank=bank.withBalance(bank.getBalance() - loanRequest.getAmount());
        bankDao.save(bank);
        log.info("remaining balance: "+bank.getBalance());
        return new Answer(OK,loanRequest.getPersonName()+" received "+ loanRequest.getAmount());
    }
}
