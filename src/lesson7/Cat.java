package lesson7;

import java.util.Random;

public class Cat {
    private int appetite;
    private String name;
    private boolean satiety;

    public Cat() {
        Random random = new Random();
        this.satiety = false;
        this.appetite = random.nextInt(90 + 1) + 10;
        String[] nameArray = {"Vaska", "Mursik", "Petr", "Kesha", "Vlad"};
        int pos = random.nextInt(nameArray.length);
        this.name = nameArray[pos];
    }

    public int getAppetite() {
        return appetite;
    }

    public void setAppetite(int appetite) {
        this.appetite = appetite;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSatiety() {
        return satiety;
    }

    public void setSatiety(boolean satiety) {
        this.satiety = satiety;
    }

    public void info() {
        System.out.println("Сытость кота " + this.name + " " + this.satiety);
    }

    public void eat(Plate plate) {
        if (plate.getFood() >= this.appetite) {
            plate.decreaseFood(appetite, this);
            this.satiety = true;
            this.info();
            plate.info();
        } else {
            this.satiety = false;
            System.out.println("Кот " + this.name + " не поел, так как его аппетит: " + this.getAppetite());
            this.info();
            plate.info();
        }
    }
}

class Plate {
    private int food;

    public Plate() {
        Random random = new Random();
        this.food = random.nextInt(200 + 1) + 100;
    }

    public void decreaseFood(int n, Cat cat) {
        System.out.println(cat.getName() + " съел " + n + " еды");
        food -= n;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public void info() {
        System.out.println("В тарелке осталось еды " + this.food);
    }

    public void addFood(int n) {
        food +=n;
        System.out.println("В тарелку добавили еды " + n);
    }
}


class MainClass {
    public static void main(String[] args) {
        Plate plate = new Plate();
        Cat[] cat = new Cat[5];
        plate.info();
        for (int i = 0; i< cat.length; i++){
            cat[i] = new Cat();
            cat[i].eat(plate);
        }
        plate.addFood(200);
        plate.info();
    }
}
