package pawtropolis.gdr.command.domain;

import pawtropolis.gdr.game.GameController;
import pawtropolis.gdr.player.domain.Item;
import pawtropolis.gdr.player.domain.Player;

import java.util.List;

public class DropCommand extends ParametrizedCommand {
	public DropCommand(GameController gameController) {
		super(gameController);
	}

	public DropCommand(GameController gameController, List<String> parameters) {
		super(gameController, parameters);
	}

	@Override
	protected void execute() {
		String itemName = String.join(" ", parameters);
		Player player = gameController.getPlayer();
		Item item = player.getItemFromBagByName(itemName);
		if (item == null) {
			System.out.println("Item not present in bag");
		} else {
			gameController.getPlayer().removeItemFromBag(item);
			gameController.getCurrentRoom().addItem(item);
		}
	}

	@Override
	public String getTriggerName() {
		return "drop";
	}
}
