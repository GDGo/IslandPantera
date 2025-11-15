package goncharov.animals;

import goncharov.LocationOrganizm;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Organizm {
    private final String type = this.getClass().getSimpleName();
    private final double weight;
    private final int maxCountInCell;
    protected LocationOrganizm location;
    private boolean isAlive;

    public Organizm(double weight, int maxCountInCell){
        this.weight = weight;
        this.maxCountInCell = maxCountInCell;
        this.isAlive = true;
    }

    public void die(){
        isAlive = false;
        if (location != null){
            location.removeUnit(this);
        }
    }
}
