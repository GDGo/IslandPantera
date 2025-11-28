package goncharov.animals.predators;

import goncharov.Config;
import goncharov.animals.Animal;

import java.util.List;
import java.util.Map;
import java.util.Random;

public abstract class Predator extends Animal {
    public Predator(String name, String icon, int maxWeight, int maxCountInCell, int maxSpeed, int maxFood){
        super(name, icon, maxWeight, maxCountInCell, maxSpeed, maxFood);
    }

    @Override
    public void eat() {
        Random random = new Random();
        List<Animal> preyList = location.getOrganizms().stream()
                .filter(a -> a != this && a.isAlive())
                .toList();

        if (!preyList.isEmpty()) {
            Animal prey = preyList.get(random.nextInt(preyList.size()));
            String predatorName = this.getClass().getSimpleName();
            String preyName = prey.getClass().getSimpleName();
            if (this.getWeight() > prey.getWeight()){
                Map<String, Double> probabilityMap = Config.EATING_PROBABILITIES.get(predatorName);
                if (probabilityMap != null){
                    double probability = probabilityMap.getOrDefault(preyName, 0.0);
                    if (probability > 0.0){
                        prey.die();
                    }
                }
            }
        }
    }
}
