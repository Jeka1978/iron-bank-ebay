package com.gameofthrones.ironbank.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * @author Evgeny Borisov
 */
@Service
@Profile("WINTER_IS_HERE")
public class OnlyForSurePredictionService implements PredictionService {
    @Override
    public boolean prohibited(String name) {
        return !name.toLowerCase().contains("lanister");
    }
}
