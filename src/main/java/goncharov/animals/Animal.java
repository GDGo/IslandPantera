package goncharov.animals;
import goncharov.TravelDirection;
import goncharov.api.Eating;
import goncharov.api.Movable;
import goncharov.api.Reproducible;

import lombok.Getter;

@Getter
public abstract class Animal extends Organizm implements Runnable, Eating, Movable, Reproducible {
    private final String name;
    private final String icon;
    private final int maxSpeed;
    private final double maxFood;

    public Animal(String name, String icon, double maxWeight, int maxCountInCell, int maxSpeed, double maxFood){
        super(maxWeight, maxCountInCell);
        this.name = name;
        this.icon = icon;
        this.maxSpeed = maxSpeed;
        this.maxFood = maxFood;
    }

    public boolean canReproduce(){
        if (location == null){
            return false;
        }
        return isAlive();
    }

    public void move(TravelDirection travelDirection) throws NoSuchFieldException, IllegalAccessException {
        if (location != null){
            location.moveOrganizm(this, travelDirection.getToX(), travelDirection.getToY());
        }
    }

    @Override
    public void run() {
        try {
            move();
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        eat();
        reproduce();
    }

    @Override
    public String toString() {
        return String.format("Организм: %s, адрес X: %s, адрес Y: %s", icon, location.getX(), location.getY());
    }
}
