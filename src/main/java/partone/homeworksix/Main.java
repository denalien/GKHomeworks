package partone.homeworksix;

public class Main {
    public static void main(String[] args) {
        Animal cat = new Cat();
        Animal dog = new Dog();

        cat.run(100);
        cat.run(300);
        cat.swim(10);
        cat.jump(3);

        System.out.println("");

        dog.run(300);
        dog.run(600);
        dog.swim(10);
        dog.jump(3);

        System.out.println("");

        Animal anotherDog = new Dog(700,15,5);
        anotherDog.run(600);
        anotherDog.jump(5);
    }
}
