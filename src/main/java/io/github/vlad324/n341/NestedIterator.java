package io.github.vlad324.n341;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * {@link "https://leetcode.com/problems/flatten-nested-list-iterator/"}
 */
class NestedIterator implements Iterator<Integer> {

    private int index = 0;
    private final List<Integer> result = new ArrayList<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        for (final var n : nestedList) {
            flatten(n);
        }
    }

    @Override
    public Integer next() {
        return result.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index < result.size();
    }

    private void flatten(NestedInteger nestedInteger) {
        if (nestedInteger.isInteger()) {
            result.add(nestedInteger.getInteger());
        } else {
            for (final var n : nestedInteger.getList()) {
                flatten(n);
            }
        }
    }

    public interface NestedInteger {

        /**
         * @return true if this NestedInteger holds a single integer, rather than a nested list.
         */
        boolean isInteger();

        /**
         * @return the single integer that this NestedInteger holds, if it holds a single integer
         * Return null if this NestedInteger holds a nested list
         */
        Integer getInteger();

        /**
         * @return the nested list that this NestedInteger holds, if it holds a nested list
         * Return empty list if this NestedInteger holds a single integer
         */
        List<NestedInteger> getList();
    }
}
