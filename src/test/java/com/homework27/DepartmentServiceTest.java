package com.homework27;

import com.homework27.model.Employee;
import com.homework27.service.DepartmentService;
import com.homework27.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {
    public static final Collection<Employee> EMPLOYEES = Arrays.asList(
            new Employee("Alexei", "Alexeev", 1, 15000),
            new Employee("Boris", "Borisov", 1, 15000),
            new Employee("Valeryi", "Valeriev", 2, 15000),
            new Employee("Georgyi", "Georgyev", 2, 30000),
            new Employee("Dmitryi", "Dmitryev", 3, 15000)
    );
    @Mock
    EmployeeService employeeService;
    @InjectMocks
    DepartmentService departmentService;

    @BeforeEach
    void init() {
        when(employeeService.getAll()).thenReturn((List<Employee>) EMPLOYEES);
    }

    @Test
    void sum() {
        double actual = departmentService.getEmployeeSalarySum(1);
        assertEquals(30000.0, actual);
    }

    @Test
    void max() {
        double actual = departmentService.getEmployeeMaxSalary(2);
        assertEquals(30000, actual);
    }

    @Test
    void min() {
        double actual = departmentService.getEmployeeMinSalary(2);
        assertEquals(15000, actual);
    }

    @Test
    void getAllDepartment() {
        List<Employee> actual = departmentService.getAll(3);
        Collection<Employee> excpected = Collections.singletonList(new Employee("Dmitryi", "Dmitryev", 3, 15000));
        assertIterableEquals(excpected, actual);
    }

    @Test
    void getAll() {
        Map<Integer, List<Employee>> actual = departmentService.getAll();

        Employee Dmitryi = new Employee("Dmitryi", "Dmitryev", 3, 15000);
        assertTrue(actual.get(3).contains(Dmitryi));
        assertFalse(actual.get(2).contains(Dmitryi));

        assertEquals(3,actual.keySet().size());
    }


}
