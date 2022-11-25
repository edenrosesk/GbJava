package lesson7;

import java.util.Random;

public class Homework7 {
    public static void main(String[] args) {
        int qtyFood = 100;
        Random sc = new Random();

        Cat[] cats = new Cat[5];
        cats[0] = new Cat("Кыс-кысыч", 50);
        cats[1] = new Cat("Пончик", 120);
        cats[2] = new Cat("Муся", 30);
        cats[3] = new Cat("Леонард", 80);
        cats[4] = new Cat("Феликс", 100);

        Plate plate = new Plate(qtyFood);
        plate.info();

        for (int i = 0; i < cats.length; i++) {
            var cat = cats[i];
            if (!cat.full && cat.appetite < plate.food) {
                cat.eat(plate);
                cat.full = true;
                System.out.println("Ваш котик " + cat.name + " покушал " + cat.appetite + " грамм!");
            } else {
                System.out.println("Ваш котик " + cat.name + " не поел!");
            }
            plate.info();
            qtyFood = sc.nextInt(0, 100);

            System.out.println("Добавим в тарелку " + qtyFood + " вискаса");
            plate.increaseFood(qtyFood);
            plate.info();
        }
    }
}