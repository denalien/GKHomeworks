package parttwo.homeworktwo;

public class ArrayHandler {


    public static int checkNSum(String[][] stringArray) throws MyArraySizeException, MyArrayDataException {
        if (stringArray.length != 4) {
            throw new MyArraySizeException("Длина массива не равна 4!");
        }
        for (int i = 0; i < stringArray.length; i++) {
            if (stringArray[i].length != 4) {
                throw new MyArraySizeException("Ширина массива не равна четырем по индексу " + i);
            }
        }

        int sum = 0;

        for (int i = 0; i < stringArray.length; i++) {
            for (int j = 0; j < stringArray[i].length; j++) {

                try {
                    sum += Integer.parseInt(stringArray[i][j]);
                } catch (NumberFormatException e) {
                    System.out.println("Сумма до ошибки равна " + sum);
                    throw new MyArrayDataException("Не содержит число в позиции " + i + " и " + j);

                }
            }
        }
        return sum;

    }

    public static void main(String[] args) {

        String[][] stringArray44 = new String[4][4];
        String[][] stringArray45 = new String[4][5];
        String[][] stringArray54 = new String[5][4];

        for (int i = 0; i < stringArray44.length; i++) {
            for (int j = 0; j < stringArray44[i].length; j++) {
                if (i > 1 && i == j) {
                    stringArray44[i][j] = "text";
                } else {
                    stringArray44[i][j] = "" + (i + j);
                }
            }
        }

        try {
            System.out.println(checkNSum(stringArray54));
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(checkNSum(stringArray45));
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(checkNSum(stringArray44));
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();

        }

    }
}
