package pawtropolis.gdr.command;

import pawtropolis.gdr.command.domain.Command;
import pawtropolis.gdr.command.domain.ParametrizedCommand;
import pawtropolis.gdr.command.domain.UnknownCommand;
import pawtropolis.gdr.game.GameController;
import pawtropolis.gdr.util.ClassLoaderUtils;
import pawtropolis.gdr.util.domain.Pair;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CommandFactory {
	private static final String COMMANDS_PACKAGE = "pawtropolis.gdr.command.domain";
	private static CommandFactory instance;
	private final Map<String, Command> commands;

	private CommandFactory() {
		Set<Class<? extends Command>> commandsClasses = ClassLoaderUtils.findAllClassesInPackageBySuperType(COMMANDS_PACKAGE, Command.class);
		GameController gameController = GameController.getInstance();
		commands = commandsClasses.stream()
				.map(c -> ClassLoaderUtils.makeInstanceFromClass(c, gameController))
				.filter(Predicate.not(Objects::isNull))
				.collect(Collectors.toMap(Command::getTriggerName, Function.identity()));
	}

	public static CommandFactory getInstance() {
		if (instance == null) {
			instance = new CommandFactory();
		}
		return instance;
	}

	public Command makeCommandFromString(String s) {
		Pair<String, List<String>> commandData = parseForCommand(s);
		Command command = commands.get(commandData.getFirst());

		if (command == null) {
			return new UnknownCommand(GameController.getInstance());
		}

		if (command instanceof ParametrizedCommand) {
			((ParametrizedCommand) command).setParameters(commandData.getSecond());
		}
		return command;
	}

	private Pair<String, List<String>> parseForCommand(String s) {
		List<String> tokens = List.of(s.split(" "));
		String commandName = tokens.get(0);
		List<String> parameters = tokens.subList(1, tokens.size());
		return new Pair<>(commandName, parameters);
	}
}
