package pawtropolis.gdr.game;

import pawtropolis.gdr.command.CommandFactory;
import pawtropolis.gdr.command.domain.Command;
import pawtropolis.gdr.game.console.InputController;
import pawtropolis.gdr.map.MapController;
import pawtropolis.gdr.map.model.Direction;
import pawtropolis.gdr.player.domain.Player;
import pawtropolis.gdr.map.model.Room;

public class GameController {
	private static final int DEFAULT_STARTING_LIFE_POINTS = 8000;
	private static GameController instance;

	private final MapController mapController;
	private Player player;

	private boolean playerQuit;

	private GameController() {
		this.mapController = new MapController();
		this.playerQuit = false;
	}

	public static GameController getInstance() {
		if (instance == null) {
			instance = new GameController();
		}
		return instance;
	}

	public boolean changeRoom(Direction direction) {
		return mapController.changeRoom(direction);
	}

	public Room getCurrentRoom() {
		return mapController.getCurrentRoom();
	}

	public Player getPlayer() {
		return player;
	}

	public void quitGame() {
		playerQuit = true;
	}

	public void runGame() {
		CommandFactory commandFactory = CommandFactory.getInstance();

		System.out.println("Welcome to Pawtropolis OwO\n");
		String playerName = InputController.readStringWithPrompt("Insert player's name: ");
		player = new Player(playerName, DEFAULT_STARTING_LIFE_POINTS);

		while(!playerQuit && player.isAlive()) {
			System.out.print("\n");
			String input;
			input = InputController.readStringWithPrompt(">");
			Command command = commandFactory.makeCommandFromString(input);
			command.run();
		}
	}
}
