package lesson1_2;

import java.util.Random;

public class Wall implements Barrier {
    Random random;
    private double height;

    public Wall() {
        random = new Random();
        height = random.nextInt(2) + 0.2;
    }

    public double getHeight() {
        return height;
    }
}
