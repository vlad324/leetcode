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

//    public StreamChecker(String[] words) {
//        this.root = new Node();
//        this.queue = new LinkedList<>();
//
//        for (final var w : words) {
//            var node = this.root;
//            for (int i = 0; i < w.length(); i++) {
//                node = node.children.compute(w.charAt(i), (k, v) -> v == null ? new Node() : v);
//            }
//
//            node.isWord = true;
//        }
//    }
//
//    public boolean query(char letter) {
//        boolean result = false;
//        queue.add(this.root);
//        final var size = queue.size();
//        for (int i = 0; i < size; i++) {
//            final var current = queue.poll().children.get(letter);
//
//            if (current != null) {
//                queue.add(current);
//                result = result || current.isWord;
//            }
//        }
//
//        return result;
//    }

    private static class Node {
        Map<Character, Node> children;
        boolean isWord;

        public Node() {
            this.children = new HashMap<>();
            this.isWord = false;
        }
    }
}
