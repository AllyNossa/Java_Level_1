package lesson6;

public class lesson6 {
    public static void main(String[] args) {
        Animal animal1 = new Animal();
        Animal animal2 = new Animal();
        Animal animal3 = new Animal();

        Cat cat1 = new Cat();
        Cat cat2 = new Cat();
        Cat cat3 = new Cat();

        Dog dog1 = new Dog();
        Dog dog2 = new Dog();
        Dog dog3 = new Dog();

        animal1.jump(100);
        animal2.run(2);
        animal3.swim(7);

        cat1.jump(3);
        cat2.run(-6);
        cat2.run(10);
        cat3.swim(56);

        dog1.jump(1);
        dog2.run(3);
        dog2.jump(-4);
        dog3.swim(0);
        dog3.swim(5);
    }
}

class Animal {
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
    @Override
    public void run(int length){
        if (length <= 500 && length > 0) {
            System.out.println("Собака побежала на " + length + "м");
        } else if (length > 500) {
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