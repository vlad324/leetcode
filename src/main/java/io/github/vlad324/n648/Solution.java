package io.github.vlad324.n648;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * {@link "https://leetcode.com/problems/replace-words/"}
 */
class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        final var trie = buildTrie(dictionary);

        final var result = new StringBuilder();
        final var words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            final var replacement = getReplacement(words[i], trie);
            if (replacement != null) {
                result.append(replacement);
            } else {
                result.append(words[i]);
            }

            if (i != words.length - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }

    private Node buildTrie(List<String> dictionary) {
        final var root = new Node();
        for (final var w : dictionary) {
            var node = root;

            for (final var c : w.toCharArray()) {
                node = node.children.compute(c, (k, v) -> v == null ? new Node() : v);
            }

            node.word = w;
        }

        return root;
    }

    private String getReplacement(String word, Node trie) {
        for (final var c : word.toCharArray()) {
            trie = trie.children.get(c);

            if (trie == null) {
                break;
            }

            if (trie.word != null) {
                return trie.word;
            }
        }

        return null;
    }

    private static class Node {
        Map<Character, Node> children;
        String word;

        public Node() {
            this.children = new HashMap<>();
            this.word = null;
        }
    }
}

