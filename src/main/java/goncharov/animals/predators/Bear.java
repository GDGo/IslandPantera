package goncharov.animals.predators;


public class Bear extends Predator {
    public static final String name = "Bear";
    public static final int maxCountInCell = 5;
    public static final String icon = "\uD83D\uDC3B";
    public static final int maxWeight = 500;
    public static final int maxSpeed = 2;
    public static final int maxFood = 80;

    public Bear() {
        super(name, icon, maxWeight, maxCountInCell, maxSpeed, maxFood);
    }
}
