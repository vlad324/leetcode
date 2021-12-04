package io.github.vlad324.n1032;

import java.util.HashMap;
import java.util.Map;

/**
 * {@link "https://leetcode.com/problems/stream-of-characters/"}
 */
class StreamChecker {

    private final Node root;
    private final StringBuilder stringBuilder;
    private final int maxLength;

    public StreamChecker(String[] words) {
        this.root = new Node();
        this.stringBuilder = new StringBuilder();

        int maxLength = 0;
        for (final var w : words) {
            var node = this.root;
            maxLength = Math.max(maxLength, w.length());
            for (int i = w.length() - 1; i >= 0; i--) {
                node = node.children.compute(w.charAt(i), (k, v) -> v == null ? new Node() : v);
            }

            node.isWord = true;
        }

        this.maxLength = maxLength;
    }

    public boolean query(char letter) {
        this.stringBuilder.append(letter);
        if (this.stringBuilder.length() > maxLength) {
            this.stringBuilder.deleteCharAt(0);
        }

        var node = this.root;
        for (int i = this.stringBuilder.length() - 1; i >= 0; i--) {
            node = node.children.get(this.stringBuilder.charAt(i));

            if (node == null) {
                break;
            }

            if (node.isWord) {
                return true;
            }
        }

        return false;
    }

    private static class Node {
        Map<Character, Node> children;
        boolean isWord;

        public Node() {
            this.children = new HashMap<>();
            this.isWord = false;
        }
    }
}
