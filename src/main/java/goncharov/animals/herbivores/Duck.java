package goncharov.animals.herbivores;


public class Duck extends Herbivore {
    public static final String name = "Утка";
    public static final int maxCountInCell = 200;
    public static final String icon = "\uD83E\uDD86";
    public static final int maxWeight = 1;
    public static final int maxSpeed = 4;
    public static final double maxFood = 0.15;

    public Duck() {
        super(name, icon, maxWeight, maxCountInCell, maxSpeed, maxFood);
    }

}
