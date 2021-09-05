package io.github.vlad324.n899;

import java.util.Arrays;

/**
 * {@link "https://leetcode.com/problems/orderly-queue/"}
 */
class Solution {
    public String orderlyQueue(String s, int k) {
        if (k > 1) {
            final var chars = s.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }

        var result = new StringBuilder(s);
        final var sb = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            sb.append(sb.charAt(0)).deleteCharAt(0);

            if (sb.compareTo(result) < 0) {
                result = new StringBuilder(sb);
            }
        }

        return result.toString();
    }
}
