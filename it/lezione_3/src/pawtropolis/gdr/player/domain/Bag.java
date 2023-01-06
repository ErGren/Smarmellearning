package pawtropolis.gdr.player.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Bag {
	private static final int DEFAULT_MAX_SLOTS = 10;
	private final List<Item> items;
	private int availableSlots;
	private final int maxSlots;

	public Bag() {
		this.maxSlots = DEFAULT_MAX_SLOTS;
		this.availableSlots = maxSlots;
		this.items = new ArrayList<>(maxSlots);
	}

	public Bag(int maxSlots) {
		this.maxSlots = maxSlots;
		this.availableSlots = maxSlots;
		this.items = new ArrayList<>(maxSlots);
	}

	public Item addItem(Item item) {
		if (availableSlots - item.getRequiredSlots() >= 0) {
			items.add(item);
			availableSlots -= item.getRequiredSlots();
			return item;
		}
		return null;
	}

	public boolean checkItemFits(Item item) {
		return availableSlots - item.getRequiredSlots() >= 0;
	}

	public Item removeItem(Item item) {
		if (items.remove(item)) {
			availableSlots += item.getRequiredSlots();
			return item;
		}
		return null;
	}

	public Item removeItem(String itemName) {
		Item item = items.stream()
				.filter(i -> i.getName().equals(itemName))
				.findAny()
				.orElse(null);
		if (item == null) {
			return null;
		}
		return removeItem(item);
	}

	public void removeAllItems() {
		items.clear();
	}

	public boolean containsItem(Item item) {
		return items.contains(item);
	}

	public boolean containsItem(String itemName) {
		return items.stream()
				.map(Item::getName)
				.anyMatch(itemName::equals);
	}

	public Item getItemByName(String itemName) {
		return items.stream()
				.filter(i -> i.getName().equals(itemName))
				.findAny()
				.orElse(null);
	}

	public List<Item> getAllItems() {
		return items;
	}

	public boolean isFull() {
		return items.size() == maxSlots;
	}

	public boolean isEmpty() {
		return items.isEmpty();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Bag bag = (Bag) o;
		return availableSlots == bag.availableSlots
				&& maxSlots == bag.maxSlots
				&& items.equals(bag.items);
	}

	@Override
	public int hashCode() {
		return Objects.hash(items, availableSlots, maxSlots);
	}

	@Override
	public String toString() {
		return "Bag{" +
				"items=" + items +
				", availableSlots=" + availableSlots +
				", maxSlots=" + maxSlots +
				'}';
	}
}
