package io.github.vlad324.n98;

class Solution {
    public boolean isValidBST(TreeNode root) {
        return root == null
            || (isValidBST(root.left, null, root.val) && isValidBST(root.right, root.val, null));
    }


    public boolean isValidBST(TreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }

        if (min != null && node.val <= min) {
            return false;
        }

        if (max != null && node.val >= max) {
            return false;
        }

        return isValidBST(node.left, min, node.val)
            && isValidBST(node.right, node.val, max);
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
