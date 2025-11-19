package goncharov;

import goncharov.animals.Animal;
import goncharov.animals.Organizm;
import lombok.Getter;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


@Getter
public class LocationOrganizm {
    private final int x;
    private final int y;
    private final List<Animal> organizms = new CopyOnWriteArrayList<>();
    private final Island island;

    public LocationOrganizm(int x, int y, Island island){
        this.x = x;
        this.y = y;
        this.island = island;
    }

    public boolean canAddOrganizm(Class<? extends Organizm> clazz) throws NoSuchFieldException, IllegalAccessException {
        long countOrg = organizms.stream()
                .filter(a -> a.getClass().equals(clazz))
                .count();
        return countOrg < clazz.getDeclaredField("maxCountInCell").getInt(null);
    }

    public void addOrganizm(Animal organizm) throws NoSuchFieldException, IllegalAccessException {
        if (canAddOrganizm(organizm.getClass())){
            organizms.add(organizm);
            organizm.setLocation(this);
        }
    }

    public List<Animal> getOrganizms(){
        return new CopyOnWriteArrayList<>(organizms);
    }

    public void removeOrganizm(Animal organizm){
        organizms.remove(organizm);
    }

    public void moveOrganizm(Animal organizm, int x, int y) throws NoSuchFieldException, IllegalAccessException {
        int moveToX = Math.max(0, Math.min(this.x + x, Config.WIDTH - 1));
        int moveToY = Math.max(0, Math.min(this.x + x, Config.HEIGHT - 1));

        LocationOrganizm moveToNewLoc = island.getLocation(moveToX, moveToY);
        if (moveToNewLoc != null && moveToNewLoc.canAddOrganizm(organizm.getClass())){
            removeOrganizm(organizm);
            moveToNewLoc.addOrganizm(organizm);
        }
    }

    public void removeUnit(Animal organizm){};
}
