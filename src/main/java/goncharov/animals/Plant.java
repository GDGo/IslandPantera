package goncharov.animals;

import lombok.Getter;

@Getter
public class Plant extends Organizm {
    public static final String name = "Трава";
    public static final int maxCountInCell = 200;
    public static final String icon = "\uD83E\uDEB4";
    public static final int maxWeight = 1;
    public int quantity;

    public Plant() {
        super(maxWeight, maxCountInCell);
        this.quantity = 0;
    }

    public void grow() {
        if (quantity < maxCountInCell) {
            quantity++;
        }
    }

    @Override
    public void die() {
        if (quantity > 0){
            quantity--;
        }
    }
}
