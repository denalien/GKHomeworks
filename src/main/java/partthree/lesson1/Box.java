package partthree.lesson1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Box<T extends Fruit> {

    private ArrayList<T> fruits;

    public Box(ArrayList<T> fruits) {
        this.fruits = fruits;
    }
    public void add(T fruit){
        fruits.add(fruit);
    }
    public float getWeight(){
        float weight;
        weight = fruits.size() * fruits.get(0).weightOfOne;
        return weight;
    }

    public boolean compare(Box box){
        return this.getWeight() - box.getWeight() < 0.00001;
    }

    public void drop(Box<T> box){
        Collections.copy(box.fruits,this.fruits);
        this.fruits.clear();
    }

}
