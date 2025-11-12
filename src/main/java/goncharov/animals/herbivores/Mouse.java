package goncharov.animals.herbivores;


public class Mouse extends Herbivore {
    public static final String name = "Мышь";
    public static final int maxCountInCell = 500;
    public static final String icon = "\uD83D\uDC01";
    public static final double maxWeight = 0.05;
    public static final int maxSpeed = 1;
    public static final double maxFood = 0.01;

    public Mouse() {
        super(name, icon, maxWeight, maxCountInCell, maxSpeed, maxFood);
    }

}
