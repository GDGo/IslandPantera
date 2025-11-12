package goncharov.animals.predators;

public class Boa extends Predator {
    public static final String name = "Boa";
    public static final int maxCountInCell = 30;
    public static final String icon = "\uD83D\uDC0D";
    public static final int maxWeight = 15;
    public static final int maxSpeed = 1;
    public static final int maxFood = 3;

    public Boa() {
        super(name, icon, maxWeight, maxCountInCell, maxSpeed, maxFood);
    }
}
