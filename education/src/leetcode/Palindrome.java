package leetcode;

public class Palindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }

    public static boolean isPalindrome(int x) {
        String str1 = String.valueOf(x);
        StringBuilder sb = new StringBuilder(str1);
        return str1.equals(String.valueOf(sb.reverse()));
    }
}
