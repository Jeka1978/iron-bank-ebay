package com.gameofthrones.ironbank.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * @author Evgeny Borisov
 */
@Service
@Profile("WINTER_IS_COMING")
public class RegularPredictionService implements PredictionService {
    @Override
    public boolean prohibited(String name) {
        return name.toLowerCase().contains("stark");
    }
}
