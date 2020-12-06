package parttwo.homeworkone;

public class Path implements Obstacle{
    private int length;

    public Path(int length) {
        this.length = length;
    }

    @Override
    public boolean doCross(Contestants contestants) {
        return contestants.canRun() >= length;
    }
}
