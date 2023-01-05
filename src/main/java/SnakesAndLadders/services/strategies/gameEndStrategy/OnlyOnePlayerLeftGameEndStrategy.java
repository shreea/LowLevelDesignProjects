package SnakesAndLadders.services.strategies.gameEndStrategy;

import SnakesAndLadders.models.Game;
import SnakesAndLadders.models.Player;

import java.util.Queue;

public class OnlyOnePlayerLeftGameEndStrategy implements GameEndStrategy{
    @Override
    public Boolean isGameEnd(int activePlayers, int totalPlayers) {
        return activePlayers == 1;
    }
}
