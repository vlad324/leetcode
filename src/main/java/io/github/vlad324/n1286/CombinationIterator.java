package io.github.vlad324.n1286;

/**
 * {@link "https://leetcode.com/problems/iterator-for-combination/"}
 */
class CombinationIterator {

    private final char[] letters;
    private final int combinationLength;
    private int mask;

    public CombinationIterator(String characters, int combinationLength) {
        this.letters = characters.toCharArray();
        this.combinationLength = combinationLength;
        this.mask = (1 << this.letters.length) - 1;
    }

    public String next() {
        if (!hasNext()) {
            return null;
        }

        final var result = new StringBuilder(combinationLength);
        for (int i = letters.length - 1; i >= 0; i--) {
            if ((mask & (1 << i)) != 0) {
                result.append(letters[letters.length - 1 - i]);
            }
        }
        mask--;

        return result.toString();
    }

    public boolean hasNext() {
        while (mask > 0 && Integer.bitCount(mask) != combinationLength) {
            mask--;
        }

        return mask > 0;
    }
}
