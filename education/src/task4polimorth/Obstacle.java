package task4polimorth;

public abstract class Obstacle {

    private final String name;
    private int obstacleValue;

    public Obstacle(String name, int obstacleValue) {
        this.name = name;
        if (obstacleValue > 0) {
            this.obstacleValue = obstacleValue;
        } else {
            System.out.println("Obstacle Value should be higher than 0");
        }
    }

    public String getName() {
        return name;
    }

    public int getObstacleValue() {
        return obstacleValue;
    }

    public abstract boolean overcome(Participant participant);
}
