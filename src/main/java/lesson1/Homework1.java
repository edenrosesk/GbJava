package lesson1;

public class Homework1 {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
    }

    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
        System.out.println();
    }

    public static void checkSumSign() {
        int a = 3;
        int b = 5;

        if (a + b >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }

        System.out.println();
    }

    public static void printColor() {
        int value = -5;

        if (value <= 0) {
            System.out.println("Красный");
        }
        if (value > 0 && value <= 100) {
            System.out.println("Жёлтый");
        }
        if (value > 100) {
            System.out.println("Зеленый");
        }

        System.out.println();

    }

    public static void compareNumbers() {
        int a = 3;
        int b = 5;

        if (a>=b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }
}
