package io.github.vlad324.n1306;

import java.util.HashSet;
import java.util.Set;

/**
 * {@link "https://leetcode.com/problems/jump-game-iii/"}
 */
class Solution {
    public boolean canReach(int[] arr, int start) {
        return canReach(arr, start, new HashSet<>());
    }

    private boolean canReach(int[] arr, int i, Set<Integer> visited) {
        if (visited.contains(i) || i >= arr.length || i < 0) {
            return false;
        }

        if (arr[i] == 0) {
            return true;
        }

        visited.add(i);

        return canReach(arr, i + arr[i], visited) || canReach(arr, i - arr[i], visited);
    }
}
