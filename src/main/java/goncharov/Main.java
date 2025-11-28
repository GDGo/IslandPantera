package goncharov;


import goncharov.animals.herbivores.*;
import goncharov.animals.predators.*;

public class Main {
    public static void main(String[] args) {
        Island island = new Island(Config.WIDTH, Config.HEIGHT);
        initializeOrganizm(island);
        island.startSimulation();
    }

    public static void initializeOrganizm(Island island) {
        for (int i = 0; i < 500; i++) {
            island.addOrganizm(new Rabbit(), randX(), randY());
            island.addOrganizm(new Sheep(), randX(),randY());
            island.addOrganizm(new Mouse(), randX(),randY());
            island.addOrganizm(new Horse(), randX(),randY());
            island.addOrganizm(new Goat(), randX(),randY());
            island.addOrganizm(new Duck(), randX(),randY());
            island.addOrganizm(new Deer(), randX(),randY());
            island.addOrganizm(new Caterpillar(), randX(),randY());
            island.addOrganizm(new Buffalo(), randX(),randY());
            island.addOrganizm(new Boar(), randX(),randY());
            island.addOrganizm(new Wolf(), randX(), randY());
            island.addOrganizm(new Fox(), randX(),randY());
            island.addOrganizm(new Eagle(), randX(),randY());
            island.addOrganizm(new Boa(), randX(),randY());
            island.addOrganizm(new Bear(), randX(),randY());
        }
    }

    private static int randX() {
        return (int) (Math.random() * Config.WIDTH);
    }

    private static int randY() {
        return (int) (Math.random() * Config.HEIGHT);
    }
}
