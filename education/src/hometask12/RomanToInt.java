package hometask12;

public class RomanToInt {

    public static void main(String[] args) {
        String str = "MCMXCIV";

        System.out.println(romanToInt(str));
    }

    public static int romanToInt(String romanNumerals) {
        int[] arabicNumerals = new int[romanNumerals.length()];
        for (int i = 0; i < romanNumerals.length(); i++) {
            switch (romanNumerals.charAt(i)) {
                case 'M' -> arabicNumerals[i] = 1000;
                case 'D' -> arabicNumerals[i] = 500;
                case 'C' -> arabicNumerals[i] = 100;
                case 'L' -> arabicNumerals[i] = 50;
                case 'X' -> arabicNumerals[i] = 10;
                case 'V' -> arabicNumerals[i] = 5;
                case 'I' -> arabicNumerals[i] = 1;
            }
        }
        int sum = 0;
        for (int i = 0; i < arabicNumerals.length - 1; i++) {
            sum += (arabicNumerals[i] >= arabicNumerals[i + 1]) ? arabicNumerals[i] : -arabicNumerals[i];
        }
        return sum + arabicNumerals[arabicNumerals.length - 1];
    }


}
