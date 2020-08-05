package parttwo.homeworkone;

public class Human implements Crossable{

    int runStamina;
    int jumpStamina;

    public Human(int runStamina, int jumpStamina) {
        this.runStamina = runStamina;
        this.jumpStamina = jumpStamina;
    }

    @Override
    public boolean run(Obstacle runPath) {
        if (runPath.obstacleLevel > runStamina){
            System.out.println("Препятствие " + runPath.toString() + " длиной " + runPath.obstacleLevel + " непреодолимо");
            return false;
        } else {
            System.out.println("Препятствие " + runPath.toString() + " пройдено");
            return true;
        }
    }

    @Override
    public boolean jump(Obstacle wall) {
        if (wall.obstacleLevel > jumpStamina){
            System.out.println("Препятствие " + wall.toString() + " высотой " + wall.obstacleLevel + " непреодолимо");
            return false;
        } else {
            System.out.println("Препятствие " + wall.toString() + " пройдено");
            return true;
        }
    }

    @Override
    public String toString() {
        return "Human";
    }
}
