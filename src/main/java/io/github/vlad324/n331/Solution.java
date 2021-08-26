package io.github.vlad324.n331;

/**
 * {@link "https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/"}
 */
class Solution {
    public boolean isValidSerialization(String preorder) {
        int slots = 1;
        for (final var s : preorder.split(",")) {
            if (slots <= 0) {
                return false;
            }

            slots += s.equals("#") ? -1 : 1;
        }

        return slots == 0;
    }
}
