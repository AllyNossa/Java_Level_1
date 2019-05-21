package lesson1_2;

import java.util.Random;

public class Cat implements Participant {
    Random random;
    private double maxHeight;
    private double maxLength;

    public Cat() {
        random = new Random();
        maxHeight = random.nextInt(4);
        maxLength = random.nextInt(20);
    }

    public double getMaxHeight() {
        return maxHeight;
    }

    public double getMaxLength() {
        return maxLength;
    }

    @Override
    public void run(Treadmill treadmill) {
        checkValue(maxLength, treadmill.getLength(), "Кошка пробежала");
    }

    @Override
    public void jump(Wall wall) {
        checkValue(maxHeight, wall.getHeight(), "Кошка прыгнула");
    }

    @Override
    public boolean isInGame(Treadmill treadmill) {
        if (treadmill.getLength() <= this.maxLength && treadmill.getLength() > min) {
            return true;
        } else
            return false;
    }
}
