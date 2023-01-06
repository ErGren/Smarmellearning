package pawtropolis.gdr.map.model;

import pawtropolis.gdr.animal.domain.Animal;
import pawtropolis.gdr.player.domain.Item;
import pawtropolis.gdr.player.util.PlayerDomainUtils;

import java.util.*;

public class Room {
	private String name;
	private final List<Item> items;
	private final List<Animal> animals;
	private final EnumMap<Direction, Room> adjacentRooms;

	public Room(String name) {
		this.name = name;
		this.items = new ArrayList<>();
		this.animals = new ArrayList<>();
		this.adjacentRooms = new EnumMap<>(Direction.class);
	}

	public Animal addAnimal(Animal animal) {
		animals.add(animal);
		return animal;
	}

	public Animal removeAnimal(Animal animal) {
		return animals.remove(animal) ? animal : null;
	}

	public void removeAllAnimals() {
		animals.clear();
	}

	public List<Animal> getAnimals() {
		return animals;
	}

	public List<Item> getItems() {
		return items;
	}

	public boolean containsAnimal(Animal animal) {
		return animals.contains(animal);
	}

	public Item addItem(Item item) {
		items.add(item);
		return item;
	}

	public Item removeItem(Item item) {
		return items.remove(item) ? item : null;
	}

	public Item removeItem(String itemName) {
		Item item = items.stream()
				.filter(i -> i.getName().equals(itemName))
				.findAny()
				.orElse(null);
		if (item == null) {
			return null;
		}
		return items.remove(item) ? item : null;
	}

	public void removeAllItems() {
		items.clear();
	}

	public boolean containsItem(Item item) {
		return items.contains(item);
	}

	public Item getItemByName(String itemName) {
		return items.stream()
				.filter(i -> i.getName().equals(itemName))
				.findAny()
				.orElse(null);
	}

	public boolean containsItem(String itemName) {
		return items.stream()
				.map(Item::getName)
				.anyMatch(itemName::equals);
	}

	public Room linkRoom(Room room, Direction direction) {
		return adjacentRooms.put(direction, room);
	}

	public Room getAdjacentRoom(Direction direction) {
		return adjacentRooms.get(direction);
	}

	public Room unlinkRoom(Room room) {
		return adjacentRooms.values().remove(room) ? room : null;
	}

	public Room unlinkRoom(Direction direction) {
		return adjacentRooms.remove(direction);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		String itemsDescription = "[]";
		if (!items.isEmpty()) {
			itemsDescription = PlayerDomainUtils.getItemsListDescriptionString(items);
		}

		String animalsDescription = "[]";
		if (!animals.isEmpty()) {
			animalsDescription = PlayerDomainUtils.getAnimalsListDescriptionString(animals);
		}

		String doorsDescription = "[]";
		if (!adjacentRooms.isEmpty()) {
			doorsDescription = PlayerDomainUtils.getDirectionsListDescriptionString(new ArrayList<>(adjacentRooms.keySet()));
		}
		
		return name + "."
				+ "\nItems: "
				+ itemsDescription
				+ "\nNPCs: "
				+ animalsDescription
				+ "\nDoors: "
				+ doorsDescription;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Room room = (Room) o;
		return name.equals(room.name) && items.equals(room.items) && animals.equals(room.animals) && adjacentRooms.equals(room.adjacentRooms);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, items, animals, adjacentRooms);
	}

	@Override
	public String toString() {
		return "Room{" +
				"nome='" + name + '\'' +
				", items=" + items +
				", animals=" + animals +
				", adjacentRooms=" + adjacentRooms +
				'}';
	}
}
