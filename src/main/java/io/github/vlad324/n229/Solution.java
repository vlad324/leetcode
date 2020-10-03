package io.github.vlad324.n229;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * {@link "https://leetcode.com/problems/majority-element-ii/"}
 */
class Solution {

    public List<Integer> majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }

        if (nums.length == 1) {
            return Collections.singletonList(nums[0]);
        }

        int a = nums[0], b = nums[1];
        int count1 = 0, count2 = 0;

        for (final int v : nums) {
            if (v == a) {
                count1++;
            } else if (v == b) {
                count2++;
            } else if (count1 == 0) {
                a = v;
                count1 = 1;
            } else if (count2 == 0) {
                b = v;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        if (a == b) {
            return Collections.singletonList(a);
        }

        count1 = 0;
        count2 = 0;
        for (final int v : nums) {
            if (v == a) {
                count1++;
            } else if (v == b) {
                count2++;
            }
        }

        final var result = new ArrayList<Integer>(2);
        final var i = nums.length / 3;

        if (count1 > i) {
            result.add(a);
        }

        if (count2 > i) {
            result.add(b);
        }

        return result;
    }
}