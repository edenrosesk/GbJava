package lesson4;

import java.util.Random;
import java.util.Scanner;

public class Homework4 {

    private static int size;
    private static int winSize;

    private static final char dot_empty = '•';
    private static final char dot_human = 'X';
    private static final char dot_ai = '0';


    public static final String HEADER_FIRST_SYMBOL = "*";
    public static final String SPACE_MAP_SYMBOL = " ";


    private static char[][] map = new char[size][size];


    private static final Scanner in = new Scanner(System.in);
    private static final Random random = new Random();

    private static int turnsCount = 0;

    private static int lastTurnRow = 0;
    private static int lastTurnColumn = 0;

    public static void main(String[] args) {
        start();
    }

    private static void start() {
        do {
            System.out.println("\n\nИгра начается!!!");
            init();
            printMap();
            playGame();
        } while (isContinueGame());
    }

    private static void init() {
        turnsCount = 0;
        size = getSizeFromUser();
        winSize = getWinSize();
        initMap();
    }

    private static int getWinSize() {
        if(size >= 3 && size <= 6) {
            return 3;
        } else if (size > 6 && size <= 9) {
            return 4;
        }
        return 5;
    }

    private static int getSizeFromUser() {
        System.out.println("Необходимо выбрать размер игрового поля");
        return getValidNumberFromScanner(3, 9);
    }

    private static boolean isContinueGame() {
        System.out.println("Хотите продолжить? y\\n");
        return switch (in.next()) {
            case "y", "у", "+", "да" -> true;
            default -> false;
        };
    }

    private static void initMap() {

        map = new  char[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = dot_empty;
            }
        }
    }

    private static void printMap() {
        printHeaderMap();
        printBodyMap();
    }

    private static void printMapNumber(int i) {
        System.out.print(i + 1 + SPACE_MAP_SYMBOL);
    }

    private static void printHeaderMap() {
        System.out.print(HEADER_FIRST_SYMBOL + SPACE_MAP_SYMBOL);
        for (int i = 0; i < size; i++) {
            printMapNumber(i);
        }
        System.out.println();

    }

    private static void printBodyMap() {
        for (int i = 0; i < size; i++) {
            printMapNumber(i);
            for (int j = 0; j < size; j++) {
                System.out.print(map[i][j] + SPACE_MAP_SYMBOL);
            }
            System.out.println();

        }
    }
    private static boolean isCellFree ( int rowNumder, int colomnNumder){
        return map[rowNumder][colomnNumder] == dot_empty;
    }

    private static void playGame() {
        while (true) {
            humanTurn();
            printMap();
            if (checkEnd(dot_human)) {
                break;
            }
                //проверка на конец игры

                aiTurn();
                printMap();
            if (checkEnd(dot_ai)) {
                break;
            }
        }
    }

    private static boolean checkEnd(char symbol) {
        if (checkWin(symbol)) {
            if (symbol == dot_human ) {
                System.out.println("Ура! Вы победили!");
            } else {
                System.out.println("Вы проиграли :(");
            }
            
            return true;
        }
        
        if (checkDraw()) {
            System.out.println("Ничья!");
            return true;
        }

        return false;
    }

    private static boolean checkDraw() {

        return turnsCount >= size * size;
    }

//сделать победу, в методичке неправильно
    private static boolean checkWin(char symbol) {
       return checkWinColumnOrRow(symbol) || checkWinUpDiagonal(symbol) || checkWinDownDiagonal(symbol);
    }

    private static boolean checkWinColumnOrRow(char symbol) {
        int winCounterColumn = 0;
        int winCounterRow = 0;

        for (int i = 0; i < size; i++) {
            winCounterColumn += map[i][lastTurnColumn] == symbol ? 1 : -winCounterColumn;
            winCounterRow += map[lastTurnRow][i] == symbol ? 1 : -winCounterRow;

            if (winCounterColumn == winSize || winCounterRow == winSize) return true;
        }
        return false;
    }

    private static boolean checkWinUpDiagonal(char symbol) {
        int winCounter = 0;

        int startPointColumn = lastTurnColumn;
        int startPointRow = lastTurnRow;

        while (startPointRow != 0 && startPointColumn != 0) {
            startPointColumn--;
            startPointRow--;
        }

        while(startPointRow != size && startPointColumn != size) {
            winCounter += map[startPointRow][startPointColumn] == symbol ? 1 : -winCounter;

            if (winCounter == winSize) return true;

            startPointColumn++;
            startPointRow++;


        }


        return false;
    }

    private static boolean checkWinDownDiagonal(char symbol) {
        int winCounter = 0;

        int startPointColumn = lastTurnColumn;
        int startPointRow = lastTurnRow;

        while (startPointRow != size - 1 && startPointColumn != 0) {
            startPointColumn--;
            startPointRow++;
        }

        while(startPointRow != 0 && startPointColumn != size) {
            winCounter += map[startPointRow][startPointColumn] == symbol ? 1 : -winCounter;

            if (winCounter == winSize) return true;

            startPointColumn++;
            startPointRow--;


        }


        return false;
    }


    private static  void humanTurn() {
        System.out.println("\nХОД ЧЕЛОВЕКА!");

        int rowNumder;
        int colomnNumder;

        while (true) {
            System.out.println("Введите координату строки: ");
            rowNumder = getValidNumberMapLineFromScanner();

            System.out.println("Введите координату столбца: ");
            colomnNumder = getValidNumberMapLineFromScanner();

            if (isCellFree(rowNumder, colomnNumder)) {
                break;
            }

            System.out.printf("ОШИБКА! Ячейка с координатами %s:%s уже используется%n",
                    rowNumder + 1, colomnNumder + 1);
        }

        turn(colomnNumder, rowNumder, dot_human);

    }

    private static int getValidNumberMapLineFromScanner() {
        return getValidNumberFromScanner(1, size) -1;
    }

    private static int getValidNumberFromScanner(int min, int max) {
        while (true) {
            System.out.print("Введите число:  ");
            if (in.hasNextInt()) {
                int n = in.nextInt();
                if (isNumberValid(n, min, max)) {
                    return n;
                }
                System.out.printf("ОШИБКА!!! Проверьте значение координаты. " +
                        "Должно быть от %s до %s. Введено: %s%n",
                        min, max, n);
            } else {
                System.out.printf("ОШИБКА!!!Ввод допускает лишь целые числа. %s - не число!%n", in.next());
            }
        }
    }

    private static boolean isNumberValid(int n, int min, int max) {
        return n >= min && n <= max;
    }

    private static void aiTurn () {
        System.out.println("\nХОД КОМПЬЮТЕРА!");
        int rowNumder;
        int colomnNumder;

        do {
            rowNumder = random.nextInt(size);

            colomnNumder = random.nextInt(size);

            if (isCellFree(rowNumder, colomnNumder))
                break;
        } while (!isCellFree(rowNumder, colomnNumder));

        turn(colomnNumder, rowNumder, dot_ai);
    }

    private static void turn(int colomnNumder, int rowNumber, char dot) {
        map[rowNumber][colomnNumder] = dot;

        //запоминаем последний ход
        lastTurnColumn = colomnNumder;
        lastTurnRow = rowNumber;

        turnsCount++;

    }


}



