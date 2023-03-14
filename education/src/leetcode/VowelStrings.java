package leetcode;

public class VowelStrings {

    public static void main(String[] args) {

        String[] words = {"hey","aeo","mu","ooo","artro"};
        int left = 1;
        int right = 4;

        System.out.println(vowelStringsMethod(words, left, right));
    }

    public static int vowelStringsMethod(String[] words, int left, int right) {
        int counter = 0;
        if (left < words.length && right < words.length) {
            for (int i = left; i <= right; i++) {
                String str = words[i];
                if (str.length() > 1) {
                    if (str.matches("^[aeiou].*[aeiou]$")) {
                        counter++;
                    }
                } else {
                    if (str.matches("^[aeiou]")) {
                        counter++;
                    }
                }
            }
        }
        return counter;
    }
}
