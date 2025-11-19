package goncharov.animals.predators;


public class Boar extends Predator {
    public static final String name = "Boar";
    public static final int maxCountInCell = 5;
    public static final String icon = "\uD83D\uDC17";
    public static final int maxWeight = 50;
    public static final int maxSpeed = 3;
    public static final int maxFood = 8;

    public Boar() {
        super(name, icon, maxWeight, maxCountInCell, maxSpeed, maxFood);
    }

}
