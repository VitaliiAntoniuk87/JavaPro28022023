package leetcode;

import java.util.Arrays;

public class twoSum {

    public static void main(String[] args) {


        int[] nums = {2, 5, 5, 11};
        int target = 10;

        System.out.println(Arrays.toString(twoSumMethod(nums, target)));
    }

    public static int[] twoSumMethod(int[] nums, int target) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[j] + nums[j - i] == target) {
                    return new int[]{j - i, j};
                }
            }
        }
        return null;
    }
}

