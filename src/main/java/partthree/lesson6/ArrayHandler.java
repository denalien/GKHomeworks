package partthree.lesson6;

import java.util.Arrays;

public class ArrayHandler {
    public static void main(String[] args) {

    }

    public int[] arraySplitter(int[] arr){
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 4){
                index = i;
            }
        }
        if(index == -1) {
            throw new RuntimeException("Массив не содержит цифру 4");
        }

        return Arrays.copyOfRange(arr,index + 1,arr.length);
    }

    public boolean arrayChecker(int[] arr){
        boolean checked = false;
        boolean hasOne = false;
        boolean hasFour = false;

        for (int val: arr
             ) {
            if(val == 1){
                hasOne = true;
                checked = true;
            } else if (val == 4) {
                hasFour = true;
                checked = true;
            } else {
                checked = false;
                break;
            }
        }
        return checked & hasFour & hasOne;
    }
}
