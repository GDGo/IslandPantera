package goncharov.animals.herbivores;


public class Deer extends Herbivore {
    public static final String name = "Олень";
    public static final int maxCountInCell = 20;
    public static final String icon = "\uD83E\uDD8C";
    public static final int maxWeight = 300;
    public static final int maxSpeed = 4;
    public static final int maxFood = 50;

    public Deer() {
        super(name, icon, maxWeight, maxCountInCell, maxSpeed, maxFood);
    }

}
