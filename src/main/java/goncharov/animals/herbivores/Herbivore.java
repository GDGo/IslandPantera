package goncharov.animals.herbivores;

import goncharov.TravelDirection;
import goncharov.animals.Animal;

public abstract class Herbivore extends Animal {
    public Herbivore(String name, String icon, double maxWeight, int maxCountInCell, int maxSpeed, double maxFood) {
        super(name, icon, maxWeight, maxCountInCell, maxSpeed, maxFood);
    }
    @Override
    public void eat() {

    }

    @Override
    public void move() throws NoSuchFieldException, IllegalAccessException {
        TravelDirection travelDirection = TravelDirection.getRandomDirection();
        move(travelDirection);
    }

    @Override
    public void reproduce() {

    }
}
