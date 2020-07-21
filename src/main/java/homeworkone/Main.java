package homeworkone;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Второе задание:
        // Создать переменные всех пройденных типов данных, и инициализировать их значения
        byte bt = 127;
        short sh = 32767;
        int in = 2147483647;
        long ln = 9223372036854775807L;
        float fl = 152.26f;
        double db = 1456.564;
        char ch = 'c';
        boolean bool = true;

        // Третье задание:
        // Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,
        // где a, b, c, d – входные параметры этого метода
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число a");
        float a = sc.nextFloat();
        System.out.println("Введите число b");
        float b = sc.nextFloat();
        System.out.println("Введите число c");
        float c = sc.nextFloat();
        System.out.println("Введите число d");
        float d = sc.nextFloat();

        float result = mathFunc(a,b,c,d);
        System.out.println("Результат выражения равен " + result);

        // Четвертое задание:
        // Написать метод, принимающий на вход два числа, и проверяющий, что их сумма лежит в пределах
        // от 10 до 20(включительно), если да – вернуть true, в противном случае – false;

        System.out.println("Введите первое число");
        int firstInt = sc.nextInt();

        System.out.println("Введите второе число");
        int secondInt = sc.nextInt();

        if (checkSumm(firstInt, secondInt)) {
            System.out.println("Сумма чисел находится в пределах от 10 до 20");
        } else {
            System.out.println("Сумма чисел выходит за пределы от 10 до 20");
        }

        // Пятое задание
        // Написать метод, которому в качестве параметра передается целое число,
        // метод должен напечатать в консоль положительное ли число передали, или отрицательное;
        // Замечание: ноль считаем положительным числом.

        System.out.println("Введите число");
        int someInt = sc.nextInt();
        isPositive(someInt);

        // Шестое задание
        // Написать метод, которому в качестве параметра передается целое число,
        // метод должен вернуть true, если число отрицательное;

        System.out.println("Введите число (опять...)");
        someInt = sc.nextInt();

        if (isNegative(someInt)){
            System.out.println("Введенное число отрицательно");
        } else {
            System.out.println("Введенное число положительно");
        }

        // Седьмое задание
        // Написать метод, которому в качестве параметра передается строка, обозначающая имя,
        // метод должен вывести в консоль сообщение «Привет, указанное_имя!»;

        System.out.println("Введите Ваше имя");
        String name = sc.next();
        hello(name);

        // Восьмое задание
        // Написать метод, который определяет является ли год високосным, и выводит сообщение в консоль.
        // Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.

        System.out.println("Введите любой год");
        int year = sc.nextInt();
        leapYear(year);

        sc.close();
    }

    static float mathFunc(float a, float b, float c, float d) {

        return a * (b + (c / d));
    }

    static boolean checkSumm(int a, int b) {
        return (a + b) >= 10 && (a + b) <= 20;
    }

    static void isPositive(int a){
        if (a < 0) {
            System.out.println("Заданное число отрицательное");
        } else {
            System.out.println("Заданное число положительное");
        }
    }

    static boolean isNegative (int a){
        return a < 0;
    }

    static void hello(String name) {
        System.out.println("Привет, " + name);
    }

    static void leapYear(int year){
        if((year % 4 == 0) && (year % 100 !=0) || (year % 400 == 0)){
            System.out.println("Этот год високосный");
        } else {
            System.out.println("Этот год не високосный");
        }
    }
}
