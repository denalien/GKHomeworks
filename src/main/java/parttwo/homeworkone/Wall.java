package parttwo.homeworkone;

public class Wall implements Obstacle{
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public boolean doCross(Contestants contestants) {
        return contestants.canJump() >= height;
    }
}
