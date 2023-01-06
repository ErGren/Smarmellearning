package pawtropolis.complex.animals.domain;

import pawtropolis.gdr.animal.domain.AnimalWithTail;

import java.time.LocalDate;

public class Lion extends AnimalWithTail {
	public Lion(String name, String favoriteFood, int age, LocalDate joinDate, double weight, double height, double tailLength) {
		super(name, favoriteFood, age, joinDate, weight, height, tailLength);
	}
}
