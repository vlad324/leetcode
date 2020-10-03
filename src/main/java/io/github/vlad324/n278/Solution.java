package io.github.vlad324.n278;

class Solution {

    public int firstBadVersion(int n) {
        int min = 1;
        int max = n;
        while (min < max) {
            int mid = min + (max - min) / 2;
            if (isBadVersion(mid)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        return min;
    }

    private boolean isBadVersion(int version) {
        System.out.println(String.format("Call with %s", version));
        return version >= 2;
    }
}
