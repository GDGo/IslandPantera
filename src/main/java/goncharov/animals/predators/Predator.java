package goncharov.animals.predators;

import goncharov.animals.Animal;

public abstract class Predator extends Animal {
    public Predator(String name, String icon, int maxWeight, int maxCountInCell, int maxSpeed, int maxFood){
        super(name, icon, maxWeight, maxCountInCell, maxSpeed, maxFood);
    }
    @Override
    public void eat() {

    }

    @Override
    public void move() {

    }

    @Override
    public void reproduce() {

    }
}
