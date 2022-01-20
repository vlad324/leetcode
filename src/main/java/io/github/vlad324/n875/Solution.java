package io.github.vlad324.n875;

/**
 * {@link "https://leetcode.com/problems/koko-eating-bananas/"}
 */
class Solution {

    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        int sum = 0;
        for (int p : piles) {
            max = Math.max(max, p);
            sum += p;
        }

        int min = Math.max(sum / h, 1);
        while (min < max) {
            int mid = min + (max - min) / 2;
            if (enough(mid, piles, h)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        return min;
    }

    private boolean enough(int n, int[] piles, int h) {
        for (int p : piles) {
            h -= p / n + (p % n == 0 ? 0 : 1);

            if (h < 0) {
                return false;
            }
        }

        return true;
    }
}
