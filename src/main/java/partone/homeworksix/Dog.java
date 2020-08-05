package partone.homeworksix;

public class Dog extends Animal {

    int canRun = 500;
    int canSwim = 10;
    int canJump = 1;

    public Dog(int canRun, int canSwim, int canJump) {
        this.canRun = canRun;
        this.canSwim = canSwim;
        this.canJump = canJump;
    }

    public Dog() {

    }

    @Override
    boolean run(int length) {
        if(length > this.canRun){
            System.out.println("Can't do this!");
            return false;
        } else {
            System.out.println("Dog is running");
            return true;
        }
    }

    @Override
    boolean swim(int lenght) {
        if(lenght > this.canSwim){
            System.out.println("Can't do this!");
            return false;
        } else {
            System.out.println("Dog is swimming");
            return true;
        }
    }

    @Override
    boolean jump(int height) {
        if(height > this.canJump){
            System.out.println("Can't do this!");
            return false;
        } else {
            System.out.println("Dog is jumping");
            return true;
        }
    }
}
