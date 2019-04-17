package lesson6;

import java.util.Random;

class AnimalApp {
    public static void main(String[] args) {
        Random random = new Random();
        int number = 5;

        for (int i = 0; i < number; i++) {
            Cat cat = new Cat();
            cat.run(random.nextInt(900));
            cat.swim(random.nextInt(900));
            cat.jump(random.nextInt(900));

            Dog dog = new Dog();
            dog.run(random.nextInt(900));
            dog.swim(random.nextInt(900));
            dog.jump(random.nextInt(900));
        }
    }
}

public abstract class Animal {
    int min = 0;

    abstract void run(int value);

    abstract void swim(int value);

    abstract void jump(int value);

    protected void checkValue(int max, int value, String animal) {
        if (value <= max && value > min) {
            System.out.println(animal + " на " + value + "м");
        } else if (value > max) {
            System.out.println("Введено слишком большое значение");
        } else {
            System.out.println("Введено некорректное значение");
        }
    }
}

class Cat extends Animal {

    @Override
    void run(int value) {
        this.checkValue(200, value, "Кот побежал");
    }

    @Override
    void jump(int value) {
        this.checkValue(2, value, "Кот прыгнул");
    }

    @Override
    void swim(int value) {
        System.out.println("Кот не умеет плавать");
    }
}

class Dog extends Animal {
    int lengthMaxRun;
    int lengthMaxSwim;

    public Dog() {
        Random random = new Random();
        lengthMaxRun = random.nextInt(200 + 1) + 400;
        lengthMaxSwim = random.nextInt(10 + 1) + 10;
    }

    @Override
    void run(int value) {
        this.checkValue(lengthMaxRun, value, "Собака побежала");
    }

    @Override
    void jump(int value) {
        this.checkValue(1, value, "Собака прыгнула");

    }

    @Override
    void swim(int value) {
        this.checkValue(lengthMaxRun, value, "Собака поплыла");
    }
}