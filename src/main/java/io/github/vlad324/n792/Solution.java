package io.github.vlad324.n792;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * {@link "https://leetcode.com/problems/number-of-matching-subsequences/"}
 */
class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        final var buckets = new HashMap<Character, List<Node>>();
        for (String word : words) {
            buckets.computeIfAbsent(word.charAt(0), c -> new ArrayList<>())
                .add(new Node(word, 0));
        }

        int ans = 0;
        for (final var c : s.toCharArray()) {
            if (buckets.get(c) == null) {
                continue;
            }

            for (Node node : buckets.remove(c)) {
                node.index += 1;
                if (node.index == node.word.length()) {
                    ans++;
                } else {
                    buckets.computeIfAbsent(node.word.charAt(node.index), k -> new ArrayList<>())
                        .add(node);
                }
            }
        }

        return ans;
    }

    private static class Node {
        String word;
        int index;

        Node(String word, int index) {
            this.word = word;
            this.index = index;
        }
    }
}
