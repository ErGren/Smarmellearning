package pawtropolis.simple.game;

import pawtropolis.simple.game.console.InputController;
import pawtropolis.simple.game.domain.Player;
import pawtropolis.simple.map.domain.Room;

public class GameController {

	private Room entry;
	private Player player;

	public GameController(Room entry, Player player) {
		this.entry = entry;
		this.player = player;
	}

	public void runGame() {
		Room currentRoom = entry;
		boolean gameEnded = false;

		while(!gameEnded) {
			String input;
			System.out.println("Where are you going to go?");
			System.out.print(">");
			input = InputController.readString();

			/*
			* Inserire qui la gestione degli altri comandi
			*/


			if (input.equals("exit")) {
				gameEnded = true;
			}
		}
	}
}
