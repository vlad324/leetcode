package io.github.vlad324.n190;

/**
 * {@link "https://leetcode.com/problems/reverse-bits/"}
 */
public class Solution {
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            if ((n & 1) == 1) {
                result++;
            }
            n >>>= 1;
        }

        return result;
    }

    public int reverseBits2(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) == 0) {
                continue;
            }

            result = result | (1 << (31 - i));
        }

        return result;
    }
}
