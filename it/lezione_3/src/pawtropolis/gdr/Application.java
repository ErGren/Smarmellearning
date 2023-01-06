package pawtropolis.gdr;

import pawtropolis.gdr.game.GameController;

public class Application {

	public static void main(String[] args) {
		GameController.getInstance().runGame();
	}
}
