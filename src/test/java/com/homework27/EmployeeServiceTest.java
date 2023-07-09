package com.homework27;

import com.homework27.exception.EmployeeAlreadyAddedException;
import com.homework27.exception.EmployeeNotFoundException;
import com.homework27.exception.EmployeeStorageIsFullException;
import com.homework27.model.Employee;
import com.homework27.service.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.apache.coyote.http11.Constants.a;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceTest {

    EmployeeService employeeService = new EmployeeService();

//    @Test
//    void whenFullThenThrowException() {
//        for (int i = 0; i < 5; i++) {
//            char additionChar = (char) ('a' + i);
//            Employee employee = new Employee("first_Name,", "last_name", 1, 23456);
//            employeeService.add(employee);
//        }
//        assertThrows(EmployeeStorageIsFullException.class,
//                () -> employeeService.add("first_Name,", "last_name", 1, 23456));
//    }
//
//    @Test
//    void whenNotUniqThenThrowException() {
//        Employee employee = new Employee("first_Name", "last_name", 1, 25500);
//        employeeService.add(employee);
//
//        assertThrows(EmployeeAlreadyAddedException.class,
//                ()->employeeService.add(employee));
//    }
//
//    @Test
//    void addPositive() {
//        Employee employee = new Employee("first_Name", "last_name", 1, 25500);
//        employeeService.add(employee);
//        assertTrue(employeeService.getAll().contains(employee));
//    }
//
//    @Test
//    void findPositive() {
//        Employee employee = new Employee("first_Name", "last_name", 1, 25500);
//        employeeService.add(employee);
//        Employee actual = employeeService.find("first_Name", "last_name");
//        assertNotNull(actual);
//        assertEquals(employee, actual);
//    }
//    @Test
//    void findNegative() {
//        Employee employee = new Employee("first_Name", "last_name", 1, 25500);
//        employeeService.add(employee);
//
//        assertThrows(EmployeeNotFoundException.class, () -> employeeService.find("not_first_Name", "not_last_name"));
//    }
//    @Test
//    void removePositive(){
//        Employee employee = new Employee("first_Name", "last_name", 1, 25500);
//        employeeService.add(employee);
//
//        Employee actual = employeeService.remove("first_Name", "last_name");
//
//        assertFalse(employeeService.getAll().contains(employee));
//    }
//
//    @Test
//    void removeNegative(){
//        Employee employee = new Employee("first_Name", "last_name", 1, 25500);
//        employeeService.add(employee);
//
//        Employee actual = employeeService.remove("not_first_Name", "not_last_name");
//        assertNull(actual);
//    }
}
