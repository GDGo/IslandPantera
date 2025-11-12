package goncharov.animals.herbivores;


public class Horse extends Herbivore {
    public static final String name = "Лошадь";
    public static final int maxCountInCell = 20;
    public static final String icon = "\uD83D\uDC0E";
    public static final int maxWeight = 400;
    public static final int maxSpeed = 4;
    public static final int maxFood = 60;

    public Horse() {
        super(name, icon, maxWeight, maxCountInCell, maxSpeed, maxFood);
    }

}
