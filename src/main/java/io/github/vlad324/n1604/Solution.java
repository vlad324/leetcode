package io.github.vlad324.n1604;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

/**
 * {@link "https://leetcode.com/problems/alert-using-same-key-card-three-or-more-times-in-a-one-hour-period/"}
 */
class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {

        final var map = new HashMap<String, TreeSet<String>>();
        for (int i = 0; i < keyName.length; i++) {
            final var times = map.computeIfAbsent(keyName[i], k -> new TreeSet<>());
            times.add(keyTime[i]);
        }

        final var result = new LinkedList<String>();
        for (final var entry : map.entrySet()) {
            final var value = entry.getValue();
            if (value.size() > 2 && isAlerted(value)) {
                result.add(entry.getKey());
            }
        }

        Collections.sort(result);

        return result;
    }

    private boolean isAlerted(TreeSet<String> value) {
        var t1 = value.pollFirst();
        var t2 = value.pollFirst();

        while (!value.isEmpty()) {
            final var t3 = value.pollFirst();
            if (lessThanHour(t3, t1)) {
                return true;
            }

            t1 = t2;
            t2 = t3;
        }

        return false;
    }

    private boolean lessThanHour(String t3, String t1) {
        final var t3hours = Integer.parseInt(t3, 0, 2, 10);
        final var t1hours = Integer.parseInt(t1, 0, 2, 10);

        if (t3hours == t1hours) {
            return true;
        }

        if (t3hours - t1hours > 1) {
            return false;
        }

        final var t3minutes = Integer.parseInt(t3, 3, 5, 10) + 60;
        final var t1minutes = Integer.parseInt(t1, 3, 5, 10);

        return t3minutes - t1minutes <= 60;
    }
}