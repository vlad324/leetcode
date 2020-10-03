package io.github.vlad324.n987;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * {@link "https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/"}
 */
class Solution {

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        final var queue = new PriorityQueue<>(Comparator.<int[]>comparingInt(a -> a[1])
            .thenComparingInt(a -> a[2])
            .thenComparingInt(a -> a[0]));

        dfs(root, 0, 0, queue);

        final var result = new LinkedList<List<Integer>>();
        List<Integer> tmp = null;
        long previousX = Long.MIN_VALUE;
        while (!queue.isEmpty()) {
            final var current = queue.poll();
            if (current[1] != previousX) {
                tmp = new LinkedList<>();
                result.add(tmp);

                tmp.add(current[0]);
                previousX = current[1];
            } else {
                tmp.add(current[0]);
            }
        }

        return result;
    }

    private void dfs(TreeNode root, int i, int j, PriorityQueue<int[]> queue) {
        if (root == null) {
            return;
        }

        queue.add(new int[]{root.val, i, j});

        dfs(root.left, i - 1, j + 1, queue);
        dfs(root.right, i + 1, j + 1, queue);
    }

    static class TreeNode {
        public final int val;
        public final TreeNode left;
        public final TreeNode right;

        TreeNode(int val) {
            this(val, null, null);
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}