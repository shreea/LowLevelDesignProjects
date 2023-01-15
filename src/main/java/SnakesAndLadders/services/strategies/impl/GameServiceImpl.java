package SnakesAndLadders.services.strategies.impl;

import SnakesAndLadders.models.*;
import SnakesAndLadders.services.DiceService;
import SnakesAndLadders.services.GameService;
import SnakesAndLadders.services.PlayerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

public class GameServiceImpl implements GameService {
    @Autowired
    DiceService diceService;
    @Autowired
    PlayerService playerService;
    private Game game;
    public GameServiceImpl(Game game) {
        this.game = game;
    }
    public static Logger LOG = LoggerFactory.getLogger(GameServiceImpl.class);

    @Override
    public void startGame() {
        initiateJumpItems();
        while(!game.getGameEndStrategy().isGameEnd(game.getPlayers().size(), game.getTotalPlayers())) {
            Board board = game.getBoard();
            Player player = game.getPlayers().poll();
            int totalJumps = 0;
            for(int j = 0; j < game.getDices().size(); ++j) {
                totalJumps += diceService.roll(game.getDices().get(j));
            }
            Cell nextCell = playerService.getNextPosition(board, player, totalJumps);
            playerService.setNextPosition(player, nextCell);
            LOG.info("pLayer " + player.getUsername() + " moving to " + nextCell.getPosition());
            if(game.getWinningStrategy().hasWon(player.getPiece().getCurrentCell().getPosition(), game.getBOARD_SIZE())) {
                LOG.info("Player" + player.getUsername() + " has won");
                game.getLeaderBoard().add(player);
            } else {
                game.getPlayers().add(player);
            }
        }
        LOG.info("Game ended!!! Hope you enjoyed it!!");
    }

    private void initiateJumpItems() {
        var jumpItemMap = game.getJumpItemMap();
        var jumpItemSet = game.getJumpItemsSet();
        int i = 0;
        while(i < 10) {
            int from = new Random().nextInt(game.getBOARD_SIZE());
            int to = new Random().nextInt(game.getBOARD_SIZE());
            try {
                JumpItem jumpItem = Snake.getSnakeBuilder().from(from).to(to)
                        .build();
                if(!jumpItemMap.containsKey(from)) {
                    jumpItemMap.put(jumpItem.getFrom(), jumpItem);
                    i++;
                } else {
                    throw new RuntimeException("entry already exists");
                }
            } catch (Exception e) {
                LOG.error(e.getMessage());
            }
        }
        while(i < 10) {
            int from = new Random().nextInt(game.getBOARD_SIZE());
            int to = new Random().nextInt(game.getBOARD_SIZE());
            try {
                JumpItem jumpItem = Ladder.getLadderBuilder().from(from).to(to)
                        .build();
                if(!jumpItemMap.containsKey(from)) {
                    jumpItemMap.put(jumpItem.getFrom(), jumpItem);
                    i++;
                } else {
                    throw new RuntimeException("entry already exists");
                }
            } catch (Exception e) {
                LOG.error(e.getMessage());
            }
        }
    }
}
