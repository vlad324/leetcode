package io.github.vlad324.n1189;

/**
 * {@link "https://leetcode.com/problems/maximum-number-of-balloons/"}
 */
class Solution {
    public int maxNumberOfBalloons(String text) {
        final var counts = new int[5];
        for (final var c : text.toCharArray()) {
            switch (c) {
                case 'b':
                    counts[0]++;
                    break;
                case 'a':
                    counts[1]++;
                    break;
                case 'l':
                    counts[2]++;
                    break;
                case 'o':
                    counts[3]++;
                    break;
                case 'n':
                    counts[4]++;
                    break;
            }
        }

        counts[2] /= 2;
        counts[3] /= 2;

        int min = counts[0];
        for (final var c : counts) {
            min = Math.min(min, c);
        }

        return min;
    }
}
