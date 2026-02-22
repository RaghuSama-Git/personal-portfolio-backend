package com.portfolio.get_in_touch.model;

public class Solution {
    public static int[] plusOne(int[] digits) {
        int[] nums = new int[digits.length];
        String s = "";
        for (int i : digits) {
            s = s + i;
        }
        int a = Integer.parseInt(s) + 1;
        s = String.valueOf(a);
        for (int i = 0; i < digits.length; i++) {
            digits[i] = s.charAt(i);

        }
        return digits;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 5};
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            
        }
        plusOne(nums);
    }
}