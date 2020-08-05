package partone.homeworksix;

public abstract class Animal {

    int canRun;
    int canSwim;
    int canJump;

    public Animal(int canRun, int canSwim, int canJump) {
        this.canRun = canRun;
        this.canSwim = canSwim;
        this.canJump = canJump;
    }

    public Animal() {
    }

    boolean run(int length) {
        if(length > canRun){
            System.out.println("Can't do this!");
            return false;
        } else {
            System.out.println("Animal is running");
            return true;
        }

    }
    boolean swim(int lenght) {
        if(lenght > canSwim){
            System.out.println("Can't do this!");
            return false;
        } else {
            System.out.println("Animal is swimming");
            return true;
        }
    }
    boolean jump(int height) {
        if(height > canJump){
            System.out.println("Can't do this!");
            return false;
        } else {
            System.out.println("Animal is jumping");
            return true;
        }
    }

}
