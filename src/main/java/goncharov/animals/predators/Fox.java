package goncharov.animals.predators;


public class Fox extends Predator {
    public static final String name = "Fox";
    public static final int maxCountInCell = 30;
    public static final String icon = "\uD83E\uDD8A";
    public static final int maxWeight = 8;
    public static final int maxSpeed = 2;
    public static final int maxFood = 2;

    public Fox() {
        super(name, icon, maxWeight, maxCountInCell, maxSpeed, maxFood);
    }

}
