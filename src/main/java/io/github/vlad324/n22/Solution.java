package io.github.vlad324.n22;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link "https://leetcode.com/problems/generate-parentheses/"}
 */
class Solution {
    public List<String> generateParenthesis(int n) {
        final var result = new ArrayList<String>();
        populate(result, new StringBuilder(), 0, 0, n);

        return result;
    }

    private void populate(List<String> result, StringBuilder sb, int open, int close, int max) {
        if (sb.length() == max * 2) {
            result.add(sb.toString());
            return;
        }

        if (open < max) {
            sb.append("(");
            populate(result, sb, open + 1, close, max);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (close < open) {
            sb.append(")");
            populate(result, sb, open, close + 1, max);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
