package goncharov;

import lombok.Getter;

@Getter
public enum TravelDirection {
    NORTH(0, -1),
    SOUTH(0, 1),
    EAST(1, 0),
    WEST(-1, 0),
    NORTHEAST(1, -1),
    NORTHWEST(-1, -1),
    SOUTHEAST(1, 1),
    SOUTHWEST(-1, 1);

    private final int toX;
    private final int toY;

    TravelDirection(int deltaX, int deltaY) {
        this.toX = deltaX;
        this.toY = deltaY;
    }

    public static TravelDirection getRandomDirection() {
        TravelDirection[] directions = values();
        return directions[(int) (Math.random() * directions.length)];
    }
}