package lesson1_2;

public interface Participant {

    int min = 0;
    void run(Treadmill treadmill);
    void jump(Wall wall);

    default void checkValue(double max, double value, String participant) {
        if (value <= max && value > min) {
            System.out.println(participant + " успешно ");
        } else if (value > max) {
            System.out.println(participant + " не успешно ");
        }
    }

    boolean isInGame(Treadmill treadmill);
}
