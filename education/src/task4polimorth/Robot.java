package task4polimorth;

public class Robot extends Participant {

    public Robot(String name, int runLimit, int jumpLimit) {
        super(name, runLimit, jumpLimit);
        this.setRunLimit(0);
    }

}
