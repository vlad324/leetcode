package io.github.vlad324.n341;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.List;

/**
 * {@link "https://leetcode.com/problems/flatten-nested-list-iterator/"}
 */
class NestedIterator implements Iterator<Integer> {

    private final ArrayDeque<NestedInteger> deque;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.deque = new ArrayDeque<>(nestedList);
    }

    @Override
    public Integer next() {
        return deque.poll().getInteger();
    }

    @Override
    public boolean hasNext() {
        if (!deque.isEmpty()) {
            if (deque.peek().isInteger()) {
                return true;
            }

            final var list = deque.poll().getList();
            for (int i = list.size() - 1; i >= 0; i--) {
                deque.offerFirst(list.get(i));
            }

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
