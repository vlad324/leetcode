package io.github.vlad324.n307;

/**
 * {@link "https://leetcode.com/problems/range-sum-query-mutable/"}
 */
class NumArray {

    private final int[] nums;
    private final int[] blocks;

    public NumArray(int[] nums) {
        this.nums = nums;
        final var blockCount = (int) Math.ceil(nums.length / Math.sqrt(nums.length));
        blocks = new int[blockCount];
        for (int i = 0; i < nums.length; i++) {
            blocks[i / blockCount] += nums[i];
        }
    }

    public void update(int index, int val) {
        final var i = index / blocks.length;
        blocks[i] += val - nums[index];
        nums[index] = val;
    }

    public int sumRange(int left, int right) {
        int sum = 0;
        int startBlock = left / blocks.length;
        int endBlock = right / blocks.length;
        if (startBlock == endBlock) {
            for (int i = left; i <= right; i++)
                sum += nums[i];
        } else {
            for (int i = left; i <= (startBlock + 1) * blocks.length - 1; i++) {
                sum += nums[i];
            }
            for (int i = startBlock + 1; i <= endBlock - 1; i++) {
                sum += blocks[i];
            }
            for (int i = endBlock * blocks.length; i <= right; i++) {
                sum += nums[i];
            }
        }

        return sum;
    }
}
