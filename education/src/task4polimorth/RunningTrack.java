package task4polimorth;

public class RunningTrack extends Obstacle {

    public RunningTrack(String name, int obstacleValue) {
        super(name, obstacleValue);
    }

    @Override
    public boolean overcome(Participant participant) {
        boolean isSuccessful = false;
        participant.run();
        if (participant.getRunLimit() > this.getObstacleValue()) {
            System.out.println(participant.getName() + " has successfully overcame "
                    + this.getName() + " on distance " + this.getObstacleValue());
            isSuccessful = true;
        } else {
            System.out.println(participant.getName() + " has failed his overcoming "
                    + this.getName() + " on distance " + this.getObstacleValue()
                    + ". Overcame only " + participant.getRunLimit());
        }
        return isSuccessful;
    }
}
