package io.github.vlad324.n1689;

/**
 * {@link "https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/"}
 */
class Solution {
    public int minPartitions(String n) {
        int result = 1;
        for (final var c : n.toCharArray()) {
            if (c == '9') {
                return 9;
            }

            if (c > result) {
                result = c;
            }
        }

        return result - '0';
    }
}
