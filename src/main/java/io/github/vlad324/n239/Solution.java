package io.github.vlad324.n239;

import java.util.ArrayDeque;

/**
 * {@link "https://leetcode.com/problems/sliding-window-maximum/"}
 */
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1) {
            return nums;
        }

        int[] result = new int[nums.length - k + 1];
        final var queue = new ArrayDeque<Integer>();
        for (int i = 0; i < k - 1; i++) {
            while (queue.size() > 0 && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }

            queue.offerLast(i);
        }

        for (int i = k - 1; i < nums.length; i++) {
            while (!queue.isEmpty() && queue.peekFirst() <= i - k) {
                queue.pollFirst();
            }

            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }

            queue.offerLast(i);
            result[i - k + 1] = nums[queue.peekFirst()];
        }

        return result;
    }
}