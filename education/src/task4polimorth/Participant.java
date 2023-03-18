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
        } else if (runLimit < 0 && jumpLimit < 0) {
            System.out.println("RunLimit and jumpLimit should have positive value");
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

    public void setRunLimit(int runLimit) {
        this.runLimit = runLimit;
    }

    public void setJumpLimit(int jumpLimit) {
        this.jumpLimit = jumpLimit;
    }

    public void run() {
        if (getRunLimit() == 0) {
            System.out.println(getName() + " can't run ((");
        } else if (getRunLimit() > 0) {
            System.out.println(getName() + " is running...");
        }
    }


    public void jump() {
        if (getJumpLimit() == 0) {
            System.out.println(getName() + " can't run ((");
        } else if (getJumpLimit() > 0) {
            System.out.println(getName() + " is running...");
        }
    }
}
