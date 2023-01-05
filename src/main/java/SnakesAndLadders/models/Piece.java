package SnakesAndLadders.models;

import SnakesAndLadders.models.enums.PieceColor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Piece {
    private PieceColor pieceColor;
    private Cell currentCell;
}
