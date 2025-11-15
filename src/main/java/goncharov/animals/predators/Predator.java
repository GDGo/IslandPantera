package goncharov.animals.predators;

import goncharov.TravelDirection;
import goncharov.animals.Animal;

public abstract class Predator extends Animal {
    public Predator(String name, String icon, int maxWeight, int maxCountInCell, int maxSpeed, int maxFood){
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
