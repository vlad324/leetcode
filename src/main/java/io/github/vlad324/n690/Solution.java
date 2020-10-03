package io.github.vlad324.n690;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        final var map = new HashMap<Integer, Employee>();
        for (final var e : employees) {
            map.put(e.id, e);
        }

        return importance(map, id);
    }

    private int importance(HashMap<Integer, Employee> employees, int id) {
        int i = employees.get(id).importance;
        for (final var s : employees.get(id).subordinates) {
            i += importance(employees, s);
        }

        return i;
    }


    static class Employee {
        public final int id;
        public final int importance;
        public final List<Integer> subordinates;

        Employee(int id, int importance) {
            this(id, importance, Collections.emptyList());
        }

        Employee(int id, int importance, List<Integer> subordinates) {
            this.id = id;
            this.importance = importance;
            this.subordinates = subordinates;
        }
    }
}
