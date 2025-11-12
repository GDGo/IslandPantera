package goncharov.animals.predators;


public class Wolf extends Predator {
    public static final String name = "Wolf";
    public static final int maxCountInCell = 30;
    public static final String icon = "\uD83D\uDC3A";
    public static final int maxWeight = 50;
    public static final int maxSpeed = 3;
    public static final int maxFood = 8;

    public Wolf() {
        super(name, icon, maxWeight, maxCountInCell, maxSpeed, maxFood);
    }
}
