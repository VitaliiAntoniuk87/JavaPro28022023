package homework6;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {


        int[] numbers = {2, 5, 4, 11};
        int target = 7;
        String inputWord = "A man, a plan, a canal: Panama";

//        1:
        System.out.println(isPalindrome(inputWord));

//        2:
        System.out.println(isContainsDuplicate(numbers));

//        3:
        System.out.println(Arrays.toString(twoSumMethod(numbers, target)));


    }

    public static int[] twoSumMethod(int[] numbers, int target) {
        for (int i = 1; i < numbers.length; i++) {
            for (int j = i; j < numbers.length; j++) {
                if (numbers[j] + numbers[j - i] == target) {
                    return new int[]{j - i, j};
                }
            }
        }
        return null;
    }

    public static boolean isContainsDuplicate(int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            for (int j = i; j < numbers.length; j++) {
                if (numbers[j] == numbers[j - i]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isPalindrome(String inputWord) {
        String filteredWord = inputWord.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        return filteredWord.equals(new StringBuilder(filteredWord).reverse().toString());
    }
}

