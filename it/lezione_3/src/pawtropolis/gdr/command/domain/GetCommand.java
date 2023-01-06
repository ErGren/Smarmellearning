package pawtropolis.gdr.command.domain;

import pawtropolis.gdr.game.GameController;
import pawtropolis.gdr.player.domain.Item;
import pawtropolis.gdr.player.domain.Player;

import java.util.List;

public class GetCommand extends ParametrizedCommand {
	public GetCommand(GameController gameController) {
		super(gameController);
	}

	public GetCommand(GameController gameController, List<String> parameters) {
		super(gameController, parameters);
	}

	@Override
	protected void execute() {
		String itemName = String.join(" ", parameters);
		Item item = gameController.getCurrentRoom().getItemByName(itemName);
		if (item == null) {
			System.out.println("Item not present in current room");
		}
		else {
			Player player = gameController.getPlayer();
			if (player.checkItemFitsInBag(item)) {
				gameController.getPlayer().addItemToBag(item);
				gameController.getCurrentRoom().removeItem(item);
			} else {
				System.out.println("Not enough space in bag");
			}
		}
	}

	@Override
	public String getTriggerName() {
		return "get";
	}
}
