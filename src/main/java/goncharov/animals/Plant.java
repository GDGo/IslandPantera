package goncharov.animals;

public class Plant extends Organizm{
    public static final String name = "Трава";
    public static final int maxCountInCell = 200;
    public static final String icon = "\uD83E\uDEB4";
    public static final int maxWeight = 1;

    public Plant() {
        super(maxWeight, maxCountInCell);
    }
}
