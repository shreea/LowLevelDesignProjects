package SnakesAndLadders.services.strategies.gameEndStrategy;

import SnakesAndLadders.models.Game;
import SnakesAndLadders.models.Player;

import java.util.Queue;

public interface GameEndStrategy {
    Boolean isGameEnd(int activePlayers, int totalPlayers);
}
