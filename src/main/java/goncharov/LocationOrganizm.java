package goncharov;

import goncharov.animals.Animal;
import goncharov.animals.Organizm;
import goncharov.animals.Plant;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


@Getter
public class LocationOrganizm {
    private final int x;
    private final int y;
    private final List<Animal> organizms = new CopyOnWriteArrayList<>();
    private final Island island;
    private final Plant plant;

    public LocationOrganizm(int x, int y, Island island){
        this.x = x;
        this.y = y;
        this.island = island;
        this.plant = new Plant();
    }

    public boolean canAddOrganizm(@NotNull Class<? extends Organizm> clazz) {
        long countOrg = organizms.stream()
                .filter(a -> a.getClass().equals(clazz))
                .count();
        try{
            return countOrg < clazz.getDeclaredField("maxCountInCell").getInt(null);
        } catch (NoSuchFieldException | IllegalAccessException e){
            return false;
        }
    }

    public void addOrganizm(@NotNull Animal organizm) {
        if (canAddOrganizm(organizm.getClass())){
            organizms.add(organizm);
            organizm.setLocation(this);
        }
    }

    public List<Animal> getOrganizms(){
        return new CopyOnWriteArrayList<>(organizms);
    }

    public void removeOrganizm(Organizm organizm){
        organizms.remove(organizm);
    }

    public void moveOrganizm(Animal organizm, int x, int y) {
        int moveToX = Math.max(0, Math.min(this.x + x, Config.WIDTH - 1));
        int moveToY = Math.max(0, Math.min(this.y + y, Config.HEIGHT - 1));

        LocationOrganizm moveToNewLoc = island.getLocation(moveToX, moveToY);
        if (moveToNewLoc != null && moveToNewLoc.canAddOrganizm(organizm.getClass())){
            removeOrganizm(organizm);
            moveToNewLoc.addOrganizm(organizm);
        }
    }
}
