package com.gameofthrones.ironbank.services;

import com.gameofthrones.ironbank.dao.BankDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author Evgeny Borisov
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LoanServiceTest {
    @Autowired
    private LoanService loanService;

    @Autowired
    private BankDao bankDao;

    @Test
    public void loanWasSuccessfullyDelivered() throws Exception {
        LoanRequest loanRequest = LoanRequest.builder().personName("Therion Lanister").amount(10000).filialName("dorn").build();
        Answer answer = loanService.loan(loanRequest);
        Assert.assertEquals(answer.getStatus(),LoanStatus.OK);
        Assert.assertNotNull(answer.getMessage());
    }

    @Test(expected = NotEnoughMoneyException.class)
    public void loanWasNotSuccessfullyDeliveredBecauseLackOfMoney() throws Exception {
        LoanRequest loanRequest = LoanRequest.builder().personName("Therion Lanister").amount(1000000).filialName("dorn").build();
        Answer answer = loanService.loan(loanRequest);
        Assert.assertEquals(answer.getStatus(),LoanStatus.OK);
        Assert.assertNotNull(answer.getMessage());
    }

    @Test
    public void starksWillNotReceiveALoan() throws Exception {
        LoanRequest loanRequest = LoanRequest.builder().personName("Stark Nedd").amount(2).filialName("dorn").build();
        Answer answer = loanService.loan(loanRequest);
        Assert.assertEquals(answer.getStatus(),LoanStatus.FAIL);
        Assert.assertNotNull(answer.getMessage());
    }
    @Test
    public void bankBalanceDecreasing() throws Exception {
        long oldBalance = bankDao.findByName("dorn").getBalance();
        LoanRequest loanRequest = LoanRequest.builder().personName("No name").amount(2).filialName("dorn").build();
        Answer answer = loanService.loan(loanRequest);
        Assert.assertEquals(answer.getStatus(),LoanStatus.OK);
        long newBalance = bankDao.findByName("dorn").getBalance();
        Assert.assertEquals(2,oldBalance-newBalance);
    }









}