package hometask10;

public class ParserMain {

    public static void main(String[] args) {

        Parser parser = new Parser();

        parser.calcWordStatisticFromBook();

        System.out.println();
        try {
            parser.printWordStatisticToBookAndConsole();
        } catch (FileWritException e) {
            System.err.println("Write procedure went wrong. Try again later");
        }
    }
}
