package com.homework27.service;

import com.homework27.exception.EmployeeAlreadyAddedException;
import com.homework27.exception.EmployeeNotFoundException;
import com.homework27.exception.EmployeeStorageIsFullException;
import com.homework27.exception.invalidInputExcetnion;
import com.homework27.model.Employee;
import org.springframework.stereotype.Service;

import java.util.*;

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

//@Service
//public class EmployeeService {
//    private final Map<String, Employee> employees = new HashMap<String, Employee>();
//    private final static int MAX_SIZE = 5;

//    public Employee add(Employee employee) {
//        validateInput(employee.getFirstName(), employee.getLastName());
//
//        if (employees.size() >= MAX_SIZE) {
//            throw new EmployeeStorageIsFullException();
//        }
//
//        String key = createKey(employee.getFirstName(), employee.getLastName());
//
//        if (employees.containsKey(key)) {
//            throw new EmployeeAlreadyAddedException();
//        }
//
//        employees.put(key, employee);
//        return employee;
//    }
//    public Employee add(Employee employee) {
//
//        if (!isAlpha(employee.getFirstName()) && !isAlpha(employee.getLastName())) {
//            throw new invalidInputExcetnion();
//        }
//
//        String key = createKey(employee.getFirstName(), employee.getLastName());
//
//        if (employees.containsKey(key)) {
//            throw new EmployeeAlreadyAddedException("Сотрудник уже существует");
//        }
//        if (employees.size() >= MAX_SIZE) {
//            throw new EmployeeStorageIsFullException("Коллекция сотрудников переполнена");
//        }
//        employees.put(createKey(employee.getFirstName(), employee.getLastName()), employee);
//        return employee;
//    }
//
//    public Employee remove(String firstName, String lastName) {
//        validateInput(firstName, lastName);
//
//        String key = createKey(firstName, lastName);
//
//        if (!employees.containsKey(key)) {
//            throw new EmployeeNotFoundException();
//        }
//        return employees.remove(key);
//    }
//
//    public Employee find(String firstName, String lastName) {
//        validateInput(firstName, lastName);
//
//        String key = createKey(firstName, lastName);
//
//        if (!employees.containsKey(key)) {
//            throw new EmployeeNotFoundException();
//        }
//        return employees.get(key);
//    }
//
//    public List<Employee> getAll() {
//        return Collections.unmodifiableList(new ArrayList<Employee>(employees.values()));
//    }
//
//    private static String createKey(String firstName, String lastName) {
//        return (firstName + lastName).toLowerCase();
//    }
//
//    private void validateInput(String firstName, String lastName) {
//        if (!(isAlpha(firstName) && isAlpha(lastName))) {
//            throw new invalidInputExcetnion();
//        }
//    }
//
//    private boolean isAlpha(String name) {
//        return name.matches("[a-zA-Z]+");
//    }
//
//
//}
