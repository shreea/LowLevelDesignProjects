package SnakesAndLadders.models;

import SnakesAndLadders.models.enums.JumpItemType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cell {
    int position;
    int to;
    JumpItemType cellType;

    public Cell(int position) {
        this.position = position;
        this.to = position;
        this.cellType = JumpItemType.NORMAL;
    }
}
