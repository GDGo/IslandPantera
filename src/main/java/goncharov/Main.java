package goncharov;

import goncharov.animals.Animal;
import goncharov.animals.Plant;
import goncharov.animals.predators.Wolf;

public class Main {
    public static void main(String[] args) {
        Plant plant = new Plant();
        System.out.println(plant.getType());
        System.out.println(plant.getWeight());
        System.out.println(plant.getMaxCountInCell());
        System.out.println(plant.getClass());

        Animal wolf = new Wolf();
        System.out.println(wolf);
    }
}
