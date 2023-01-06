package pawtropolis.gdr.command.domain;

import pawtropolis.gdr.exception.CommandExecutionException;
import pawtropolis.gdr.exception.MissingParameterException;
import pawtropolis.gdr.game.GameController;

import java.util.ArrayList;
import java.util.List;

public abstract class ParametrizedCommand extends Command {
	protected final List<String> parameters;

	protected ParametrizedCommand(GameController gameController) {
		super(gameController);
		this.parameters = new ArrayList<>();
	}

	protected ParametrizedCommand(GameController gameController, List<String> parameters) {
		this(gameController);
		if (parameters != null) {
			this.parameters.addAll(parameters);
		}
	}

	public List<String> getParameters() {
		return new ArrayList<>(parameters);
	}

	public void setParameters(List<String> parameters) {
		this.parameters.clear();
		this.parameters.addAll(parameters);
	}

	@Override
	protected void execute() throws CommandExecutionException {
		if (parameters == null || parameters.isEmpty()) {
			throw new MissingParameterException("Missing parameter");
		}
	}
}
