package homeworkthree;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1. Написать программу, которая загадывает случайное число от 0 до 9,
        // и пользователю дается 3 попытки угадать это число. При каждой попытке компьютер должен сообщить больше
        // ли указанное пользователем число чем загаданное, или меньше. После победы или проигрыша выводится запрос –
        // «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).

        int answer;
        Scanner sc = new Scanner(System.in);
        do {
            int secret = (int) (Math.random() * 10);
            System.out.println("Ваша задача - угатать число от 0 до 9. У вас три попытки.");

            int shot;
            for (int i = 0; i < 4; i++) {
                if (i == 3) {
                    System.out.println("Вы проиграли!");
                    break;
                }
                System.out.println("Осталось " + (3 - i) + " попытки.");
                shot = sc.nextInt();
                if (shot == secret) {
                    System.out.println("Вы угадали!");
                    break;
                } else if (shot < secret) {
                    System.out.println("Загаданное число больше.");
                    continue;
                } else {
                    System.out.println("Загаданное число меньше.");
                    continue;
                }

            }
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");

            while (true) {

                answer = sc.nextInt();
                if (answer == 0 || answer == 1) {
                    break;
                }
                System.out.println("Некорректный ввод!");
            }
        } while (answer != 0);

        /*
        2 * Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado",
        "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive",
         "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
         При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
        сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь. Если слово не угадано,
        компьютер показывает буквы которые стоят на своих местах.
        apple – загаданное
        apricot - ответ игрока
        ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
        Для сравнения двух слов посимвольно, можно пользоваться:
        String str = "apple";
        str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
        Играем до тех пор, пока игрок не отгадает слово
        Используем только маленькие буквы
         */

        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"};
        String word = words[(int) (Math.random() * words.length)];
        System.out.println("Угадайте слово!");
        while (true) {

            sc.nextLine(); // чтобы сканнер не глотал перевод строки из прошлого задания
            String shot = sc.nextLine();
            char[] showAnswer = {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'};
            if (shot.equals(word)) {
                System.out.println("Вы угадали!");
                break;
            } else {
                for (int i = 0; i < shot.length(); i++) {
                    if (shot.charAt(i) == word.charAt(i)) {
                        showAnswer[i] = word.charAt(i);

                    }
                    if (i == word.length() - 1) {
                        break;
                    }
                }
                System.out.print(showAnswer);
                System.out.println(" \nПопробуйте еще раз!");
            }

        }
    }

}


