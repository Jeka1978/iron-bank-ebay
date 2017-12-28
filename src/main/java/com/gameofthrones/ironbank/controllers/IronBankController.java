package com.gameofthrones.ironbank.controllers;

import com.gameofthrones.ironbank.services.Answer;
import com.gameofthrones.ironbank.services.LoanRequest;
import com.gameofthrones.ironbank.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Evgeny Borisov
 */
@RestController
@RequestMapping("/api")
public class IronBankController {
    @Autowired
    private LoanService loanService;

    //endpoint = /api/ping
    @GetMapping("/ping")
    public String ping(){
        return "winter is coming...";
    }

    @GetMapping("/loan/{name}")
    public Answer loanFromDorn100(@PathVariable String name) {
        return loanService.loan(LoanRequest.builder().filialName("dorn").amount(100).personName(name).build());
    }
}








