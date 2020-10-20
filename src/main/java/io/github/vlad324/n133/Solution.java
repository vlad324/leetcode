package io.github.vlad324.n133;

import java.util.ArrayList;
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

        final var visited = new boolean[100];
        final var values = new Node[100][100];

        final var queue = new LinkedList<Node>();
        queue.push(node);
        while (!queue.isEmpty()) {
            final var current = queue.poll();

            final var i = current.val - 1;
            if (visited[i]) {
                continue;
            }
            visited[i] = true;

            final var copy = new Node(current.val);
            values[i][i] = copy;

            for (int j = 0; j < current.neighbors.size(); j++) {
                final var n = current.neighbors.get(j);

                values[n.val - 1][i] = copy;
                queue.add(n);
            }
        }

        for (int i = 0; i < 100; i++) {
            final var current = values[i][i];
            if (current != null) {
                for (int j = 0; j < 100; j++) {
                    if (values[i][j] != null && j != i) {
                        current.neighbors.add(values[i][j]);
                    }
                }
            }
        }

        return values[node.val - 1][node.val - 1];
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
