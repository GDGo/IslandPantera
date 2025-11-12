package goncharov.animals.predators;


public class Eagle extends Predator {
    public static final String name = "Eagle";
    public static final int maxCountInCell = 20;
    public static final String icon = "\uD83E\uDD85";
    public static final int maxWeight = 6;
    public static final int maxSpeed = 3;
    public static final int maxFood = 1;

    public Eagle() {
        super(name, icon, maxWeight, maxCountInCell, maxSpeed, maxFood);
    }

}
