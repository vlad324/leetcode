package io.github.vlad324.n208;

import java.util.HashMap;
import java.util.Map;

/**
 * {@link "https://leetcode.com/problems/implement-trie-prefix-tree/"}
 */
class Trie {

    private final Node root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        this.root = new Node();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        var node = root;
        for (final char c : word.toCharArray()) {
            node = node.map.compute(c, (key, value) -> value == null ? new Node() : value);
        }

        node.isWord = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        var node = root;
        for (final char c : word.toCharArray()) {
            node = node.map.get(c);

            if (node == null) {
                return false;
            }
        }

        return node.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        var node = root;
        for (final char c : prefix.toCharArray()) {
            node = node.map.get(c);

            if (node == null) {
                return false;
            }
        }

        return true;
    }

    private static class Node {
        public Map<Character, Node> map;
        public boolean isWord;

        public Node() {
            this.map = new HashMap<>();
            this.isWord = false;
        }
    }
}
