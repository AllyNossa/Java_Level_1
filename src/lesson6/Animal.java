package lesson6;

import java.util.Random;

class AnimalApp {
    public static void main(String[] args) {

        Cat cat1 = new Cat();
        Cat cat2 = new Cat();
        Cat cat3 = new Cat();

        Dog dog1 = new Dog();
        Dog dog2 = new Dog();
        Dog dog3 = new Dog();

        cat1.jump(3);
        cat2.run(-6);
        cat2.run(10);
        cat3.swim(56);

        dog1.jump(1);
        dog2.run(3);
        dog1.run(300);
        dog3.run(1700);
        dog2.jump(-4);
        dog3.swim(0);
        dog3.swim(5);
    }
}

public abstract class Animal {

    abstract void run(int length);
    abstract void swim(int length);
    abstract void jump(int height);

}

class Cat extends Animal {

    @Override
    void run(int length){
        if (length <= 200 && length > 0) {
            System.out.println("Кот побежал на " + length + "м");
        } else if (length > 200) {
            System.out.println("Кот не бегает на такие большие расстояния");
        } else {
            System.out.println("Введено некорректное значение длины");
        }
    }

    @Override
    void jump(int heiht) {
        if (heiht <= 2 && heiht > 0) {
            System.out.println("Кот подпрыгнул на " + heiht + "м");
        } else if (heiht > 2) {
            System.out.println("Кот не прыгает на такую высоту");
        } else {
            System.out.println("Введено некорректное значение высоты");
        }
    }

    @Override
    void swim(int length) {
        System.out.println("Кот не умеет плавать");
    }
}

class Dog extends Animal {
    int lengthMax;

    public Dog() {
        Random random = new Random();
        lengthMax = random.nextInt(200 + 1) + 400;
    }

    @Override
    void run(int length){

        if (length <= lengthMax && length > 0) {
            System.out.println("Собака побежала на " + length + "м");
        } else if (length > lengthMax) {
            System.out.println("Собака не бегает на такие большие расстояния");
        } else {
            System.out.println("Введено некорректное значение длины");
        }
    }

    @Override
    void jump(int heiht) {

        if (heiht <= 0.5 && heiht > 0) {
            System.out.println("Собака подпрыгнула на " + heiht + "м");
        } else if (heiht > 0.5) {
            System.out.println("Собака не прыгает на такую высоту");
        } else {
            System.out.println("Введено некорректное значение высоты");
        }
    }

    @Override
    void swim(int length) {

        if (length <= 10 && length > 0) {
            System.out.println("Собака проплыла " + length + "м");
        } else if (length > 10) {
            System.out.println("Собака не плавает на такое расстояние");
        } else {
            System.out.println("Введено некорректное значение длины");
        }
    }
}