package pawtropolis.gdr.command.domain;

import pawtropolis.gdr.game.GameController;
import pawtropolis.gdr.player.domain.Item;
import pawtropolis.gdr.player.util.PlayerDomainUtils;

import java.util.List;

public class BagCommand extends Command {
	public BagCommand(GameController gameController) {
		super(gameController);
	}

	@Override
	protected void execute() {
		List<Item> items = gameController.getPlayer().getItemsInBag();
		String itemsDescription = items.isEmpty() ? "[]" : PlayerDomainUtils.getItemsListDescriptionString(items);
		System.out.println("In bag: " + itemsDescription);
	}

	@Override
	public String getTriggerName() {
		return "bag";
	}
}
