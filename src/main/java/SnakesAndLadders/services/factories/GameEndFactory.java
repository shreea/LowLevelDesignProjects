package SnakesAndLadders.services.factories;

import SnakesAndLadders.models.enums.GameEndStrategyType;
import SnakesAndLadders.services.strategies.gameEndStrategy.GameEndStrategy;
import SnakesAndLadders.services.strategies.gameEndStrategy.OnePlayerWonGameEndStrategy;
import SnakesAndLadders.services.strategies.gameEndStrategy.OnlyOnePlayerLeftGameEndStrategy;

public class GameEndFactory {
    public GameEndStrategy getGameEndStrategy(GameEndStrategyType gameEndStrategyType){
        switch(gameEndStrategyType) {
            case ONLY_ONE_PLAYER_LEFT -> {
                return new OnlyOnePlayerLeftGameEndStrategy();
            }
            default -> {
                return new OnePlayerWonGameEndStrategy();
            }
        }
    }
}
