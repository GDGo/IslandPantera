package goncharov;

import goncharov.animals.Organizm;
import lombok.Getter;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


@Getter
public class LocationOrganizm {
    private final int x;
    private final int y;
    private final List<Organizm> organizms = new CopyOnWriteArrayList<>();
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

    public void addOrganizm(Organizm organizm) throws NoSuchFieldException, IllegalAccessException {
        if (canAddOrganizm(organizm.getClass())){
            organizms.add(organizm);
            organizm.setLocation(this);
        }
    }

    public void removeOrganizm(Organizm organizm){
        organizms.remove(organizm);
    }

    public void moveOrganizm(Organizm organizm, int x, int y) throws NoSuchFieldException, IllegalAccessException {
        int moveToX = Math.max(0, Math.min(this.x + x, Config.WIDTH - 1));
        int moveToY = Math.max(0, Math.min(this.x + x, Config.HEIGHT - 1));

        LocationOrganizm moveToNewLoc = island.getLocation(moveToX, moveToY);
        if (moveToNewLoc != null && moveToNewLoc.canAddOrganizm(organizm.getClass())){
            removeOrganizm(organizm);
            moveToNewLoc.addOrganizm(organizm);
            System.out.println(moveToX);
            System.out.println(moveToY);
        }
    }

    public void removeUnit(Organizm organizm){};
}
