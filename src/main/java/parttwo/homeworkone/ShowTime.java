package parttwo.homeworkone;

public class ShowTime {
    public static void main(String[] args) {

        Contestants[] contestants = new Contestants[3];
        contestants[0] = new Cat("Saimon",10,2);
        contestants[1] = new Human("Petrovich",5,1);
        contestants[2] = new Robot("QT-4-U",15,3);

        Obstacle[] obstacles = new Obstacle[6];
        obstacles[0] =new Wall(1);
        obstacles[1] =new Path(5);
        obstacles[2] =new Wall(2);
        obstacles[3] =new Path(10);
        obstacles[4] =new Wall(3);
        obstacles[5] =new Path(15);

        for (Contestants c: contestants
             ) {
            rsgo(c,obstacles);
        }


    }
    private static void rsgo(Contestants contestant, Obstacle... obstacles){
        boolean haveCrossed = true;
        for (Obstacle o: obstacles
        ) {
            if (haveCrossed){
                haveCrossed = haveCrossed && o.doCross(contestant);
            }
        }
        if (haveCrossed){
            System.out.println("Участник " + contestant.getName() + " прошел полосу препятствий");
        } else {
            System.out.println("Участник " + contestant.getName() + " сошел с дистанции");
        }

    }
}
