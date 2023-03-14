package task4polimorth;

import java.util.Arrays;

public class Competition {

    public static void main(String[] args) {

        Participant robot = new Robot("Android", 10000, 1);
        Participant human = new Human("John", 6000, 4);
        Participant cat = new Cat("Barsik", 1000, 2);

        Obstacle runningTrack = new RunningTrack("RunningTrack", 5000);
        Obstacle wall = new Wall("Wall", 3);

        Participant[] participants = {robot, human, cat};
        Obstacle[] obstacles = {runningTrack, wall};

        competition(participants, obstacles);
    }

    public static void competition(Participant[] participants, Obstacle[] obstacles) {
        for (Participant participant : participants) {
            for (Obstacle obstacle : obstacles) {
                if (!(obstacle.overcome(participant))) {
                    if (isLastObstacle(obstacles, obstacle)) {
                        System.out.println(participant.getName() + " Unsuccessfully complete last obstacle");
                        System.out.println();
                    } else {
                        System.out.println(participant.getName() + " -is OUT from competition");
                    }
                    System.out.println();
                    break;
                }
                if (isLastObstacle(obstacles, obstacle)) {
                    System.out.println(participant.getName() + " has successfully complete all obstacles. Congratulations");
                    System.out.println();
                }
            }
        }
    }

    public static boolean isLastObstacle(Obstacle[] obstacles, Obstacle obstacle) {
        boolean isLastObstacle = false;
        int index = Arrays.asList(obstacles).indexOf(obstacle);
        if (index == obstacles.length - 1) {
            isLastObstacle = true;
        }
        return isLastObstacle;
    }
}
