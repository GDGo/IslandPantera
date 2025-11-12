package goncharov.animals.herbivores;


public class Buffalo extends Herbivore {
    public static final String name = "Буйвол";
    public static final int maxCountInCell = 10;
    public static final String icon = "\uD83D\uDC03";
    public static final int maxWeight = 700;
    public static final int maxSpeed = 3;
    public static final int maxFood = 100;

    public Buffalo() {
        super(name, icon, maxWeight, maxCountInCell, maxSpeed, maxFood);
    }
}
