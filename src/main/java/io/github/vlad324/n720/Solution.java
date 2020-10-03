package io.github.vlad324.n720;

import java.util.LinkedList;

/**
 * {@link "https://leetcode.com/problems/longest-word-in-dictionary/"}
 */
class Solution {

    public String longestWord(String[] words) {
        final var trie = buildTrie(words);

        return bfs(trie);
    }

    private String dfs(Node node, boolean top) {
        if (node == null || (!top && node.word == null)) {
            return "";
        }

        var word = top ? "" : node.word;
        for (int i = 0; i < node.children.length; i++) {
            final var child = node.children[i];
            final var temp = dfs(child, false);
            if (temp.length() > word.length()) {
                word = temp;
            }
        }

        return word;
    }

    private String bfs(Node trie) {
        final var queue = new LinkedList<Node>();

        for (int i = 0; i < trie.children.length; i++) {
            final var child = trie.children[i];
            if (child != null) {
                queue.offer(child);
            }
        }

        var word = "";
        while (!queue.isEmpty()) {
            final var current = queue.poll();

            if (current.word == null) {
                continue;
            }

            for (int i = 0; i < current.children.length; i++) {
                final var child = current.children[i];
                if (child != null) {
                    queue.offer(child);
                }
            }

            if (current.word.length() > word.length()) {
                word = current.word;
            }
        }

        return word;
    }

    private Node buildTrie(String[] words) {
        final var root = new Node();
        for (final var w : words) {
            var node = root;
            for (final var c : w.toCharArray()) {

                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new Node();
                }

                node = node.children[c - 'a'];
            }
            node.word = w;
        }

        return root;
    }

    private static class Node {
        Node[] children;
        String word;

        public Node() {
            this.children = new Node[26];
            this.word = null;
        }
    }
}

