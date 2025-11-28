package goncharov;

import goncharov.animals.Animal;
import goncharov.animals.Organizm;
import goncharov.animals.herbivores.*;
import goncharov.animals.predators.*;
import lombok.Getter;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Getter
public class Island {
    private final LocationOrganizm[][] grid;
    private final ScheduledExecutorService executor;
    private Map<Class<? extends Organizm>, Long> previousOrganizm = new HashMap<>();
    private final Map<String, String> organizmIcon = new HashMap<>();
    private final List<Class<? extends Organizm>> allOrganizmClasses = Arrays.asList(
            Wolf.class, Boa.class, Fox.class, Bear.class, Eagle.class,
            Horse.class, Deer.class, Rabbit.class, Mouse.class, Goat.class,
            Sheep.class, Boar.class, Buffalo.class, Duck.class, Caterpillar.class
    );
    private long previousPlants = 0;

    public Island(int width, int height) {
        this.executor = Executors.newScheduledThreadPool(3);
        this.grid = new LocationOrganizm[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                grid[x][y] = new LocationOrganizm(x, y, this);
            }
        }
    }

    public void startSimulation() {
        executor.scheduleAtFixedRate(this::growPlants, 0,
                10000, TimeUnit.MILLISECONDS);

        executor.scheduleAtFixedRate(this::processAnimals, 0,
                2000, TimeUnit.MILLISECONDS);

        executor.scheduleAtFixedRate(this::printStats, 0,
                5000, TimeUnit.MILLISECONDS);
    }

    public void addOrganizm(Animal organizm, int x, int y) {
        if (organizm == null) return;

        if (x >= 0 && x < Config.WIDTH && y >= 0 && y < Config.HEIGHT) {
            LocationOrganizm location = grid[x][y];
            if (location.canAddOrganizm(organizm.getClass())) {
                location.addOrganizm(organizm);
                organizm.setLocation(location);
                organizmIcon.put(organizm.getClass().getSimpleName(), organizm.getIcon());
            }
        }
    }

    private void growPlants() {
        Arrays.stream(grid).flatMap(Arrays::stream).forEach(loc ->
                loc.getPlant().grow()
        );
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

    private void processAnimals() {
        Arrays.stream(grid)
                .flatMap(Arrays::stream)
                .forEach(loc -> {
                    List<Animal> animals = loc.getOrganizms();
                    // Обрабатываем только живых животных
                    animals.stream()
                            .filter(Animal::isAlive)
                            .forEach(animal -> {
                                animal.run();
                            });
                });
    }

    private void printStats() {
        Map<Class<? extends Organizm>, Long> currentAnimals = Arrays.stream(grid)
                .flatMap(Arrays::stream)
                .flatMap(loc -> loc.getOrganizms().stream())
                .filter(Organizm::isAlive)
                .collect(Collectors.groupingBy(
                        Organizm::getClass,
                        Collectors.counting()
                ));

        long currentPlants = Arrays.stream(grid)
                .flatMap(Arrays::stream)
                .mapToInt(loc -> loc.getPlant().getQuantity())
                .sum();

        System.out.println("\n=== Статистика ===");

        Map<Class<? extends Organizm>, Long> fullStats = new LinkedHashMap<>();
        for (Class<? extends Organizm> clazz : allOrganizmClasses) {
            fullStats.put(clazz, currentAnimals.getOrDefault(clazz, 0L));
        }

        fullStats.forEach((clazz, count) -> {
            String className = clazz.getSimpleName();
            String diff = "";

            if (previousOrganizm.containsKey(clazz)) {
                long prevCount = previousOrganizm.get(clazz);
                long difference = count - prevCount;
                if (difference != 0) {
                    diff = String.format(" (%+d)", difference);
                }
            }

            System.out.printf(" %-3s %-12s: %-4d%s%n", organizmIcon.get(className), className, count, diff);
        });

        String plantDiff = previousPlants != 0 ?
                String.format(" (%+d)", currentPlants - previousPlants) : "";
        System.out.printf("Растения: %d%s%n", currentPlants, plantDiff);
        System.out.println("========================");

        previousOrganizm = new HashMap<>(fullStats);
        previousPlants = currentPlants;
    }
}
