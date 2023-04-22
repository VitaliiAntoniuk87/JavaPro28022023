package hometask10;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Parser {

    private final Map<String, Integer> filteredWords = new HashMap<>();


    public void calcWordStatisticFromBook() {
        boolean isBookNameCorrect = false;
        while (!isBookNameCorrect) {
            String bookName = getBookName();
            try (BufferedReader reader = new BufferedReader(new FileReader("src/" + bookName + ".txt"))) {
                reader.lines()
                        .flatMap(a -> Arrays.stream(a.split("[^a-zA-Z]")))
                        .filter(e -> e.length() > 2)
                        .forEach(e -> filteredWords.merge(e, 1, (old, current) -> old + 1));
                isBookNameCorrect = true;
            } catch (IOException e) {
                System.err.println("Book not found. Please try again.");
            }
        }
    }

    private static String getBookName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter book name: ");
        return scanner.nextLine();
    }

    public void printWordStatisticToBookAndConsole() throws FileWritException {
        String bookName = getBookName();
        int uniqueWords = filteredWords.keySet().size();
        List<Map.Entry<String, Integer>> entries = filteredWords.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(10)
                .toList();
        try (PrintWriter printWriter = new PrintWriter("src/" + bookName + ".txt")) {
            for (Map.Entry<String, Integer> entry : entries) {
                printWriter.println(entry.getKey() + " --> " + entry.getValue());
                System.out.println(entry.getKey() + " --> " + entry.getValue());
                printWriter.flush();
            }
            printWriter.append("Unique Words count = ").append(String.valueOf(uniqueWords));
            System.out.println(("Unique Words count = " + uniqueWords));


        } catch (FileNotFoundException e) {
            throw new FileWritException("Unexpected exception. Try later");
        }

    }


    @Override
    public String toString() {
        return "Parser{" +
                "filteredWords=" + filteredWords +
                '}';
    }
}
