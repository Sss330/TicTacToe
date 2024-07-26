import java.util.Random;
import java.util.Scanner;

class test {


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
            X_Turn();
            checkGameStatus();

                botTurn();
                checkGameStatus();

        }
    }
    public static void printField() {
        //отпечатка координат
        for (int i = 0; i < FILD[0].length; i++) {
            System.out.print("  " + (i + 1));
        }
        //отпечатка поля
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
        check0Won();
        checkX_won();
        checkDraw ();
        return false;
    }
    public static boolean checkX_won() {
        // Проверка всех возможных выигрышных комбинаций для X
        for (int i = 0; i < 3; i++) {
            // Проверка горизонталей
            if (FILD[i][0] == CELL_X && FILD[i][1] == CELL_X && FILD[i][2] == CELL_X) {
                System.out.println(WIN_X);
                return true; // Победа X
            }
            // Проверка вертикалей
            if (FILD[0][i] == CELL_X && FILD[1][i] == CELL_X && FILD[2][i] == CELL_X) {
                System.out.println(WIN_X);
                return true; // Победа X
            }
        }
        // Проверка диагоналей
        if (FILD[0][0] == CELL_X && FILD[1][1] == CELL_X && FILD[2][2] == CELL_X) {
            System.out.println(WIN_X);
            return true; // Победа X
        }
        if (FILD[0][2] == CELL_X && FILD[1][1] == CELL_X && FILD[2][0] == CELL_X) {
            System.out.println(WIN_X);
            return true; // Победа X
        }
        return false; // Нет победы
    }

    public static boolean check0Won() {
        // Проверка всех возможных выигрышных комбинаций для 0
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
            return true; // Победа 0
        }
        return false; // Нет победы
    }



    public static boolean checkDraw() {
        // Проверяем, есть ли победитель
        if (checkX_won() || check0Won()) {
            return false; // Если есть победитель, ничьей нет
        }
        // Проверяем, заполнены ли все ячейки
        for (char[] chars : FILD) {
            for (char aChar : chars) {
                if (aChar == CELL_EMPTY) {
                    return false; // Если есть пустая ячейка, игра продолжается
                }
            }
        }
        return true ; // Ничья
    }
    //ход игрока
    public static void X_Turn() {
        System.out.println();
        System.out.println();

        System.out.println("выбирите координату по горизонтали: ");
        int cordinates1 = SCANNER.nextInt();
        System.out.println("выбирите координату по верикали: ");
        int cordinates2 = SCANNER.nextInt();

       if (FILD[cordinates1 - 1][cordinates2 - 1] != CELL_0 )
        FILD[cordinates1 - 1][cordinates2 - 1] = CELL_X;
        else{
           System.out.println("эта ячейка занята");
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
