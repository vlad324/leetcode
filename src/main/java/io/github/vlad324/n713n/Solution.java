package io.github.vlad324.n713n;

/**
 * {@link "https://leetcode.com/problems/subarray-product-less-than-k/"}
 */
class Solution {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int result = 0;
        for (int i = 1; i <= nums.length; i++) {
            int start = 0;
            int end = start + i;

            long product = 1;
            for (int j = 0; j < end; j++) {
                product *= nums[j];
            }

            if (product < k) {
                result++;
            }

            while (end < nums.length) {
                product /= nums[start];
                product *= nums[end];

                if (product < k) {
                    result++;
                }

                start++;
                end++;
            }

        }

        return result;
    }

//    public int numSubarrayProductLessThanK(int[] nums, int k) {
//        if (k <= 1) {
//            return 0;
//        }
//
//        int result = 0;
//        int product = 1;
//        int left = 0;
//        for (int right = 0; right < nums.length; right++) {
//            product *= nums[right];
//
//            while (product >= k) {
//                product /= nums[left++];
//            }
//
//            result += right - left + 1;
//        }
//        return result;
//    }
}
