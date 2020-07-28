package homeworkfour;

import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static char[][] map;
    public static int DOTS_TO_WIN;
    public static int SIZE;
    public final static char DOT_X = 'X';
    public final static char DOT_O = 'O';
    public final static char EMPTY_DOT = '•';
    public static int choice;

    public static void main(String[] args) {
        System.out.println("Добро пожаловать в игру крестики-нолики!");
        System.out.println("Выберите размер поля. (0 - 3х3 , 1 - 5х5)");
        do {
            choice = sc.nextInt();
            sc.nextLine();
            if (choice == 0) {
                SIZE = 3;
                DOTS_TO_WIN = 3;
            } else if (choice == 1) {
                SIZE = 5;
                DOTS_TO_WIN = 4;
            } else {
                System.out.println("Некорректный ввод!");
            }
        } while ((choice == 1) == (choice == 0));
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (isWin(DOT_X)) {
                System.out.println("YOU WIN!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Game ended in draw");
                break;
            }
            aITurn();
            printMap();
            if (isWin(DOT_O)) {
                System.out.println("YOU LOSE(((((((!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Game ended in draw");
                break;
            }
        }
    }

    private static boolean isMapFull() {
        int count = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == EMPTY_DOT) {
                    count++;
                }
            }
        }
        return count == 0;
    }

    private static void aITurn() {
        int x = SIZE / 2;
        int y = SIZE / 2;

        if (choice == 0) {
            if (map[SIZE / 2][SIZE / 2] == EMPTY_DOT) {
                map[y][x] = DOT_O;
            } else if (wayToWin(DOT_O) != null) {
                x = wayToWin(DOT_O)[1];
                y = wayToWin(DOT_O)[0];
                map[y][x] = DOT_O;
            } else if (wayToWin(DOT_X) != null) {
                x = wayToWin(DOT_X)[1];
                y = wayToWin(DOT_X)[0];
                map[y][x] = DOT_O;
            } else {
                do {
                    x = (int) (Math.random() * SIZE);
                    y = (int) (Math.random() * SIZE);
                } while (!isTurnValid(x, y));
            }
        } else {
            if (blockMe(DOT_X) != null){
            x = blockMe(DOT_X)[1];
            y = blockMe(DOT_X)[0];
            } else {
                do {
                    x = (int) (Math.random() * SIZE);
                    y = (int) (Math.random() * SIZE);
                } while (!isTurnValid(x, y));
            }
        }
        map[y][x] = DOT_O;

    }

    private static boolean isTurnValid(int x, int y) {
        if (x < 0 || x > SIZE - 1 || y < 0 || y > SIZE - 1) {
            return false;
        }
        if (map[y][x] == EMPTY_DOT) {
            return true;
        }
        return false;
    }

    private static void humanTurn() {
        int x, y;
        System.out.println("Please input dot coordinates, in format x y");
        do {
            x = sc.nextInt();
            y = sc.nextInt();
        } while (!isTurnValid(x - 1, y - 1));
        map[y - 1][x - 1] = DOT_X;
    }

    private static void printMap() {
        for (int i = 0; i < SIZE; i++) {
            System.out.print(" " + (i + 1));
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + "");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = EMPTY_DOT;
            }
        }
    }

    private static boolean isWin(char symbol) {
       /* if (map[0][0] == symbol && map[0][1] == symbol && map[0][2] == symbol){
            return true;
        }
        if (map[1][0] == symbol && map[1][1] == symbol && map[1][2] == symbol){
            return true;
        }
        if (map[2][0] == symbol && map[2][1] == symbol && map[2][2]== symbol){
            return true;
        }
        if (map[0][0] == symbol && map[1][0] == symbol && map[2][0]== symbol){
            return true;
        }
        if (map[0][1] == symbol && map[1][1] == symbol && map[2][1]== symbol){
            return true;
        }
        if (map[0][2] == symbol && map[1][2] == symbol && map[2][2]== symbol){
            return true;
        }
        if (map[0][0] == symbol && map[1][1] == symbol && map[2][2]== symbol){
            return true;
        }
        if (map[0][2] == symbol && map[1][1] == symbol && map[2][0]== symbol){
            return true;
        }*/
        // Новый метод проверяет наличие одинаковых символов на линиях игрового поля, идущих подряд
        // Проверка горизонталей
        boolean checkWin = false;
        int dots = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length && dots < DOTS_TO_WIN; j++) {
                if (map[i][j] == symbol) {
                    checkWin = true;
                    dots += 1;
                } else {
                    checkWin = false;
                    dots = 0;
                }
            }
            if (checkWin && dots == DOTS_TO_WIN) {
                return true;
            }
        }

        // Проверка вертикалей
        dots = 0;
        for (int i = 0; i < map[i].length; i++) {
            checkWin = true;
            for (int j = 0; j < map.length && dots < DOTS_TO_WIN; j++) {
                if (map[j][i] == symbol) {
                    checkWin = true;
                    dots += 1;
                } else {
                    checkWin = false;
                    dots = 0;
                }
            }
            if (checkWin && dots == DOTS_TO_WIN) {
                return true;
            }
            if (i == map[i].length - 1) {
                break;
            }
        }

        // Проверка диагонали
        dots = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (i == j) {
                    if (map[i][j] == symbol) {
                        checkWin = true;
                        dots += 1;
                    } else {
                        checkWin = false;
                        dots = 0;
                    }
                }
                if (dots == DOTS_TO_WIN) {
                    break;
                }
            }
        }
        if (checkWin && dots == DOTS_TO_WIN) {
            return true;
        }

        // Проверка обратной диагонали
        dots = 0;
        checkWin = true;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (i == map.length - 1 - j) {
                    if (map[i][j] == symbol) {
                        checkWin = true;
                        dots += 1;
                    } else {
                        checkWin = false;
                        dots = 0;
                    }
                }
                if (dots == DOTS_TO_WIN) {
                    break;
                }
            }
        }

        if (checkWin && dots == DOTS_TO_WIN) {
            return true;
        }

        return false;
    }

    // Метод проверяет количество одинаковых символов на линии, если остался один до победы, передает его координаты
    // Работает правильно только для поля 3х3
    private static int[] wayToWin(char symbol) {
        int x, y;
        int dots = 0;
        int dotsNear = DOTS_TO_WIN - 1;
        int[] coordinates = new int[2];

        // Проверка горизонталей на возможную победу
        for (int i = 0; i < map.length; i++) {
            dots = 0;
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == symbol) {
                    dots += 1;
                }
            }
            if (dots == dotsNear) {
                for (int j = 0; j < map[i].length; j++) {
                    if (map[i][j] == EMPTY_DOT) {
                        coordinates[0] = i;
                        coordinates[1] = j;
                        return coordinates;
                    }
                }
            }

        }

        // Проверка вертикалей
        for (int i = 0; i < map[i].length; i++) {
            dots = 0;
            for (int j = 0; j < map.length; j++) {
                if (map[j][i] == symbol) {
                    dots += 1;
                }
            }
            if (dots == dotsNear) {
                for (int j = 0; j < map.length; j++) {
                    if (map[j][i] == EMPTY_DOT) {
                        coordinates[0] = j;
                        coordinates[1] = i;
                        return coordinates;
                    }
                }
            }
            if (i == map[i].length - 1) {
                break;
            }
        }

        // Проверка диагонали
        dots = 0;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (i == j) {
                    if (map[j][i] == symbol) {
                        dots += 1;
                    }
                }
            }
        }

        if (dots == dotsNear) {
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    if (i == j) {
                        if (map[j][i] == EMPTY_DOT) {
                            coordinates[0] = i;
                            coordinates[1] = j;
                            return coordinates;
                        }
                    }
                }
            }
        }

        // Проверка обратной диагонали
        dots = 0;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (i == map.length - 1 - j) {
                    if (map[j][i] == symbol) {
                        dots += 1;
                    }
                }
            }
        }
        if (dots == dotsNear) {
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    if (i == map.length - 1 - j) {
                        if (map[j][i] == EMPTY_DOT) {
                            coordinates[0] = i;
                            coordinates[1] = j;
                            return coordinates;
                        }
                    }
                }
            }


        }
        return null;
    }

    private static int[] blockMe(char symbol) {
        int[] coordinates = new int[2];

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == symbol){
                    if (i > 0 && i < map.length - 1 && j > 0 && j < map[i].length - 1){
                        for (int k = i - 1; k < i + 2; k++) {
                            for (int l = j - 1; l < j + 2 ; l++) {
                                if (k == i && l == j) {
                                    continue;
                                }
                                if (map[k][l] == symbol){
                                    switch (i - k){
                                        case - 1:
                                            coordinates[0] = i - 1;
                                            break;
                                        case 0:
                                            coordinates[0] = i ;
                                            break;
                                        case 1:
                                            coordinates[0] = i + 1;
                                            break;
                                    }
                                    switch (j - l){
                                        case -1:
                                            coordinates[1] = j - 1;
                                            break;
                                        case 0:
                                            coordinates[1] = j;
                                            break;
                                        case 1:
                                            coordinates[1] = j + 1;
                                            break;
                                    }
                                    if(isTurnValid(coordinates[1],coordinates[0])){
                                        return coordinates;
                                    }
                                }

                            }
                        }
                    }
                }
            }
        }


        return null;
    }
}
