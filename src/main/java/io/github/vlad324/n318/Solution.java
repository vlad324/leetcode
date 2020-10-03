package io.github.vlad324.n318;

/**
 * {@link "https://leetcode.com/problems/maximum-product-of-word-lengths/"}
 */
class Solution {

    public static void main(String[] args) {
        System.out.println(2 << 3);
    }

    public int maxProduct(String[] words) {
        if (words == null || words.length < 2) {
            return 0;
        }

        final var bits = new int[words.length];
        for (int i = 0; i < bits.length; i++) {
            for (char ch : words[i].toCharArray()) {
                bits[i] |= 1 << ch - 'a';
            }
        }

        int max = 0;
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((bits[i] & bits[j]) == 0) {
                    max = Math.max(words[i].length() * words[j].length(), max);
                }
            }
        }
        return max;
    }
}
