package partone.homeworkseven;

public class Main {
    public static void main(String[] args) {
        Plate plate = new Plate(50);
        Cat[] cats = new Cat[3];
        cats [0] = new Cat("Барсик",3);
        cats [1] = new Cat("Пончик",5);
        cats [2] = new Cat("Куксик", 1);

        for (Cat cat : cats
             ) {
            cat.lookAtCat();
        }

        for (Cat cat : cats) {
            cat.playWithCat();
        }
        for (Cat cat : cats) {
            cat.playWithCat();
        }
        for (Cat cat : cats) {
            cat.playWithCat();
        }

        for (Cat cat : cats) {
            cat.lookAtCat();
        }

        for (Cat cat: cats
             ) {
            cat.goEat(plate);
        }
        plate.lookAtPlate();
        plate.refill();

        for (Cat cat : cats
             ) {
            cat.goEat(plate);
        }

        plate.lookAtPlate();

        for (Cat cat: cats
             ) {
            cat.lookAtCat();
        }

        for (Cat cat: cats
             ) {
            cat.goEat(plate);
        }
    }
}
