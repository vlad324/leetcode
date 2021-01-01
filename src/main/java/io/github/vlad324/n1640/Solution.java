package io.github.vlad324.n1640;

/**
 * {@link "https://leetcode.com/problems/check-array-formation-through-concatenation/"}
 */
class Solution {

    public boolean canFormArray(int[] arr, int[][] pieces) {
        for (int i = 0; i < arr.length; i++) {
            boolean found = false;
            for (int j = 0; j < pieces.length; j++) {
                if (pieces[j] != null && pieces[j][0] == arr[i]) {
                    int k = 1;
                    while (k < pieces[j].length) {
                        if (pieces[j][k] != arr[++i]) {
                            return false;
                        }
                        k++;
                    }

                    found = true;
                    pieces[j] = null;
                }
            }

            if (!found) {
                return false;
            }
        }

        return true;
    }
}
