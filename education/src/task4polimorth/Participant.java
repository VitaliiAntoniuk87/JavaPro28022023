package task4polimorth;

public abstract class Participant {

    private final String name;
    private int runLimit;
    private int jumpLimit;

    public Participant(String name, int runLimit, int jumpLimit) {
        this.name = name;
        if (runLimit > 0 && jumpLimit > 0) {
            this.runLimit = runLimit;
            this.jumpLimit = jumpLimit;
        } else {
            System.out.println("RunLimit and jumpLimit should be higher than 0");
        }
    }

    public int getRunLimit() {
        return runLimit;
    }

    public int getJumpLimit() {
        return jumpLimit;
    }

    public String getName() {
        return name;
    }

    public void run() {
        System.out.println(getName() + " is running...");
    }


    public void jump() {
        System.out.println(getName() + " is jumping...");
    }
}
