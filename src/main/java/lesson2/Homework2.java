package lesson2;

public class Homework2 {
    public static void main(String[] args) {
        System.out.println(within10and20(3, 5));
        System.out.println();
        System.out.println(isPositiveOrNegative(7));
        System.out.println();
        System.out.println(isNegative(-25257));
        System.out.println();
        printWordNTimes("строка", 10);
        System.out.println();
        System.out.println();
        System.out.println(isLeapYear(1800));
        System.out.println();

    }

    // 1. Написать метод, принимающий на вход два целых числа и проверяющий, что их сумма лежит в
    // пределах от 10 до 20 (включительно), если да – вернуть true, в противном случае – false.
    public static boolean within10and20(int x, int y) {
        int sum = x + y;
        return sum >= 10 && sum <= 20;
    }

    // 2. Написать метод, которому в качестве параметра передается целое число, метод должен
    // напечатать в консоль, положительное ли число передали или отрицательное. Замечание: ноль
    // считаем положительным числом.

    public static String isPositiveOrNegative(int x) {
        if (x >= 0)
            return "Число положительное";

        return "Число отрицательное";

    }
    // 3. Написать метод, которому в качестве параметра передается целое число. Метод должен
    // вернуть true, если число отрицательное, и вернуть false если положительное.

    public static boolean isNegative(int x) {
        return x < 0;
    }

    //4. Написать метод, которому в качестве аргументов передается строка и число, метод должен
    // отпечатать в консоль указанную строку, указанное количество раз;

    public static void printWordNTimes(String word, int times) {
        for (int i = 1; i <= times; i++) {
            System.out.print(word + ";");
        }

    }
    //5. * Написать метод, который определяет, является ли год високосным, и возвращает boolean
    // (високосный - true, не високосный - false). Каждый 4-й год является високосным, кроме
    // каждого 100-го, при этом каждый 400-й – високосный.

    public static boolean isLeapYear(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }
}
