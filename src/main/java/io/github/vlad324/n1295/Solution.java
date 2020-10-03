package io.github.vlad324.n1295;

/**
 * {@link "https://leetcode.com/problems/find-numbers-with-even-number-of-digits/"}
 */
class Solution {

    public int findNumbers(int[] nums) {
        if (nums == null) {
            return 0;
        }

        int count = 0;
        for (final int num : nums) {
            if (evenDigitCount(num)) {
                count++;
            }
        }

        return count;
    }

    private boolean evenDigitCount(int num) {
        int count = 1;
        while ((num /= 10) != 0) {
            count++;
        }

        return count % 2 == 0;
    }
}
