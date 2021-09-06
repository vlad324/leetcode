package io.github.vlad324.n1629;

/**
 * {@link "https://leetcode.com/problems/slowest-key/"}
 */
class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char result = ' ';
        int maxDuration = 0;
        int previous = 0;
        for (int i = 0; i < releaseTimes.length; i++) {
            int d = releaseTimes[i] - previous;
            if (d > maxDuration || (d == maxDuration && keysPressed.charAt(i) > result)) {
                maxDuration = d;
                result = keysPressed.charAt(i);
            }

            previous = releaseTimes[i];
        }

        return result;
    }
}
