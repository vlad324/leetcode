package io.github.vlad324.n60;

import java.util.LinkedList;

/**
 * {@link "https://leetcode.com/problems/permutation-sequence/"}
 */
class Solution {

    public String getPermutation(int n, int k) {
        int divider = 1;
        final var fNumber = new int[n];
        int index = 0;
        k--;
        while (k != 0) {
            fNumber[index++] = k % divider;
            k /= divider;
            divider++;
        }

        final var integers = new LinkedList<Integer>();
        for (int i = 1; i <= n; i++) {
            integers.add(i);
        }

        final var result = new StringBuilder();
        for (int i = fNumber.length - 1; i >= 0; i--) {
            result.append(integers.remove(fNumber[i]));
        }

        return result.toString();
    }
}
