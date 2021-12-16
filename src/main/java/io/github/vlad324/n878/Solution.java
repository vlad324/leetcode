package io.github.vlad324.n878;

/**
 * {@link "https://leetcode.com/problems/nth-magical-number/"}
 */
class Solution {

    private static final int MAX = 1_000_000_007;

    public int nthMagicalNumber(int N, int A, int B) {
        int L = A / gcd(A, B) * B;

        long left = 0;
        long right = (long) N * Math.min(A, B);
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (mid / A + mid / B - mid / L < N)
                left = mid + 1;
            else
                right = mid;
        }

        return (int) (left % MAX);
    }

    public int gcd(int x, int y) {
        if (x == 0) {
            return y;
        }

        return gcd(y % x, x);
    }

}
