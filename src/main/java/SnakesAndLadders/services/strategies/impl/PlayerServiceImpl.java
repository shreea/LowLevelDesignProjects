package SnakesAndLadders.services.strategies.impl;

import SnakesAndLadders.models.Board;
import SnakesAndLadders.models.Cell;
import SnakesAndLadders.models.Player;
import SnakesAndLadders.services.PlayerService;

public class PlayerServiceImpl implements PlayerService {

    @Override
    public Cell getNextPosition(Board board, Player player, int jumps) {
        Cell currentCell = player.getPiece().getCurrentCell();
        int nextPosition = currentCell.getPosition() + jumps;
        if(nextPosition > board.getCells().size()) {
            return currentCell;
        }
        Cell nextCell = board.getCells().get(nextPosition);
        Cell futureCell = board.getCells().get(nextCell.getTo());
        while(futureCell != nextCell) {
            nextCell = futureCell;
            futureCell = board.getCells().get(nextCell.getTo());
        }
        return nextCell;
    }

    public void setNextPosition(Player player, Cell nextCell) {
        player.getPiece().setCurrentCell(nextCell);
    }
}
