package io.github.vlad324;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class OpenTheLock {

    private static final int INITIAL = 0;

    public int openLock(String[] deadends, String target) {
        final var deadendsSet = new HashSet<Integer>();
        for (final String deadend : deadends) {
            deadendsSet.add(Integer.parseInt(deadend));
        }

        if (deadendsSet.contains(INITIAL)) {
            return -1;
        }

        final Queue<Integer> queue = new LinkedList<>();
        final int[] distances = new int[10_000];

        queue.offer(INITIAL);
        distances[INITIAL] = 0;

        final var targetInt = Integer.parseInt(target);
        while (!queue.isEmpty()) {
            final var poll = queue.poll();
            for (int i : getConnected(poll, deadendsSet)) {
                if (distances[i] == 0 && i != INITIAL) {
                    distances[i] = distances[poll] + 1;
                    queue.add(i);

                    if (i == targetInt) {
                        return distances[i];
                    }
                }
            }
        }

        return -1;
    }

    private List<Integer> getConnected(Integer input, Set<Integer> deadends) {
        final var result = new ArrayList<Integer>();
        final var inputArray = toArray(input);
        for (int j = 0; j < 4; j++) {
            final var upArray = Arrays.copyOf(inputArray, 4);
            final var downArray = Arrays.copyOf(inputArray, 4);

            if (upArray[j] == 9) {
                upArray[j] = 0;
            } else {
                upArray[j] += 1;
            }

            if (downArray[j] == 0) {
                downArray[j] = 9;
            } else {
                downArray[j] -= 1;
            }

            final int up = toInt(upArray);
            if (!deadends.contains(up)) {
                result.add(up);
            }

            final int down = toInt(downArray);
            if (!deadends.contains(down)) {
                result.add(down);
            }
        }

        return result;
    }

    private int[] toArray(int i) {
        var s = Integer.toString(i);
        if (i >= 0 && i < 10) {
            s = "000" + s;
        } else if (i >= 10 && i < 100) {
            s = "00" + s;
        } else if (i >= 100 && i < 1000) {
            s = "0" + s;
        }

        return s.chars().map(c -> c - '0').toArray();
    }

    private int toInt(int[] array) {
        return array[0] * 1000 + array[1] * 100 + array[2] * 10 + array[3];
    }

    // second solution

    private static final String INITIAL_S = "0000";

    public int openLock2(String[] deadends, String target) {
        final var deadendsSet = new HashSet<>(Arrays.asList(deadends));

        if (deadendsSet.contains(INITIAL_S)) {
            return -1;
        }

        final var queue = new LinkedList<String>();
        final var visited = new HashSet<String>();

        queue.offer(INITIAL_S);
        visited.add(INITIAL_S);

        int steps = 0;
        while (!queue.isEmpty()) {
            steps++;
            final var size = queue.size();
            for (int i = 0; i < size; i++) {
                final var poll = queue.poll();
                for (String s : getConnected(poll, deadendsSet)) {
                    if (!visited.contains(s)) {
                        if (s.equals(target)) {
                            return steps;
                        }

                        visited.add(s);
                        queue.add(s);
                    }
                }
            }
        }

        return -1;
    }

    private List<String> getConnected(String input, Set<String> deadends) {
        final var result = new ArrayList<String>();
        for (int i = 0; i < 4; i++) {
            final var up = new StringBuilder(input);
            final var down = new StringBuilder(input);

            if (up.charAt(i) == '9') {
                up.setCharAt(i, '0');
            } else {
                up.setCharAt(i, (char) (up.charAt(i) + 1));
            }

            if (down.charAt(i) == '0') {
                down.setCharAt(i, '9');
            } else {
                down.setCharAt(i, (char) (down.charAt(i) - 1));
            }

            final var upString = up.toString();
            if (!deadends.contains(upString)) {
                result.add(upString);
            }

            final var downString = down.toString();
            if (!deadends.contains(downString)) {
                result.add(downString);
            }
        }

        return result;
    }
}
