package com.gameofthrones.ironbank.services;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Evgeny Borisov
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanRequest {
    private String personName;
    private String filialName;
    private long amount;

}
