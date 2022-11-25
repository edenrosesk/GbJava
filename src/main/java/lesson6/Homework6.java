package lesson6;

public class Homework6 {
    public static void main(String[] args) {

        Cat cat = new Cat("Васька");
        Dog dog = new Dog("Бобик");
        Cat cat1 = new Cat("Борис");
        Dog dog1 = new Dog("Тобик");

        cat.run(210);
        dog.swim(5);

        cat1.swim(2);
        dog1.run(400);
    }
}
