package io.github.vlad324.n17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * {@link "https://leetcode.com/problems/letter-combinations-of-a-phone-number/"}
 */
class Solution {
    private static final char[][] mapping = new char[][]{
        {'a', 'b', 'c'},
        {'d', 'e', 'f'},
        {'g', 'h', 'i'},
        {'j', 'k', 'l'},
        {'m', 'n', 'o'},
        {'p', 'q', 'r', 's'},
        {'t', 'u', 'v'},
        {'w', 'x', 'y', 'z'}
    };

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return Collections.emptyList();
        }

        final var result = new ArrayList<String>();
        dfs(new StringBuilder(digits.length()), digits.toCharArray(), result);
        return result;
    }

    private void dfs(StringBuilder current, char[] digits, List<String> result) {
        if (current.length() == digits.length) {
            result.add(current.toString());
            return;
        }

        for (final var c : mapping[digits[current.length()] - '2']) {
            dfs(current.append(c), digits, result);
            current.deleteCharAt(current.length() - 1);
        }
    }
}