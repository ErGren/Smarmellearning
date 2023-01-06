package pawtropolis.gdr.command.domain;

import pawtropolis.gdr.game.GameController;

public class LookCommand extends Command {
	public LookCommand(GameController gameController) {
		super(gameController);
	}

	@Override
	protected void execute() {
		System.out.println("You are in " + gameController.getCurrentRoom().getDescription());
	}

	@Override
	public String getTriggerName() {
		return "look";
	}
}
