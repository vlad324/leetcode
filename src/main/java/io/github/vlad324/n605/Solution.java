package io.github.vlad324.n605;

/**
 * {@link "https://leetcode.com/problems/can-place-flowers/"}
 */
class Solution {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        boolean previousNeighbour = false;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                if (!previousNeighbour && !hasNext(flowerbed, i)) {
                    n--;
                    previousNeighbour = true;
                } else {
                    previousNeighbour = false;
                }
            } else {
                previousNeighbour = true;
            }

            if (n <= 0) {
                return true;
            }
        }

        return false;
    }

    private boolean hasNext(int[] flowerbed, int i) {
        return i < flowerbed.length - 1 && flowerbed[i + 1] == 1;
    }
}
