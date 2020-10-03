package parttwo.homeworkone;

public class Human implements Contestants{
    private String name;
    private int runLength;
    private int jumpHeight;

    public Human(String name, int runLength, int jumpHeight) {
        this.name = name;
        this.runLength = runLength;
        this.jumpHeight = jumpHeight;
    }

    @Override
    public int canRun() {
        return runLength;
    }

    @Override
    public int canJump() {
        return jumpHeight;
    }

    @Override
    public String getName() {
        return name;
    }
}
