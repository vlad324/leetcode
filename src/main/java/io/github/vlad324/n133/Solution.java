package io.github.vlad324.n133;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * {@link "https://leetcode.com/problems/clone-graph/"}
 */
class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        final var values = new HashMap<Node, Node>();

        final var queue = new LinkedList<Node>();
        queue.push(node);
        while (!queue.isEmpty()) {
            final var current = queue.poll();
            final var copy = values.computeIfAbsent(current, (k) -> new Node(k.val));

            for (final var n : current.neighbors) {
                if (!values.containsKey(n)) {
                    values.put(n, new Node(n.val));
                    queue.add(n);
                }

                copy.neighbors.add(values.get(n));
            }
        }

        return values.get(node);
    }


    static class Node {
        final int val;
        final List<Node> neighbors;

        public Node(int val) {
            this(val, new ArrayList<>());
        }

        public Node(int val, ArrayList<Node> neighbors) {
            this.val = val;
            this.neighbors = neighbors;
        }
    }
}
