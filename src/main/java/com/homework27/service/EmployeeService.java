package com.homework27.service;

import com.homework27.exception.EmployeeAlreadyAddedException;
import com.homework27.exception.EmployeeNotFoundException;
import com.homework27.exception.EmployeeStorageIsFullException;
import com.homework27.exception.invalidInputExcetnion;
import com.homework27.model.Employee;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import java.util.*;

import static org.apache.commons.lang3.StringUtils.isAlpha;

@Service
public class EmployeeService {
    private final Map<String, Employee> employees = new HashMap();
    private final static int MAX_SIZE = 5;
    public Employee add(String firstName, String lastName, int department, double salary) {
        validateInput(firstName, lastName);


        if (employees.size() >= MAX_SIZE) {
            throw  new EmployeeStorageIsFullException();
        }
        Employee employeeToAdd = new Employee(firstName, lastName, department, salary);

        if (employees.containsKey(creatKey(firstName, lastName))) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(creatKey(firstName, lastName), employeeToAdd);
        return employeeToAdd;
    }
    public Employee remove(String firstName, String lastName) {
        validateInput(firstName, lastName);

        if (!employees.containsKey(creatKey(firstName, lastName))) {
            throw new EmployeeNotFoundException();
        }
        return employees.remove(creatKey(firstName, lastName));
    }
    public Employee find(String firstName, String lastName) {
        validateInput(firstName, lastName);

        if (!employees.containsKey(creatKey(firstName, lastName))) {
            throw new EmployeeNotFoundException();
        }
        return employees.get(creatKey(firstName, lastName));
    }
    public List<Employee> getAll() {
        return Collections.unmodifiableList(new ArrayList<>(employees.values()));
    }
    private static String creatKey(String firstName, String lastName) {
        return (firstName + lastName).toLowerCase();
    }

    private void validateInput(String firstName, String lastName) {
        if (!(isAlpha(firstName) && isAlpha(lastName))) {
            throw new invalidInputExcetnion();
        }
    }
}
