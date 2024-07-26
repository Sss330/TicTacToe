import java.util.Random;
import java.util.Scanner;

class Test {
    private static final char CELL_EMPTY = '*';
    private static final char CELL_X = 'X';
    private static final char CELL_0 = '0';
    private static final String WIN_0 = "нолики победили";
    private static final String WIN_X = "крестики победили";
    private static final char[][] FILD = {
            {CELL_EMPTY, CELL_EMPTY, CELL_EMPTY},
            {CELL_EMPTY, CELL_EMPTY, CELL_EMPTY},
            {CELL_EMPTY, CELL_EMPTY, CELL_EMPTY},
    };

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        while (true) {
            printField();
            playerTurn();
            if (checkGameStatus()) break;
            botTurn();
            if (checkGameStatus()) break;
        }
    }

    public static void printField() {

        for (int i = 0; i < FILD[0].length; i++) {
            System.out.print("  " + (i + 1));
        }
        // Отпечатка поля
        for (int i = 0; i < FILD.length; i++) {
            System.out.println();
            System.out.print((i + 1) + " ");
            for (int j = 0; j < FILD[i].length; j++) {
                System.out.print(FILD[i][j] + "  ");
            }
        }
        System.out.println();
        System.out.println();
    }

    public static boolean checkGameStatus() {
        if (checkX_won() || check0Won()) {
            return true; // Игра завершена
        }
        if (checkDraw()) {
            return true; // Игра завершена
        }
        return false; // Игра продолжается
    }

    public static boolean checkX_won() {
        for (int i = 0; i < 3; i++) {
            // Проверка горизонталей
            if (FILD[i][0] == CELL_X && FILD[i][1] == CELL_X && FILD[i][2] == CELL_X) {
                System.out.println(WIN_X);
                return true;
            }
            // Проверка вертикалей
            if (FILD[0][i] == CELL_X && FILD[1][i] == CELL_X && FILD[2][i] == CELL_X) {
                System.out.println(WIN_X);
                return true;
            }
        }
        // Проверка диагоналей
        if (FILD[0][0] == CELL_X && FILD[1][1] == CELL_X && FILD[2][2] == CELL_X) {
            System.out.println(WIN_X);
            return true; // Победа X
        }
        if (FILD[0][2] == CELL_X && FILD[1][1] == CELL_X && FILD[2][0] == CELL_X) {
            System.out.println(WIN_X);
            return true;
        }
        return false;

    }
    public static boolean check0Won() {
        for (int i = 0; i < 3; i++) {
            // Проверка горизонталей
            if (FILD[i][0] == CELL_0 && FILD[i][1] == CELL_0 && FILD[i][2] == CELL_0) {
                System.out.println(WIN_0);
                return true; // Победа 0
            }
            // Проверка вертикалей
            if (FILD[0][i] == CELL_0 && FILD[1][i] == CELL_0 && FILD[2][i] == CELL_0) {
                System.out.println(WIN_0);
                return true; // Победа 0
            }
        }
        // Проверка диагоналей
        if (FILD[0][0] == CELL_0 && FILD[1][1] == CELL_0 && FILD[2][2] == CELL_0) {
            System.out.println(WIN_0);
            return true; // Победа 0
        }
        if (FILD[0][2] == CELL_0 && FILD[1][1] == CELL_0 && FILD[2][0] == CELL_0) {
            System.out.println(WIN_0);
            return true;
        }
        return false;
    }

    public static boolean checkDraw() {
        // Проверяем, заполнены ли все ячейки
        for (char[] row : FILD) {
            for (char cell : row) {
                if (cell == CELL_EMPTY) {
                    return false;
                }
            }
        }
        System.out.println("Ничья!");
        return true; // Ничья
    }

    public static void playerTurn() {
        System.out.println();
        System.out.println();

        System.out.println("Выберите координату по горизонтали (1-3): ");
        int cordinates1 = SCANNER.nextInt();
        System.out.println("Выберите координату по вертикали (1-3): ");
        int cordinates2 = SCANNER.nextInt();

        // Проверка на валидность ввода
        if (cordinates1 < 1 || cordinates1 > 3 || cordinates2 < 1 || cordinates2 > 3) {
            System.out.println("Некорректные координаты. Попробуйте снова.");
            return;
        }


        if (FILD[cordinates1 - 1][cordinates2 - 1] == CELL_EMPTY) {
            FILD[cordinates1 - 1][cordinates2 - 1] = CELL_X;
        } else {
            System.out.println("Эта ячейка уже занята. Попробуйте снова.");
        }
    }

    public static void botTurn() {
        while (true) {
            int randomNum = RANDOM.nextInt(3);
            int randomSecondNum = RANDOM.nextInt(3);
            if (FILD[randomNum][randomSecondNum] == CELL_EMPTY) {
                FILD[randomNum][randomSecondNum] = CELL_0;
                break;
            }
        }
    }
}