package parttwo.homeworkone;

public abstract class Obstacle {
    int obstacleLevel;

    public Obstacle(int obstacleLevel) {
        this.obstacleLevel = obstacleLevel;
    }

    @Override
    public abstract String toString();
}
