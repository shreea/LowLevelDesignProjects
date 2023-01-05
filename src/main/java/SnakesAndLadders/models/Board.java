package SnakesAndLadders.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
public class Board {
    List<Cell> cells;

    public Board (int n) {
        this.cells = new ArrayList<>();
        for(int i = 0; i < n * n; ++i) {
            cells.add(new Cell(i));
        }
    }
}
