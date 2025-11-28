package goncharov.animals;
import goncharov.TravelDirection;
import goncharov.api.Died;
import goncharov.api.Eating;
import goncharov.api.Movable;
import goncharov.api.Reproducible;

import lombok.Getter;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
public abstract class Animal extends Organizm implements Runnable, Eating, Movable, Reproducible, Died {
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

    public void move(TravelDirection travelDirection) {
        if (location != null){
            location.moveOrganizm(this, travelDirection.getToX(), travelDirection.getToY());
        }
    }

    @Override
    public void move() {
        TravelDirection travelDirection = TravelDirection.getRandomDirection();
        move(travelDirection);
    }

    @Override
    public void reproduce() {
        Map<Class<? extends Animal>, Long> animals = location.getOrganizms().stream()
                .filter(Animal::isAlive)
                .collect(Collectors.groupingBy(
                        Animal::getClass,
                        Collectors.counting()
                ));
        animals.entrySet().stream()
                .filter(entry -> entry.getValue() >= 3)
                .filter(entry -> location.canAddOrganizm(entry.getKey()))
                .findFirst()
                .ifPresent(entry -> {
                    Class<? extends Animal> orgClass = entry.getKey();
                    try {
                        Animal newOrganizm = orgClass.getDeclaredConstructor().newInstance();
                        if (location.canAddOrganizm(newOrganizm.getClass())){
                            location.getIsland().addOrganizm(newOrganizm, location.getX(), location.getY());
                        }
                    } catch (InstantiationException | IllegalAccessException
                             | InvocationTargetException | NoSuchMethodException e) {
                        System.out.println("Ошибка размножения");
                    }
                });
    }

    @Override
    public void die() {
        setAlive(false);
        if (location != null){
            location.removeOrganizm(this);
        }
    }

    @Override
    public void run() {
        if (isAlive()){
            move();
            eat();
            reproduce();
        }
    }

    @Override
    public String toString() {
        return String.format("Организм: %s", icon);
    }
}
