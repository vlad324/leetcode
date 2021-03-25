package io.github.vlad324.n870;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * {@link "https://leetcode.com/problems/advantage-shuffle/"}
 */
class Solution {
    public int[] advantageCount(int[] A, int[] B) {
        final var bCopy = B.clone();
        Arrays.sort(A);
        Arrays.sort(B);

        final var remaining = new ArrayList<Integer>();
        final var assigned = new HashMap<Integer, List<Integer>>();
        int j = 0;
        for (final int k : A) {
            if (k > B[j]) {
                assigned.computeIfAbsent(B[j], __ -> new ArrayList<>()).add(k);
                j++;
            } else {
                remaining.add(k);
            }
        }

        final var result = new int[A.length];
        for (int i = 0; i < bCopy.length; i++) {
            final var queue = assigned.get(bCopy[i]);
            if (queue != null && !queue.isEmpty()) {
                result[i] = queue.remove(0);
            } else {
                result[i] = remaining.remove(0);
            }
        }

        return result;
    }
}

