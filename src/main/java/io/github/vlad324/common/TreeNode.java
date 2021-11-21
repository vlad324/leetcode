package io.github.vlad324.common;


import java.util.Objects;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this(val, null, null);
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode treeNode(int val) {
        return new TreeNode(val);
    }

    public static TreeNode treeNode(int val, TreeNode left, TreeNode right) {
        return new TreeNode(val, left, right);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final TreeNode treeNode = (TreeNode) o;
        return val == treeNode.val &&
            Objects.equals(left, treeNode.left) &&
            Objects.equals(right, treeNode.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, left, right);
    }

    @Override
    public String toString() {
        return "TreeNode{" +
            "val=" + val +
            ", left=" + left +
            ", right=" + right +
            '}';
    }
}
