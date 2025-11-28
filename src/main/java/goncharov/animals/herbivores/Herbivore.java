package goncharov.animals.herbivores;

import goncharov.Config;
import goncharov.animals.Animal;
import goncharov.animals.Plant;

import java.util.Map;

public abstract class Herbivore extends Animal {
    public Herbivore(String name, String icon, double maxWeight, int maxCountInCell, int maxSpeed, double maxFood) {
        super(name, icon, maxWeight, maxCountInCell, maxSpeed, maxFood);
    }

    @Override
    public void eat() {
        Plant plant = location.getPlant();
        String predatorName = this.getClass().getSimpleName();
        if (plant.getQuantity() > 0) {
            Map<String, Double> probabilityMap = Config.EATING_PROBABILITIES.get(predatorName);
            if (probabilityMap != null){
                double probability = probabilityMap.getOrDefault("Plant", 0.0);
                if (probability > 0.0){
                    plant.die();
                }
            }
        }
    }
}
