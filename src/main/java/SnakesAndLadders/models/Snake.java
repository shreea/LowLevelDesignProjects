package SnakesAndLadders.models;

import SnakesAndLadders.models.enums.JumpItemType;
import lombok.Builder;

public class Snake extends JumpItem{
    private Snake() {

    }
    private Snake(int from, int to) {
        super(from, to, JumpItemType.SNAKE);
    }

    public static SnakeBuilder getSnakeBuilder () {
        return new SnakeBuilder();
    }
    public static class SnakeBuilder {
        Snake snake = new Snake();

        public SnakeBuilder from(int from) {
            snake.from = from;
            return this;
        }

        public SnakeBuilder to(int to) {
            snake.to = to;
            return this;
        }

        public Snake build() {
            if (snake.from >= snake.to) {
                throw new RuntimeException("from should be greater than to");
            }
            return new Snake(snake.from, snake.to);
        }
    }
}
