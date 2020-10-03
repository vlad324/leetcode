package io.github.vlad324.n211;

import java.util.HashMap;
import java.util.Map;

/**
 * {@link "https://leetcode.com/problems/design-add-and-search-words-data-structure/"}
 */
class WordDictionary {

    private final Node root;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        this.root = new Node();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        var node = root;
        for (final char c : word.toCharArray()) {
            node = node.map.compute(c, (key, value) -> value == null ? new Node() : value);
        }

        node.isWord = true;
    }

    /**
     * Returns if the word is in the data structure.
     * A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return searchInternal(root, word, 0);
    }

    private boolean searchInternal(Node node, String word, int i) {
        if (node == null) {
            return false;
        }

        if (i == word.length()) {
            return node.isWord;
        }

        final var c = word.charAt(i);

        if (c == '.') {
            for (final var n : node.map.values()) {
                if (searchInternal(n, word, i + 1)) {
                    return true;
                }
            }

            return false;
        }

        return searchInternal(node.map.get(c), word, i + 1);
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
