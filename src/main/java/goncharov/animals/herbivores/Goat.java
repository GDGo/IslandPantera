package goncharov.animals.herbivores;


public class Goat extends Herbivore {
    public static final String name = "Коза";
    public static final int maxCountInCell = 140;
    public static final String icon = "\uD83D\uDC10";
    public static final int maxWeight = 60;
    public static final int maxSpeed = 3;
    public static final int maxFood = 10;

    public Goat() {
        super(name, icon, maxWeight, maxCountInCell, maxSpeed, maxFood);
    }

}
