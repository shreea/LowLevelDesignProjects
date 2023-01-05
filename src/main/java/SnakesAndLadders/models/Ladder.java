package SnakesAndLadders.models;


import SnakesAndLadders.models.enums.JumpItemType;

public class Ladder extends JumpItem{

    private Ladder() {

    }
    private Ladder(int from, int to) {
        super(from, to, JumpItemType.SNAKE);
    }

    public static LadderBuilder getLadderBuilder () {
        return new LadderBuilder();
    }
    public static class LadderBuilder {
        Ladder ladder = new Ladder();

        public LadderBuilder from(int from) {
            ladder.from = from;
            return this;
        }

        public LadderBuilder to(int to) {
            ladder.to = to;
            return this;
        }

        public Ladder build() {
            if (ladder.from >= ladder.to) {
                throw new RuntimeException("from should be greater than to");
            }
            return new Ladder(ladder.from, ladder.to);
        }
    }
}