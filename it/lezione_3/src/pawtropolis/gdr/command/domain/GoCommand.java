package pawtropolis.gdr.command.domain;

import pawtropolis.gdr.game.GameController;
import pawtropolis.gdr.map.model.Direction;

import java.util.List;

public class GoCommand extends ParametrizedCommand {
	public GoCommand(GameController gameController) {
		super(gameController);
	}

	public GoCommand(GameController gameController, List<String> parameters) {
		super(gameController, parameters);
	}

	@Override
	protected void execute() {
		Direction direction = Direction.of(String.join(" ", parameters));
		if (gameController.changeRoom(direction)) {
			System.out.println("You are in " + gameController.getCurrentRoom().getDescription());
		} else {
			System.out.println("You cannot go there");
		}
	}

	@Override
	public String getTriggerName() {
		return "go";
	}
}
