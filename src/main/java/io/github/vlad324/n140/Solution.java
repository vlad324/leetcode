package io.github.vlad324.n140;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * {@link "https://leetcode.com/problems/word-break-ii/"}
 */
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return wordBreakHelper(s, new HashSet<>(wordDict), new HashMap<>());
    }

    private List<String> wordBreakHelper(String s, Set<String> wordDict, Map<String, List<String>> cache) {
        if (cache.containsKey(s)) {
            return cache.get(s);
        }

        final var result = new LinkedList<String>();

        if (wordDict.contains(s)) {
            result.add(s);
        }

        for (int i = 1; i <= s.length(); i++) {
            final var startPart = s.substring(0, i);
            if (wordDict.contains(startPart)) {
                final var subList = wordBreakHelper(s.substring(i), wordDict, cache);
                for (final var w : subList) {
                    result.add(startPart + " " + w);
                }
            }
        }

        cache.put(s, result);

        return result;
    }
}
