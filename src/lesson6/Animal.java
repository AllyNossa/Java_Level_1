package lesson6;

import java.util.Random;

class AnimalApp {
    public static void main(String[] args) {
        Random random = new Random();
        int randomLength = random.nextInt(800);

        Animal animal1 = new Animal();
        Animal animal2 = new Animal();
        Animal animal3 = new Animal();

        Cat cat1 = new Cat();
        Cat cat2 = new Cat();
        Cat cat3 = new Cat();

        Dog dog1 = new Dog(randomLength);
        Dog dog2 = new Dog(randomLength);
        Dog dog3 = new Dog(randomLength);

        animal1.jump(100);
        animal2.run(2);
        animal3.swim(7);

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

public class Animal {

    public void run(int length) {
        System.out.println("Животное попыталось побежать");
    }
    public  void swim(int length) {
        System.out.println("Животное попыталось поплыть");
    }
    public void jump(int heiht) {
        System.out.println("Животное попыталось подпрыгнуть");
    }
}

class Cat extends Animal {
    @Override
    public void run(int length){
        if (length <= 200 && length > 0) {
            System.out.println("Кот побежал на " + length + "м");
        } else if (length > 200) {
            System.out.println("Кот не бегает на такие большие расстояния");
        } else {
            System.out.println("Введено некорректное значение длины");
        }
    }

    @Override
    public void jump(int heiht) {
        if (heiht <= 2 && heiht > 0) {
            System.out.println("Кот подпрыгнул на " + heiht + "м");
        } else if (heiht > 2) {
            System.out.println("Кот не прыгает на такую высоту");
        } else {
            System.out.println("Введено некорректное значение высоты");
        }
    }

    @Override
    public void swim(int length) {
        System.out.println("Кот не умеет плавать");
    }
}

class Dog extends Animal {
    int lengthMax;

    public Dog(int lengthMax) {
        this.lengthMax = lengthMax;
    }

    @Override
    public void run(int length){
        if (length <= lengthMax && length > 0) {
            System.out.println("Собака побежала на " + length + "м");
        } else if (length > lengthMax) {
            System.out.println("Собака не бегает на такие большие расстояния");
        } else {
            System.out.println("Введено некорректное значение длины");
        }
    }

    @Override
    public void jump(int heiht) {
        super.jump(heiht);
        if (heiht <= 0.5 && heiht > 0) {
            System.out.println("Собака подпрыгнула на " + heiht + "м");
        } else if (heiht > 0.5) {
            System.out.println("Собака не прыгает на такую высоту");
        } else {
            System.out.println("Введено некорректное значение высоты");
        }
    }

    @Override
    public void swim(int length) {
        super.swim(length);
        if (length <= 10 && length > 0) {
            System.out.println("Собака проплыла " + length + "м");
        } else if (length > 10) {
            System.out.println("Собака не плавает на такое расстояние");
        } else {
            System.out.println("Введено некорректное значение длины");
        }
    }
}