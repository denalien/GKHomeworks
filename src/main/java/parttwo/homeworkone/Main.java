package parttwo.homeworkone;

public class Main {
    public static void main(String[] args) {

        Crossable[] participants = new Crossable[3];
        participants[0] = new Human(100,2);
        participants[1] = new Cat(50,3);
        participants[2] = new Robot(150,1);

        Obstacle[] obstacles = new Obstacle[5];
        for (int i = 0; i <obstacles.length ; i++) {
            int n = (int)(Math.random() * 2);
            switch (n){
                case 0: obstacles[i] = new RunPath((int)(Math.random()*151));
                break;
                case 1: obstacles[i] = new Wall((int)(Math.random()*4));
                break;
            }
        }

        for (Obstacle obs: obstacles
             ) {
            System.out.println("Obstacle is " + obs.toString());
            if (obs instanceof Wall){
                System.out.println("Wall height is " + obs.obstacleLevel);
            } else {
                System.out.println("RunPath length is " + obs.obstacleLevel);
            }
        }

        System.out.println("");

        for (Crossable prts: participants
        ) {
            boolean isClear = true;
            System.out.println(prts.toString() + " стартует!");
            for (Obstacle obs: obstacles
            ) {
                if (isClear){
                    if (obs instanceof Wall){
                        isClear = prts.jump(obs);
                    } else {
                        isClear = prts.run(obs);
                    }
                } else {
                    System.out.println(prts.toString() + " сошел с дистанции.");
                    break;
                }
            }
            if(isClear){
                System.out.println(prts.toString() + " прошел полосу препятствий.");
            }
            System.out.println("");

        }


    }
}
