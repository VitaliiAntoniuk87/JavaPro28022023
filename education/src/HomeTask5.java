import java.util.*;

public class HomeTask5 {

    public static void main(String[] args) {

//        countOccurance:
        ArrayList<String> words = new ArrayList<>();
        words.add("dog");
        words.add("cat");
        words.add("rat");
        words.add("carrot");
        words.add("dog");
        words.add("dog");
        words.add("cat");
        words.add("pig");
        words.add("rat");

        System.out.println(countOccurance(words, "dog"));
        System.out.println();

//        toList:
        Integer[] arr = {1, 2, 3};
        System.out.println(toList(arr));

        System.out.println();

//        findUnique:
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            integers.add(new Random().nextInt(10));
        }
        System.out.println(integers);
        System.out.println(findUnique(integers));

        System.out.println();

//        calcOccurance:
        calcOccurance(words);

        System.out.println();

//        findOccurance:
        System.out.println(findOccurance(words));
    }

    static public int countOccurance(List<String> words, String s) {
        int counter = 0;
        for (String word : words) {
            if (word.equals(s)) {
                counter++;
            }
        }
        return counter;
    }

    static public List<Integer> toList(Integer[] numbers) {
        return new ArrayList<>(Arrays.asList(numbers));
    }

    static public List<Integer> findUnique(List<Integer> numbers) {
        List<Integer> uniqueNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            if (!uniqueNumbers.contains(number)) {
                uniqueNumbers.add(number);
            }
        }
        return uniqueNumbers;
    }

    public static void calcOccurance(List<String> words) {
        ArrayList<String> uniqueWords = toUniqueList(words);
        for (String uniqueWord : uniqueWords) {
            int counter = 0;
            for (String word : words) {
                if (uniqueWord.equals(word)) {
                    counter++;
                }
            }
            System.out.println(uniqueWord + ": " + counter);
        }
    }

    private static ArrayList<String> toUniqueList(List<String> words) {
        ArrayList<String> uniqueWords = new ArrayList<>();
        for (String word : words) {
            if (!uniqueWords.contains(word)) {
                uniqueWords.add(word);
            }
        }
        return uniqueWords;
    }

    public static List<NameAndOccurance> findOccurance(List<String> words) {
        ArrayList<String> uniqueWords = toUniqueList(words);
        ArrayList<NameAndOccurance> list = new ArrayList<>();
        for (String uniqueWord : uniqueWords) {
            int counter = 0;
            for (String word : words) {
                if (uniqueWord.equals(word)) {
                    counter++;
                }
            }
            list.add(new NameAndOccurance(uniqueWord, counter));
        }
        return list;
    }

    private static class NameAndOccurance {

        private String name;
        private int occurrence;

        public NameAndOccurance(String name, int occurrence) {
            this.name = name;
            this.occurrence = occurrence;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getOccurrence() {
            return occurrence;
        }

        public void setOccurrence(int occurrence) {
            this.occurrence = occurrence;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            NameAndOccurance that = (NameAndOccurance) o;
            return occurrence == that.occurrence && Objects.equals(name, that.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, occurrence);
        }

        @Override
        public String toString() {
            return "\n" + "{" +
                    "name: " + '"' + name + '"' +
                    ", occurrence: " + occurrence +
                    '}';
        }
    }
}
