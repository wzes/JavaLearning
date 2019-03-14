package leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_690 {

    @Test
    public void Solution_690_Test() {

    }

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> relation = new HashMap<>();
        for (Employee employee : employees) {
            relation.put(employee.id, employee);
        }
        return dfs(relation, id);
    }

    private int dfs(Map<Integer, Employee> relation, int id) {
        Employee employee = relation.get(id);
        if (employee.subordinates == null || employee.subordinates.size() == 0) {
            return relation.get(id).importance;
        }
        int tmp = relation.get(id).importance;
        for (Integer e : employee.subordinates) {
            tmp += dfs(relation, e);
        }
        return tmp;
    }
}
