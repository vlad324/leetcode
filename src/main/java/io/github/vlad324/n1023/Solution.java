package io.github.vlad324.n1023;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link "https://leetcode.com/problems/camelcase-matching/"}
 */
class Solution {

    public List<Boolean> camelMatch(String[] queries, String pattern) {
        final var result = new ArrayList<Boolean>(queries.length);
        for (final var q : queries) {

            int j = 0;
            boolean matches = true;
            for (int i = 0; i < q.length(); i++) {
                final var qi = q.charAt(i);
                if (j < pattern.length()) {
                    final var pj = pattern.charAt(j);
                    if (Character.isUpperCase(qi) && qi != pj) {
                        matches = false;
                        break;
                    }

                    if (qi == pj) {
                        j++;
                    }
                } else {
                    if (Character.isUpperCase(qi)) {
                        matches = false;
                        break;
                    }
                }

            }

            result.add(j >= pattern.length() && matches);
        }

        return result;
    }
}
