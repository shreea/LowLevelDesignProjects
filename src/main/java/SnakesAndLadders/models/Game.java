package SnakesAndLadders.models;
import SnakesAndLadders.exceptions.InvalidInputForCellsRangeException;
import SnakesAndLadders.exceptions.InvalidNumberOfDiceException;
import SnakesAndLadders.exceptions.InvalidNumberOfPlayersException;
import SnakesAndLadders.services.strategies.gameEndStrategy.GameEndStrategy;
import SnakesAndLadders.services.strategies.winningStrategy.WinningStrategy;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.util.Pair;
import org.springframework.util.CollectionUtils;

import java.security.InvalidParameterException;
import java.util.*;

@Getter
public class Game {
    private Board board;
    private Queue<Player> players;
    private List<Dice> dices;
    private final int MAX_BOARD_SIZE = 1000;
    private final int MAX_NUMBER_OF_PLAYERS = 10;
    private final int MAX_NUMBER_OF_DICE = 5;
    private int BOARD_SIZE;
    private int totalPlayers;
    private GameEndStrategy gameEndStrategy;
    private WinningStrategy winningStrategy;
    private Map<Integer, JumpItem> jumpItemMap;
    private Set<Pair<Integer, Integer>> jumpItemsSet;
    private Queue<Player>leaderBoard;

    public static GameBuilder Builder() {
        return new GameBuilder();
    }
    public static class GameBuilder {
        private Game game = new Game();

        public GameBuilder setBoard (Board board) throws InvalidInputForCellsRangeException {
            if(board.getCells().size() > game.MAX_BOARD_SIZE) {
                throw new InvalidInputForCellsRangeException("The limit for number of cells in board is invalid");
            }
            game.board = board;
            game.BOARD_SIZE = board.getCells().size();
            return this;
        }

        public GameBuilder setPlayers (Queue<Player> players) throws InvalidNumberOfPlayersException {
            if(players == null || players.size() > game.MAX_NUMBER_OF_PLAYERS) {
                throw new InvalidNumberOfPlayersException("The number of players passed surpasses the limit");
            }
            game.players = players;
            game.totalPlayers = players.size();
            return this;
        }

        public GameBuilder setDices(List<Dice> diceList) throws InvalidNumberOfDiceException {
            if(diceList.size() > game.MAX_NUMBER_OF_DICE) {
                throw new InvalidNumberOfDiceException("the number of dice passed in Invalid");
            }
            game.dices = diceList;
            return this;
        }

        public GameBuilder setGameEndStrategy(GameEndStrategy gameEndStrategy) {
            game.gameEndStrategy = gameEndStrategy;
            return this;
        }

        public GameBuilder setWinningStrategy(WinningStrategy winningStrategy) {
            game.winningStrategy = winningStrategy;
            return this;
        }

        public Game build() {
            if(game.board == null || CollectionUtils.isEmpty(game.players) || CollectionUtils.isEmpty(game.dices)) {
                throw new InvalidParameterException("Board or number of players or number of dices is invalid");
            }
            game.jumpItemMap = new HashMap<>();
            game.leaderBoard = new LinkedList<>();
            game.jumpItemsSet = new HashSet<>();
            return game;
        }

    }

}
