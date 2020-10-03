package io.github.vlad324.n380;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * {@link "https://leetcode.com/problems/insert-delete-getrandom-o1/"}
 */
class RandomizedSet {

    private final Map<Integer, Integer> valuesMap;
    private final List<Integer> valuesList;
    private final Random random;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        this.valuesMap = new HashMap<>();
        this.valuesList = new ArrayList<>();
        this.random = new Random();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (valuesMap.containsKey(val)) {
            return false;
        }

        valuesMap.put(val, valuesList.size());
        valuesList.add(val);

        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!valuesMap.containsKey(val)) {
            return false;
        }

        final var index = valuesMap.remove(val);

        final var lastIndex = valuesList.size() - 1;
        if (index == lastIndex) {
            valuesList.remove((int) index);
        } else {
            final var lastElement = valuesList.remove(lastIndex);
            valuesMap.put(lastElement, index);
            valuesList.set(index, lastElement);
        }

        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return valuesList.get(random.nextInt(valuesList.size()));
    }
}
