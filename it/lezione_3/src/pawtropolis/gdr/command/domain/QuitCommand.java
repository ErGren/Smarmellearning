package pawtropolis.gdr.command.domain;

import pawtropolis.gdr.game.GameController;

public class QuitCommand extends Command {
	public QuitCommand(GameController gameController) {
		super(gameController);
	}

	@Override
	protected void execute() {
		gameController.quitGame();
	}

	@Override
	public String getTriggerName() {
		return "quit";
	}
}
