package io.github.vlad324.n70;

import java.util.ArrayList;

/**
 * {@link "https://leetcode.com/problems/climbing-stairs/"}
 */
class Solution {
    public int climbStairs(int n) {
        final var list = new ArrayList<Integer>();
        list.add(1);
        list.add(1);
        int size;
        for (int i = 1; i < n; i++) {
            size = list.size();
            list.add(list.get(size - 1) + list.get(size - 2));
        }

        return list.get(list.size() - 1);
    }
}
