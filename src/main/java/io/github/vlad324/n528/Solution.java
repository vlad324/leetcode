package io.github.vlad324.n528;

import java.util.Arrays;
import java.util.Random;

/**
 * {@link "https://leetcode.com/problems/random-pick-with-weight/"}
 */
class Solution {

    private final Random random;
    private final int weightsSum;
    private final int[] weights;

    public Solution(int[] w) {
        this.random = new Random();

        int weightsSum = 0;
        for (int i = 0; i < w.length; i++) {
            weightsSum += w[i];
            w[i] = weightsSum;
        }

        this.weightsSum = weightsSum;
        this.weights = w;
    }

    public int pickIndex() {
        var weight = random.nextInt(weightsSum);

        return Math.abs(Arrays.binarySearch(weights, weight) + 1);
    }
}
