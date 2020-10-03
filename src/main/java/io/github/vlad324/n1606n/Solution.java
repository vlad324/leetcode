package io.github.vlad324.n1606n;

import java.util.LinkedList;
import java.util.List;

/**
 * {@link "https://leetcode.com/problems/find-servers-that-handled-most-number-of-requests/"}
 */
class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        final var requestCounts = new int[k];
        final var loading = new int[k];

        int maxRequestCount = 0;
        for (int i = 0; i < arrival.length; i++) {
            if (i != 0) {
                int diff = arrival[i] - arrival[i - 1];

                for (int j = 0; j < loading.length; j++) {
                    if (loading[j] != 0) {
                        loading[j] = Math.max(loading[j] - diff, 0);
                    }
                }
            }

            var serverIndex = i % k;
            serverIndex = findAvailableServerIndex(loading, serverIndex);

            if (serverIndex == -1) {
                continue;
            }

            loading[serverIndex] = load[i];
            requestCounts[serverIndex]++;

            maxRequestCount = Math.max(maxRequestCount, requestCounts[serverIndex]);
        }

        final var result = new LinkedList<Integer>();
        for (int i = 0; i < requestCounts.length; i++) {
            if (requestCounts[i] == maxRequestCount) {
                result.add(i);
            }
        }


        return result;
    }

    private int findAvailableServerIndex(int[] loading, int serverIndex) {
        for (int i = serverIndex; i < loading.length; i++) {
            if (loading[i] == 0) {
                return i;
            }
        }

        for (int i = 0; i < serverIndex; i++) {
            if (loading[i] == 0) {
                return i;
            }
        }

        return -1;
    }
}
