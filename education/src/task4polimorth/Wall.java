package task4polimorth;

public class Wall extends Obstacle {

    public Wall(String name, int obstacleValue) {
        super(name, obstacleValue);
    }

    @Override
    public boolean overcome(Participant participant) {
        boolean isSuccessful = false;
        participant.jump();
        if (participant.getJumpLimit() > this.getObstacleValue()) {
            System.out.println(participant.getName() + " has successfully overcame "
                    + this.getName() + " with height " + this.getObstacleValue());
            isSuccessful = true;
        } else {
            System.out.println(participant.getName() + " has failed his overcoming "
                    + this.getName() + " with height " + this.getObstacleValue()
                    + ". Overcame only " + participant.getJumpLimit());
        }
        return isSuccessful;
    }
}
