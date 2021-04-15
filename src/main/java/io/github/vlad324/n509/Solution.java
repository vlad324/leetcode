package io.github.vlad324.n509;

/**
 * {@link "https://leetcode.com/problems/fibonacci-number/"}
 */
class Solution {
    public int fib(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }

        if (n == 0) {
            return 0;
        }

        return fib(n - 1) + fib(n - 2);
    }
}
