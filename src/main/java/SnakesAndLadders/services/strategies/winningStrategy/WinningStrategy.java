package SnakesAndLadders.services.strategies.winningStrategy;

import SnakesAndLadders.models.Board;
import SnakesAndLadders.models.Cell;
import SnakesAndLadders.models.Player;

public interface WinningStrategy {
    Boolean hasWon(int position, int boardSize);
}
