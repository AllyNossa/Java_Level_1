package lesson1_2;

import java.util.Random;

public class Robot implements Participant {
    Random random;
    private double maxHeight;
    private double maxLength;

    public Robot() {
        random = new Random();
        maxHeight = random.nextInt(3) + 1;
        maxLength = random.nextInt(10);
    }

    public double getMaxHeight() {
        return maxHeight;
    }

    public double getMaxLength() {
        return maxLength;
    }

    @Override
    public void run(Treadmill treadmill) {
        checkValue(maxLength, treadmill.getLength(), "Робот пробежал");
    }

    @Override
    public void jump(Wall wall) {
        checkValue(maxHeight, wall.getHeight(), "Робот прыгнул");
    }

    @Override
    public boolean isInGame(Treadmill treadmill) {
        if (treadmill.getLength() <= this.maxLength && treadmill.getLength() > min) {
            return true;
        } else
            return false;
    }
}
