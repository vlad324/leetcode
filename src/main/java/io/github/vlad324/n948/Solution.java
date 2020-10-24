package io.github.vlad324.n948;

import java.util.Arrays;

/**
 * {@link "https://leetcode.com/problems/bag-of-tokens/"}
 */
class Solution {
    public int bagOfTokensScore(int[] tokens, int P) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }

        Arrays.sort(tokens);

        int i = 0;
        int j = tokens.length - 1;
        int score = 0;
        while (i <= j) {
            if (tokens[i] <= P) {
                P -= tokens[i];
                score++;
                i++;
            } else if (score != 0 && j - i > 1) {
                P += tokens[j];
                score--;
                j--;
            } else {
                break;
            }
        }

        return score;
    }
}
