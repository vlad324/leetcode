package io.github.vlad324.n787n;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * {@link "https://leetcode.com/problems/cheapest-flights-within-k-stops/"}
 */
class Solution {

    private static final int FROM_INDEX = 0;
    private static final int TO_INDEX = 1;
    private static final int PRICE_INDEX = 2;

    private static final int[] DIVIDER = null;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        final var connectedMap = new HashMap<Integer, List<int[]>>();
        for (final int[] flight : flights) {
            final var from = flight[FROM_INDEX];
            if (connectedMap.containsKey(from)) {
                connectedMap.get(from).add(flight);
            } else {
                final var list = new LinkedList<int[]>();
                list.add(flight);
                connectedMap.put(from, list);
            }
        }

        int result = find(connectedMap, src, dst, k + 1);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int find(Map<Integer, List<int[]>> connected, int src, int dst, int k) {
        if (k < 0) {
            return Integer.MAX_VALUE;
        }

        if (src == dst) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for (int[] i : connected.getOrDefault(src, Collections.emptyList())) {
            int add = find(connected, i[TO_INDEX], dst, k - 1);
            if (add != Integer.MAX_VALUE) {
                min = Math.min(min, i[PRICE_INDEX] + add);
            }
        }

        return min;
    }

}
