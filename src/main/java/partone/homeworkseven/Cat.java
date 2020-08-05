package partone.homeworkseven;

public class Cat {
    private String name;
    private int hungerLevel;
    private boolean isHungry;
    private int age;
    private int canEat;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
        canEat = age * 5;
        System.out.println("Похоже, " + name + " может съесть максимум " + canEat + " корма.");
    }


    void goEat(Plate plate){
        isHungry = hungerLevel > 0;
        System.out.println(name + ", кушать!");
        if(plate.getQuantity() > 0) {
            if(isHungry){
                if (hungerLevel < plate.getQuantity()){
                    plate.setQuantity(plate.getQuantity() - hungerLevel);
                    hungerLevel = 0;
                } else {
                    hungerLevel -= plate.getQuantity();
                    plate.setQuantity(0);
                }
                System.out.println(name + " жадно набрасывается на миску.");
            } else {
                System.out.println(name + " смотрит на вас без особого интереса.");
            }
        } else {
            System.out.println(name + " видит пустую миску и смотрит на вас обвиняющим взглядом.");
        }
    }

    void lookAtCat(){
        isHungry = hungerLevel > 0;
        if(isHungry){
            System.out.println("Наметанным глазом кошатника вы замечаете, что " + name + " мог бы съесть " + hungerLevel + " корма.");
        } else {
            System.out.println(name + " выглядит сытым.");
        }
    }

    void playWithCat(){
        if(canEat - hungerLevel > 2 * age){
            hungerLevel += age * 2;
            System.out.println("Вы играете с котиком. " + name + " немного проголодался.");
        } else {
            System.out.println(name + " царапает вас, требуя еды!");
        }
    }

}
