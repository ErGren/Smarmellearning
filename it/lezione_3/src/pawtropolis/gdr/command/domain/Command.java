package pawtropolis.gdr.command.domain;

import pawtropolis.gdr.exception.CommandExecutionException;
import pawtropolis.gdr.game.GameController;

public abstract class Command {
	protected final GameController gameController;

	protected Command(GameController gameController) {
		this.gameController = gameController;
	}

	public final void run() {
		try {
			execute();
		} catch (CommandExecutionException e) {
			System.out.println(e.getMessage());
		}
	}

	protected abstract void execute() throws CommandExecutionException;

	public abstract String getTriggerName();
}
