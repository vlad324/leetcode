package io.github.vlad324.n923;

import java.util.Arrays;

/**
 * {@link "https://leetcode.com/problems/3sum-with-multiplicity/"}
 */
class Solution {

    private static final int MAX = 1000000007;

    public int threeSumMulti(int[] arr, int target) {
        Arrays.sort(arr);

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int j = i + 1;
            int k = arr.length - 1;

            while (j < k) {
                if (arr[i] + arr[j] + arr[k] > target) {
                    k--;
                } else if (arr[i] + arr[j] + arr[k] < target) {
                    j++;
                } else if (arr[j] == arr[k]) {
                    int jCount = 1;
                    while (j < arr.length - 1 && arr[j] == arr[j + 1]) {
                        count += jCount;
                        jCount++;
                        j++;
                    }
                } else {
                    int jCount = 1;
                    while (arr[j] == arr[j + 1]) {
                        jCount++;
                        j++;
                    }

                    int kCount = 1;
                    while (arr[k] == arr[k - 1]) {
                        kCount++;
                        k--;
                    }

                    count += jCount * kCount;
                    j++;
                    k--;
                }
            }
            count %= MAX;
        }

        return count;
    }
}
