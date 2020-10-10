package io.github.vlad324.n676;

import java.util.HashMap;
import java.util.Map;

/**
 * {@link "https://leetcode.com/problems/implement-magic-dictionary/"}
 */
class MagicDictionary {

    private final Node root;

    public MagicDictionary() {
        this.root = new Node();
    }

    public void buildDict(String[] dictionary) {
        for (final var w : dictionary) {
            var node = this.root;

            for (int i = 0; i < w.length(); i++) {
                node = node.children.computeIfAbsent(w.charAt(i), k -> new Node());
            }

            node.isWord = true;
        }
    }

    public boolean search(String searchWord) {
        return dfs(this.root, searchWord, 0, false);
    }

    private boolean dfs(Node root, String searchWord, int i, boolean changed) {
        if (i == searchWord.length()) {
            return changed && root.isWord;
        }

        final var c = searchWord.charAt(i);
        i++;

        final var node = root.children.get(c);
        if (node != null && dfs(node, searchWord, i, changed)) {
            return true;
        }

        if (!changed) {
            for (final var entry : root.children.entrySet()) {
                if (entry.getKey() != c && dfs(entry.getValue(), searchWord, i, true)) {
                    return true;
                }
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
