package goncharov.animals.herbivores;


public class Caterpillar extends Herbivore {
    public static final String name = "Гусеница";
    public static final int maxCountInCell = 1000;
    public static final String icon = "\uD83D\uDC1B";
    public static final double maxWeight = 0.01;
    public static final int maxSpeed = 0;
    public static final int maxFood = 0;

    public Caterpillar() {
        super(name, icon, maxWeight, maxCountInCell, maxSpeed, maxFood);
    }
}
