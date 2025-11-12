package goncharov.animals;

import lombok.Getter;
import lombok.Setter;

@Getter
public abstract class Organizm {
    private final String type = this.getClass().getSimpleName();
    private final double weight;
    private int maxCountInCell = 0;

    public Organizm(double weight, int maxCountInCell){
        this.weight = weight;
        this.maxCountInCell = maxCountInCell;
    }
}
