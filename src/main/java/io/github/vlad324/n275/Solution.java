package io.github.vlad324.n275;

import java.util.Arrays;

/**
 * {@link "https://leetcode.com/problems/h-index-ii/"}
 */
class Solution {

    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }

        Arrays.sort(citations);

        int result = 0;
        for (int i = citations.length - 1; i >= 0; i--) {
            result = Math.max(result, Math.min(citations[i], citations.length - i));
        }

        return result;
    }
}
