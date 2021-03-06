package io.github.vlad324.n525;

import java.util.HashMap;

/**
 * {@link "https://leetcode.com/problems/contiguous-array/"}
 */
class Solution {

    public int findMaxLength(int[] nums) {
        int sum = 0;
        int maxLength = 0;
        final var map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 0 ? -1 : 1;
            if (map.containsKey(sum)) {
                maxLength = Math.max(maxLength, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }

        return maxLength;
    }
}
