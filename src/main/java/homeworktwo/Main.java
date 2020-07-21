package homeworktwo;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        // Первое задание
        // Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
        // С помощью цикла и условия заменить 0 на 1, 1 на 0;

        int[] ar = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        for (int i = 0; i < ar.length; i++){
            if (ar[i] == 1){
                ar[i] = 0;
            } else {
                ar[i] = 1;
            }
            System.out.print(ar[i] + " ");
        }

        System.out.println("\n");

        // Второе задание
        // Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;

        int[] arr = new int[8];
        for (int i = 0; i < arr.length; i++){
            arr[i] = 3 * i;
            System.out.print(arr[i] + " ");
        }

        System.out.println("\n");

        // Третье задание
        // Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2

        int[] arrray = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1} ;
        for (int i = 0; i < arrray.length; i++) {
            if (arrray[i] < 6){
                arrray[i] *= 2;
            }
            System.out.print(arrray[i] + " ");
        }

        System.out.println("\n");

        // Четвертое задание
        // Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
        // и с помощью цикла(-ов) заполнить его диагональные элементы единицами

        int[][] ar2 = new int[5][5];
        for (int i = 0; i < ar2.length; i++) {
            for (int j = 0; j < ar2[i].length; j++) {
                if (j == i) {
                    ar2[i][j] = 1;
                } else if (j == ar2[i].length - 1 - i){
                    ar2[i][j] = 1;
                }

                System.out.print(ar2[i][j] + " ");
            }
            System.out.println("");
        }

        System.out.println("\n");

        // Пятое задание
        // Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета)

        // Инициализируем массив и заполняем случайными данными; смотрим, что получилось
        ar = new int[10];
        for (int i = 0; i < ar.length; i++) {
            ar[i] = (int) (Math.random() * 10);
            System.out.print(ar[i] + " ");
        }

        System.out.println("");

        // Находим максимум и минимум
        int max = ar[0];
        int min = ar[0];

        for (int i = 0; i < ar.length; i++) {
            if (max < ar[i]) max = ar[i];
            if (min > ar[i]) min = ar[i];
        }
        System.out.println("Максимальное значение в массиве - " + max);
        System.out.println("Минимальное значение в массиве - " + min);

        System.out.println("\n");

        // Шестое задание
        // Написать метод, в который передается не пустой одномерный целочисленный массив,
        // метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
        // Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
        // граница показана символами ||, эти символы в массив не входят.

        // Инициализируем массив и заполняем случайными данными; смотрим, что получилось
        ar = new int[10];
        for (int i = 0; i < ar.length; i++) {
            ar[i] = (int) (Math.random() * 10);
            System.out.print(ar[i] + " ");
        }

        System.out.println("");

        if(checkBalance(ar)){
            System.out.println("Массив содержит равные суммы");
        } else {
            System.out.println("Массив не содержит равные суммы");
        }

        System.out.println("\n");

        // Седьмое задание
        // Написать метод, которому на вход подается одномерный массив и число n
        // (может быть положительным, или отрицательным), при этом метод должен сместить все элементы массива на n позиций.
        // Элементы смещаются циклично. Для усложнения задачи нельзя пользоваться вспомогательными массивами.
        // Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1]
        // при n = -2 (на два влево) -> [ 6, 1, 3, 5 ]. При каком n в какую сторону сдвиг можете выбирать сами.

        // Инициализируем массив и заполняем случайными данными; смотрим, что получилось
        ar = new int[10];
        for (int i = 0; i < ar.length; i++) {
            ar[i] = (int) (Math.random() * 10);
            System.out.print(ar[i] + " ");
        }

        System.out.println("");

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число n");
        int n = sc.nextInt();
        arrayShift(ar, n);

    }

    static boolean checkBalance(int[] ar){
        int n = 0;
        int m = 0;
        boolean result = false;

        //Циклически складываем элементы, передвигая границу
        for (int i = 0; i < ar.length; i++) {
            n += ar[i];

            for (int j = i + 1; j < ar.length; j++) {
                m += ar[j];
            }
            // Если суммы оказываются равны выдаем сообщение о нахождении границы, где суммы равны
            if(n == m) {
                result = true;
                System.out.println("");
                System.out.println("Граница проходит на элементе " + i);
                System.out.println("Суммы равны " + n);
            } else {
                m = 0;
            }

        }
        return result;

    }

    static void arrayShift(int[] ar, int n){
        // Вместо использования вспомогательного массива будем использовать вспомогательную переменную
        // В этом случае придется циклически сдвигать массив на один элемент и повторять n раз
        int m;
        // При отрицательном n для уменьшения кода будем сдвигать в ту же сторону, но на другое число элементов
        if (n < 0) n = ar.length + n; // Использовал строчные выражения до того, как посмотрел все видеоуроки, в дальнейшем буду использовать блоки кода по Вашей рекомендации

        for (int i = 0; i < n; i++) {

            m = ar[ar.length - 1];

            for (int j = ar.length - 1; j > 0; j--) {

                ar[j] = ar [j - 1];

            }
            ar[0] = m;

            }

        for (int i = 0; i < ar.length; i++) {
            System.out.print(ar[i] + " ");
        }
    }

}



