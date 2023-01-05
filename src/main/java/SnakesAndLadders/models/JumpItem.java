package SnakesAndLadders.models;

import SnakesAndLadders.models.enums.JumpItemType;
import lombok.Getter;

@Getter
public abstract class JumpItem {
    protected int from;
    protected int to;
    protected JumpItemType jumpItemType;

    protected JumpItem() {
    }

    protected JumpItem(int from, int to, JumpItemType jumpItemType) {
        this.from = from;
        this.to = to;
        this.jumpItemType = jumpItemType;
    }

}
