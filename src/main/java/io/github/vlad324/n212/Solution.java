package io.github.vlad324.n212;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * {@link "https://leetcode.com/problems/word-search-ii/"}
 */
class Solution {

    private static final int[][] NEIGHBORS = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    public List<String> findWords(char[][] board, String[] words) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return Collections.emptyList();
        }

        final var root = buildTrie(words);

        final var result = new LinkedList<String>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                dsf(board, i, j, root, result);
            }
        }

        return result;
    }

    private void dsf(char[][] board, int i, int j, Node root, LinkedList<String> result) {
        if (i < 0 || i == board.length || j < 0 || j == board[0].length) {
            return;
        }

        final var c = board[i][j];
        if (root.children.get(c) == null) {
            return;
        }

        root = root.children.get(c);
        if (root.word != null) {
            result.add(root.word);
            root.word = null;
        }

        board[i][j] = '*';

        for (final var d : NEIGHBORS) {
            dsf(board, i + d[0], j + d[1], root, result);
        }

        board[i][j] = c;
    }

    private Node buildTrie(String[] words) {
        final var root = new Node();

        for (final var w : words) {
            insert(w, root);
        }

        return root;
    }

    public void insert(String word, Node root) {
        var node = root;
        for (final var c : word.toCharArray()) {
            node = node.children.compute(c, (k, v) -> v == null ? new Node() : v);
        }

        node.word = word;
    }

    private final static class Node {
        public Map<Character, Node> children;
        String word;

        public Node() {
            this.children = new HashMap<>();
            this.word = null;
        }
    }
}
