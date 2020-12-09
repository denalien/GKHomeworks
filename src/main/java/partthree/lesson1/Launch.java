package partthree.lesson1;


import java.util.ArrayList;

public class Launch {
    public static void main(String[] args) {
        GenericUtil<Integer> arr = new GenericUtil<>(0,1,2,3,4,5,6);
        arr.swap(0,3);

        GenericUtil<String> arr1 = new GenericUtil<>("one","two","three","four");
        System.out.println(arr1.toList());

        Box<Apple> appleBox = new Box<>(new ArrayList<>());
        appleBox.add(new Apple());
        System.out.println(appleBox.getWeight());

        appleBox.add(new Apple());
        appleBox.add(new Apple());

        Box<Orange> orangeBox = new Box<>(new ArrayList<>());
        orangeBox.add(new Orange());
        orangeBox.add(new Orange());

        System.out.println(appleBox.compare(orangeBox));

        Box<Orange> orangeBox1 = new Box<>(new ArrayList<>());
        orangeBox1.add(new Orange());

        orangeBox1.drop(orangeBox);

        System.out.println(orangeBox.getWeight());

    }
}
