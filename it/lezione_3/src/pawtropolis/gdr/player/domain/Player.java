package pawtropolis.gdr.player.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Player {
	private int lifePoints;
	private String name;
	private final Bag bag;

	public Player(String name, int lifePoints) {
		this.name = name;
		this.lifePoints = lifePoints;
		this.bag = new Bag();
	}

	public Item addItemToBag(Item item) {
		return bag.addItem(item);
	}

	public Item removeItemFromBag(Item item) {
		return bag.removeItem(item);
	}

	public void removeAllItemsFromBag() {
		bag.removeAllItems();
	}

	public List<Item> getItemsInBag() {
		return new ArrayList<>(bag.getAllItems());
	}

	public boolean checkItemFitsInBag(Item item) {
		return bag.checkItemFits(item);
	}

	public Item getItemFromBagByName(String itemName) {
		return bag.getItemByName(itemName);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLifePoints() {
		return lifePoints;
	}

	public void setLifePoints(int lifePoints) {
		this.lifePoints = lifePoints;
	}

	public void increaseLifePoints(int delta) {
		if (delta > 0) {
			lifePoints += delta;
		}
	}

	public void decreaseLifePoints(int delta) {
		if (delta > 0) {
			lifePoints -= delta;
		}
	}

	public boolean isAlive() {
		return lifePoints > 0;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Player player = (Player) o;
		return lifePoints == player.lifePoints
				&& name.equals(player.name)
				&& bag.equals(player.bag);
	}

	@Override
	public int hashCode() {
		return Objects.hash(lifePoints, name, bag);
	}

	@Override
	public String toString() {
		return "Player{" +
				"lifePoints=" + lifePoints +
				", name='" + name + '\'' +
				", bag=" + bag +
				'}';
	}
}
