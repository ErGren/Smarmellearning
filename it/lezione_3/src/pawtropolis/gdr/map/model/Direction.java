package pawtropolis.gdr.map.model;

import java.util.Arrays;

public enum Direction {
	NORTH("north"),
	SOUTH("south"),
	EAST("east"),
	WEST("west"),
	INVALID(null);

	private final String name;
	Direction(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public static Direction of(String s) {
		return Arrays.stream(values())
				.filter(d -> s.equalsIgnoreCase(d.getName()))
				.findAny()
				.orElse(INVALID);
	}
}
