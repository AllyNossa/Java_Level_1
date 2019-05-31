package lesson1_2;

import java.util.Random;

public class Treadmill implements Barrier {
    Random random;
    private double length;

    public Treadmill() {
        random = new Random();
        length = random.nextInt(10) + 0.5;
    }

    public double getLength() {
        return length;
    }
}
