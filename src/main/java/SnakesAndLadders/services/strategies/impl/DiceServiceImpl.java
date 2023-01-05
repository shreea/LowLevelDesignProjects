package SnakesAndLadders.services.strategies.impl;

import SnakesAndLadders.models.Dice;
import SnakesAndLadders.services.DiceService;

import java.util.Random;

public class DiceServiceImpl implements DiceService {
    @Override
    public int roll(Dice dice) {
        return new Random().nextInt(dice.getFaces()) + 1;
    }
}
