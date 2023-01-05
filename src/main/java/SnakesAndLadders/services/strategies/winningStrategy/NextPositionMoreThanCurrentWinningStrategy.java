package SnakesAndLadders.services.strategies.winningStrategy;

import SnakesAndLadders.models.Board;
import SnakesAndLadders.models.Cell;

public class NextPositionMoreThanCurrentWinningStrategy implements WinningStrategy{
    @Override
    public Boolean hasWon(int position, int boardSize) {
        return position == boardSize - 1;
    }
}
