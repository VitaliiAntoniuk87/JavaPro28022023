package hometask10;

import java.io.*;
import java.util.*;


public class Parser {

    private final Map<String, Integer> filteredWords = new HashMap<>();


    public void calcWordStatisticFromBook() {
        String bookName = getBookName();
        List<String> textContainer = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("src/" + bookName + ".txt"))) {
            String line = reader.readLine();
            while (line != null) {
                textContainer.addAll(Arrays.asList(line.split("[^a-zA-Z]")));
                line = reader.readLine();
            }
            for (String word : textContainer) {
                if (word.length() > 2) {
                    if (filteredWords.containsKey(word)) {
                        filteredWords.replace(word, filteredWords.get(word) + 1);
                    } else {
                        filteredWords.put(word, 1);
                    }
                }
            }

        } catch (IOException e) {
            System.err.println("Book not found. Plz try again.");
            calcWordStatisticFromBook();
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
