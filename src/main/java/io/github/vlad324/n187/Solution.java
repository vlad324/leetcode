package io.github.vlad324.n187;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * {@link "https://leetcode.com/problems/repeated-dna-sequences/"}
 */
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if (s == null || s.isEmpty()) {
            return Collections.emptyList();
        }

        final var result = new LinkedList<String>();
        final var root = new Node();
        for (int i = 0; i <= s.length() - 10; i++) {
            var node = root;
            for (int j = i; j < i + 10; j++) {
                final var index = toIndex(s.charAt(j));

                if (node.children[index] == null) {
                    node.children[index] = new Node();
                }

                node = node.children[index];
            }

            node.count++;

            if (node.count == 2) {
                result.add(s.substring(i, i + 10));
            }
        }

        return result;
    }

    private static int toIndex(char c) {
        switch (c) {
            case 'A':
                return 0;
            case 'C':
                return 1;
            case 'G':
                return 2;
            case 'T':
                return 3;
            default:
                throw new IllegalArgumentException("Unrecognized char " + c);
        }
    }


    private static class Node {
        Node[] children;
        int count;

        public Node() {
            this.children = new Node[4];
            this.count = 0;
        }
    }
}