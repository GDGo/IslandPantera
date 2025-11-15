package goncharov;

import goncharov.animals.Organizm;

import java.util.Arrays;


public class Island {
    private final LocationOrganizm[][] grid;

    public Island(int width, int height) {
        this.grid = new LocationOrganizm[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                grid[x][y] = new LocationOrganizm(x, y, this);
            }
        }
    }

    public void addOrganizm(Organizm organizm, int x, int y) throws NoSuchFieldException, IllegalAccessException {
        if (organizm == null) return;

        if (x >= 0 && x < Config.WIDTH && y >= 0 && y < Config.HEIGHT) {
            LocationOrganizm location = grid[x][y];
            if (location.canAddOrganizm(organizm.getClass())) {
                location.addOrganizm(organizm);
                organizm.setLocation(location);
                location.getOrganizms();
                System.out.println(organizm.toString());
            }
        }
    }

    public LocationOrganizm getLocation(int x, int y) {
        if (x >= 0 && x < Config.WIDTH && y >= 0 && y < Config.HEIGHT) {
            return grid[x][y];
        }
        return null;
    }

    public long getTotalAnimalCount() {
        return Arrays.stream(grid)
                .flatMap(Arrays::stream)
                .mapToLong(loc -> loc.getOrganizms().size())
                .sum();
    }
}
