package goncharov.animals;


import lombok.Getter;

@Getter
public abstract class Animal extends Organizm implements Runnable {
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

    public abstract void eat();
    public abstract void move();
    public abstract void reproduce();

    @Override
    public void run() {

    }
}
