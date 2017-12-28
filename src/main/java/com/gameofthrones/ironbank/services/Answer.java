package com.gameofthrones.ironbank.services;

import lombok.*;

/**
 * @author Evgeny Borisov
 */
@Data
@AllArgsConstructor
public class Answer {
    private LoanStatus status;
    private String message;

}
