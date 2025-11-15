package goncharov.api;

@FunctionalInterface
public interface Movable {
    void move() throws NoSuchFieldException, IllegalAccessException;
}
