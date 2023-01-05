package SnakesAndLadders;

import SnakesAndLadders.models.*;
import SnakesAndLadders.models.enums.GameEndStrategyType;
import SnakesAndLadders.models.enums.PieceColor;
import SnakesAndLadders.services.DiceService;
import SnakesAndLadders.services.GameService;
import SnakesAndLadders.services.PlayerService;
import SnakesAndLadders.services.factories.GameEndFactory;
import SnakesAndLadders.services.strategies.gameEndStrategy.OnlyOnePlayerLeftGameEndStrategy;
import SnakesAndLadders.services.strategies.impl.DiceServiceImpl;
import SnakesAndLadders.services.strategies.impl.GameServiceImpl;
import SnakesAndLadders.services.strategies.impl.PlayerServiceImpl;
import SnakesAndLadders.services.strategies.winningStrategy.NextPositionMoreThanCurrentWinningStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.util.*;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class SnakesAndLaddersApplication implements CommandLineRunner {

	private static Logger LOG = LoggerFactory.getLogger(SnakesAndLaddersApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SnakesAndLaddersApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		GameEndFactory gameEndFactory = new GameEndFactory();
		Scanner input = new Scanner(System.in);
		while(true) {
			LOG.info("Enter the mode of input: \n1.Random \n 2.Human Input: ");
			int mode = input.nextInt();
			if(mode == 'a') {

			} else {
				LOG.info("Enter number of cells:");
				Board board = new Board(input.nextInt());
				LOG.info("Enter the number of players:");
				int noOfPlayers = input.nextInt();
				Piece orangePiece = new Piece(PieceColor.ORANGE, board.getCells().get(0));
				Piece whitePiece = new Piece(PieceColor.WHITE, board.getCells().get(0));
				Player orangePlayer = new Player("OrangePlayer", orangePiece);
				Player whitePlayer = new Player("WhitePlayer", whitePiece);
				Queue<Player> playerList = new LinkedList<>();
				playerList.add(orangePlayer);
				playerList.add(whitePlayer);
				LOG.info("Enter number of dice: ");
				int numberOfDice = input.nextInt();
				List<Dice> diceList = new ArrayList<>();
				for(int i = 0; i < numberOfDice; ++i) {
					LOG.info("Enter number of faces for dice: " + i + 1);
					Dice dice = new Dice(input.nextInt());
					diceList.add(dice);
				}
				LOG.info("Enter number of snakes: ");

				int numberOfSnakes = input.nextInt();
				int i = 0;
				while(i < numberOfSnakes) {
					LOG.info("enter from cell: ");
					int from = input.nextInt();
					LOG.info("enter to cell: ");
					int to = input.nextInt();
					if(from <= to) {
						LOG.error("Invalid input as from should be greater than to. Please enter again");
					} else {
						board.getCells().get(from - 1).setTo(to - 1);
						i++;
					}
				}
				LOG.info("Enter number of ladders: ");
				int numberOfLadders = input.nextInt();
				i = 0;
				while(i < numberOfLadders) {
					LOG.info("enter from cell: ");
					int from = input.nextInt();
					LOG.info("enter to cell: ");
					int to = input.nextInt();
					if(from >= to) {
						LOG.error("Invalid input as to should be greater than from");
					} else {
						board.getCells().get(from - 1).setTo(to - 1);
						i++;
					}
				}
				Game game = Game.Builder()
						.setBoard(board)
						.setPlayers(playerList)
						.setDices(diceList)
						.setGameEndStrategy(gameEndFactory.getGameEndStrategy(GameEndStrategyType.ONLY_ONE_PLAYER_LEFT))
						.setWinningStrategy(new NextPositionMoreThanCurrentWinningStrategy())
						.build();
				LOG.info("Game has been successfully created!!!!");
				LOG.info("Starting game:");
				GameService gameService = new GameServiceImpl(game);
				gameService.startGame();
			}
		}
	}
}
