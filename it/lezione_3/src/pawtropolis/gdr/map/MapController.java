package pawtropolis.gdr.map;

import pawtropolis.gdr.animal.domain.Lion;
import pawtropolis.gdr.map.model.Direction;
import pawtropolis.gdr.map.model.Room;
import pawtropolis.gdr.player.domain.Item;

import java.time.LocalDate;

public class MapController {
	private Room currentRoom;

	public MapController() {
		currentRoom = createMap();
	}

	public Room getCurrentRoom() {
		return currentRoom;
	}

	public boolean changeRoom(Direction direction) {
		Room nextRoom = currentRoom.getAdjacentRoom(direction);
		if (nextRoom != null) {
			currentRoom = nextRoom;
			return true;
		}
		return false;
	}

	private static Room createMap() {
		Room entrance = new Room("Entrance");
		Room garden = new Room("Garden");
		garden.addItem(new Item("Zappa", "Pe' zappà 'a vigna", 3));
		linkRooms(entrance, garden, Direction.NORTH);
		Room spookyHouse = new Room("Spooky House");
		spookyHouse.addItem(new Item("cheese", "ghosts' favorite food", 1));
		linkRooms(garden, spookyHouse, Direction.EAST);
		Room cemetery = new Room("Cemetery");
		linkRooms(spookyHouse, cemetery, Direction.SOUTH);
		cemetery.addAnimal(new Lion("Formaggino", "cheese", 99, LocalDate.now(), 1.7, 0, 1));

		return entrance;
	}

	private static void linkRooms(Room a, Room b, Direction directionA, Direction directionB) {
		a.linkRoom(b, directionA);
		b.linkRoom(a, directionB);
	}

	private static void linkRooms(Room a, Room b, Direction direction) {
		Direction directionB;
		switch (direction) {
			case NORTH:
				directionB = Direction.SOUTH;
				break;
			case SOUTH:
				directionB = Direction.NORTH;
				break;
			case EAST:
				directionB = Direction.WEST;
				break;
			case WEST:
				directionB = Direction.EAST;
				break;
			default:
				directionB = Direction.INVALID;
				break;
		}
		linkRooms(a, b, direction, directionB);
	}
}
