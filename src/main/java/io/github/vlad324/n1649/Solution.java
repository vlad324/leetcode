package io.github.vlad324.n1649;

/**
 * {@link "https://leetcode.com/problems/create-sorted-array-through-instructions/"}
 */
class Solution {
    public int createSortedArray(int[] instructions) {
        final var tree = new FenwickTree(100002);
        long cost = 0;
        for (int i = 0; i < instructions.length; i++) {
            final int leftCost = tree.query(instructions[i] - 1);
            final int rightCost = i - tree.query(instructions[i]);
            cost += Math.min(leftCost, rightCost);
            tree.add(instructions[i], 1);
        }

        return (int) (cost % 1000000007);
    }

    private static class FenwickTree {
        public final int[] tree;
        public final int size;

        public FenwickTree(int size) {
            this.tree = new int[size];
            this.size = size;
        }

        public void add(int index, int value) {
            while (index < size) {
                tree[index] += value;
                index += index & -index;
            }
        }

        public int query(int index) {
            int result = 0;
            while (index > 0) {
                result += tree[index];
                index -= index & -index;
            }
            return result;
        }
    }
}
