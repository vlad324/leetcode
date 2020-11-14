package io.github.vlad324.n1652;

/**
 * {@link "https://leetcode.com/problems/defuse-the-bomb/"}
 */
class Solution {
    public int[] decrypt(int[] code, int k) {
        final int[] result = new int[code.length];

        if (k > 0) {
            for (int i = 0; i < code.length; i++) {
                int sum = 0;
                int count = k;
                int j = i + 1;
                while (count > 0) {
                    if (j == code.length) {
                        j = 0;
                    }

                    sum += code[j];
                    count--;
                    j++;
                }
                result[i] = sum;
            }
        } else if (k < 0) {
            for (int i = 0; i < code.length; i++) {
                int sum = 0;
                int count = k;
                int j = i - 1;
                while (count < 0) {
                    if (j < 0) {
                        j = code.length - 1;
                    }

                    sum += code[j];
                    count++;
                    j--;
                }
                result[i] = sum;
            }
        }

        return result;
    }
}
