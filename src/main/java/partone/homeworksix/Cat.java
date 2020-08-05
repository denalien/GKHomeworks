package partone.homeworksix;

public class Cat extends Animal {

    int canRun = 200;
    int canSwim = 0;
    int canJump = 3;

    public Cat(int canRun, int canSwim, int canJump) {
        this.canRun = canRun;
        this.canSwim = canSwim;
        this.canJump = canJump;
    }

    public Cat() {
    }

    @Override
    boolean run(int length) {
        if(length > this.canRun){
            System.out.println("Can't do this!");
            return false;
        } else {
            System.out.println("Cat is running");
            return true;
        }
    }

    @Override
    boolean swim(int lenght) {
        System.out.println("Cat is drowning! Why did you do this!?");
        return false;
    }

    @Override
    boolean jump(int height) {
        if(height > this.canJump){
            System.out.println("Can't do this!");
            return false;
        } else {
            System.out.println("Cat is jumping");
            return true;
        }
    }
}
