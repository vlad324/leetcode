package io.github.vlad324.n745;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * {@link "https://leetcode.com/problems/prefix-and-suffix-search/"}
 */
class WordFilter {

    private final Node root;

    public WordFilter(String[] words) {
        this.root = new Node();

        for (int j = 0; j < words.length; j++) {
            final String w = words[j];
            var node = this.root;

            for (int i = 0; i < w.length(); i++) {
                node = node.children.computeIfAbsent(w.charAt(i), k -> new Node());
            }

            node.word = w;
            node.index = j;
        }
    }

    public int f(String prefix, String suffix) {
        var node = this.root;

        for (int i = 0; i < prefix.length(); i++) {
            node = node.children.get(prefix.charAt(i));

            if (node == null) {
                return -1;
            }
        }

        return dfs(node, suffix);
    }

    private int dfs(Node node, String suffix) {
        final var stack = new Stack<Node>();

        int maxIndex = -1;
        stack.push(node);
        while (!stack.isEmpty()) {
            final var current = stack.pop();

            if (current.word != null && current.word.endsWith(suffix)) {
                maxIndex = Math.max(maxIndex, current.index);
            }

            for (final var n : current.children.values()) {
                stack.push(n);
            }
        }

        return maxIndex;
    }

    private static class Node {
        Map<Character, Node> children;
        String word;
        int index;

        public Node() {
            this.children = new HashMap<>();
            this.word = null;
            this.index = -1;
        }
    }
}
