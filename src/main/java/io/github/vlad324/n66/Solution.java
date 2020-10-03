package io.github.vlad324.n66;

/**
 * {@link "https://leetcode.com/problems/plus-one/"}
 */
class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return new int[0];
        }

        var i = digits.length - 1;
        while (i >= 0) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            } else {
                digits[i] = 0;
            }
            i--;
        }

        int[] copy = new int[digits.length + 1];
        System.arraycopy(digits, 0, copy, 1, digits.length);
        copy[0] = 1;

        return copy;
    }
}
