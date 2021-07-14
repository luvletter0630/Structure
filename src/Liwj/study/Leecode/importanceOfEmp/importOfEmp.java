package Liwj.study.Leecode.importanceOfEmp;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2021/5/1.
 */
public class importOfEmp {
}

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};


class Solution {
    int result;
    Map<Integer, Employee> emp = new HashMap();

    public int getImportance(List<Employee> employees, int id) {
        if (emp.size() == 0) {
            setEmp(employees);
        }
        Employee currentEmp = emp.get(id);
        result += currentEmp.importance;
        if (currentEmp.subordinates.size() > 0) {
            for (int i : currentEmp.subordinates) {
                getImportance(employees, i);
            }
        }
        return result;
    }

    public void setEmp(List<Employee> employees) {
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            emp.put(employee.id, employee);
        }
    }
}