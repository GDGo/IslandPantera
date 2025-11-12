package goncharov.animals.herbivores;


public class Rabbit extends Herbivore {
    public static final String name = "Кролик";
    public static final int maxCountInCell = 150;
    public static final String icon = "\uD83D\uDC07";
    public static final int maxWeight = 2;
    public static final int maxSpeed = 2;
    public static final double maxFood = 0.45;

    public Rabbit() {
        super(name, icon, maxWeight, maxCountInCell, maxSpeed, maxFood);
    }

}
