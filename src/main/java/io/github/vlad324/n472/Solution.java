package io.github.vlad324.n472;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * {@link "https://leetcode.com/problems/concatenated-words/"}
 */
class Solution {

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        if (words == null || words.length == 0) {
            return Collections.emptyList();
        }

        Arrays.sort(words, Comparator.comparingInt(String::length));

        final var root = new Node();

        final var result = new LinkedList<String>();
        for (final var w : words) {
            final var prefixes = new LinkedList<Integer>();
            var node = root;
            for (int i = 0; i < w.length(); i++) {
                node = node.children.get(w.charAt(i));

                if (node == null) {
                    break;
                }

                if (node.isWord) {
                    prefixes.add(i);
                }
            }

            while (!prefixes.isEmpty()) {
                final var current = prefixes.poll();

                node = root;
                for (int i = current + 1; i < w.length(); i++) {
                    node = node.children.get(w.charAt(i));

                    if (node == null) {
                        break;
                    }

                    if (node.isWord) {
                        prefixes.add(i);
                    }
                }

                if (node != null && node.isWord) {
                    result.add(w);
                    break;
                }
            }

            node = root;
            for (int i = 0; i < w.length(); i++) {
                node = node.children.compute(w.charAt(i), (k, v) -> v == null ? new Node() : v);
            }
            node.isWord = true;
        }

        return result;
    }

    private static final class Node {
        Map<Character, Node> children;
        boolean isWord;

        public Node() {
            this.children = new HashMap<>();
            this.isWord = false;
        }
    }
}
