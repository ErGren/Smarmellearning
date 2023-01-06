package pawtropolis.gdr.player.util;

import pawtropolis.gdr.animal.domain.Animal;
import pawtropolis.gdr.map.model.Direction;
import pawtropolis.gdr.player.domain.Item;

import java.util.List;
import java.util.stream.Collectors;

public final class PlayerDomainUtils {
	private PlayerDomainUtils() {}
	public static String getItemsListDescriptionString(List<Item> items) {
		String itemsDescription = "[" + items.stream()
				.map(i -> i.getName() + "(" + i.getRequiredSlots() + ")" + ", ")
				.collect(Collectors.joining());
		return itemsDescription.substring(0, itemsDescription.length() - 2) + "]";
	}

	public static String getAnimalsListDescriptionString(List<Animal> animals) {
		String animalsDescription = animals.stream()
				.map(a -> a.getName() + "(" + a.getClass().getSimpleName() + ")" + ", ")
				.collect(Collectors.joining());
		return animalsDescription.substring(0, animalsDescription.length() - 2);
	}

	public static String getDirectionsListDescriptionString(List<Direction> directions) {
		String doorsDescription = directions.stream()
				.map(d -> d.getName() + ", ")
				.collect(Collectors.joining());
		return doorsDescription.substring(0, doorsDescription.length() - 2);
	}
}
