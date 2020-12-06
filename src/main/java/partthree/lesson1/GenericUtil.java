package partthree.lesson1;

import java.util.ArrayList;
import java.util.Arrays;

public class GenericUtil<T> {
    private T[] obj;

    public GenericUtil(T... obj) {
        this.obj = obj;
    }

    public void swap(int src, int dest){
        T buf;
        if(src < obj.length && src >=0 && dest < obj.length && dest >= 0){
            buf = obj[dest];
            obj[dest] = obj[src];
            obj[src] = buf;
            System.out.println(Arrays.toString(obj));
        } else {
            System.out.println("Incorrect input!");
        }
    }
    public ArrayList<T> toList(){
        ArrayList<T> list = new ArrayList<>(Arrays.asList(obj));
        return list;

    }
}
