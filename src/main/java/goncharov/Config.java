package goncharov;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public class Config {
    public final static int WIDTH = 100;
    public final static int HEIGHT = 100;

    public static final Map<String, Map<String, Double>> EATING_PROBABILITIES = new HashMap<>();

    static {
        initEatingProbabilities();
    }

    private static void initEatingProbabilities() {
        // Волк (согласно таблице)
        Map<String, Double> wolf = new HashMap<>();
        wolf.put("Horse", 0.10);
        wolf.put("Deer", 0.15);
        wolf.put("Rabbit", 0.60);
        wolf.put("Mouse", 0.80);
        wolf.put("Goat", 0.60);
        wolf.put("Sheep", 0.70);
        wolf.put("Boar", 0.15);
        wolf.put("Buffalo", 0.10);
        wolf.put("Duck", 0.40);
        EATING_PROBABILITIES.put("Wolf", wolf);

        // Медведь (согласно таблице)
        Map<String, Double> bear = new HashMap<>();
        bear.put("Boa", 0.80);
        bear.put("Horse", 0.40);
        bear.put("Deer", 0.80);
        bear.put("Rabbit", 0.80);
        bear.put("Mouse", 0.90);
        bear.put("Goat", 0.70);
        bear.put("Sheep", 0.70);
        bear.put("Boar", 0.50);
        bear.put("Buffalo", 0.20);
        bear.put("Duck", 0.10);
        EATING_PROBABILITIES.put("Bear", bear);

        // Лиса (согласно таблице)
        Map<String, Double> fox = new HashMap<>();
        fox.put("Rabbit", 0.70);
        fox.put("Mouse", 0.90);
        fox.put("Duck", 0.60);
        fox.put("Caterpillar", 0.40);
        EATING_PROBABILITIES.put("Fox", fox);

        // Орел (согласно таблице)
        Map<String, Double> eagle = new HashMap<>();
        eagle.put("Fox", 0.10);
        eagle.put("Rabbit", 0.90);
        eagle.put("Mouse", 0.90);
        eagle.put("Duck", 0.80);
        EATING_PROBABILITIES.put("Eagle", eagle);

        // Удав (согласно таблице)
        Map<String, Double> boa = new HashMap<>();
        boa.put("Fox", 0.15);
        boa.put("Rabbit", 0.20);
        boa.put("Mouse", 0.40);
        boa.put("Duck", 0.10);
        EATING_PROBABILITIES.put("Boa", boa);

        // Травоядные едят растения
        Map<String, Double> herbivoreFood = new HashMap<>();
        herbivoreFood.put("Plant", 1.0);

        String[] herbivores = {"Rabbit", "Mouse", "Goat",
                "Sheep", "Boar", "Buffalo",
                "Duck", "Caterpillar", "Deer", "Horse"};
        for (String herbivore : herbivores) {
            EATING_PROBABILITIES.put(herbivore, new HashMap<>(herbivoreFood));
        }
    }
}