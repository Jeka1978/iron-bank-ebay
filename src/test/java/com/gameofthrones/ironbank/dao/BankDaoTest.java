package com.gameofthrones.ironbank.dao;

import com.gameofthrones.ironbank.model.Bank;
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
@SpringBootTest
@RunWith(SpringRunner.class)
public class BankDaoTest {
    @Autowired
    private BankDao bankDao;

    @Test
    public void findByName() throws Exception {
        Bank dorn = bankDao.findByName("dorn");
        Assert.assertEquals(100000,dorn.getBalance());
    }

}