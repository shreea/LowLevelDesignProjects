package SnakesAndLadders.services.strategies.gameEndStrategy;

import SnakesAndLadders.models.Player;

import java.util.Queue;

public class OnePlayerWonGameEndStrategy implements GameEndStrategy{
    @Override
    public Boolean isGameEnd(int activePlayers, int totalPlayers) {
        return totalPlayers - activePlayers == 1;
    }
}
