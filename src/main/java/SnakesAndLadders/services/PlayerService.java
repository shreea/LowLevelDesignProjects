package SnakesAndLadders.services;

import SnakesAndLadders.models.Board;
import SnakesAndLadders.models.Cell;
import SnakesAndLadders.models.Player;

public interface PlayerService {

    Cell getNextPosition(Board board, Player player, int jumps);

    void setNextPosition(Player player, Cell nextCell);
}
