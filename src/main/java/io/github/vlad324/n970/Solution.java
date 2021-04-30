package io.github.vlad324.n970;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * {@link "https://leetcode.com/problems/powerful-integers/"}
 */
class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        int a = (x == 1 ? 1 : (int) (Math.log(bound) / Math.log(x)));
        int b = (y == 1 ? 1 : (int) (Math.log(bound) / Math.log(y)));

        final var result = new HashSet<Integer>();

        int px = 1;
        for (int i = 0; i <= a; i++) {
            px *= (i == 0 ? 1 : x);
            int py = 1;
            for (int j = 0; j <= b; j++) {
                py *= (j == 0 ? 1 : y);
                int value = px + py;

                if (value <= bound) {
                    result.add(value);
                }
            }
        }

        return new ArrayList<>(result);
    }
}