package io.github.vlad324.n341;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * {@link "https://leetcode.com/problems/flatten-nested-list-iterator/"}
 */
class NestedIterator implements Iterator<Integer> {

    private final List<NestedInteger> list;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.list = new LinkedList<>(nestedList);
    }

    @Override
    public Integer next() {
        return list.remove(0).getInteger();
    }

    @Override
    public boolean hasNext() {
        if (!list.isEmpty()) {
            if (list.get(0).isInteger()) {
                return true;
            }

            final var subList = list.remove(0).getList();
            list.addAll(0, subList);

            return hasNext();
        }

        return false;
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
