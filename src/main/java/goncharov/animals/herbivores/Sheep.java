package goncharov.animals.herbivores;


public class Sheep extends Herbivore {
    public static final String name = "Овца";
    public static final int maxCountInCell = 140;
    public static final String icon = "\uD83D\uDC11";
    public static final int maxWeight = 70;
    public static final int maxSpeed = 3;
    public static final int maxFood = 15;

    public Sheep() {
        super(name, icon, maxWeight, maxCountInCell, maxSpeed, maxFood);
    }
}
