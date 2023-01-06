package pawtropolis.gdr.command.domain;

import pawtropolis.gdr.game.GameController;

public class UnknownCommand extends Command {
	public UnknownCommand(GameController gameController) {
		super(gameController);
	}

	@Override
	protected void execute() {
		System.out.println("Unknown command");
	}

	@Override
	public String getTriggerName() {
		return null;
	}
}
