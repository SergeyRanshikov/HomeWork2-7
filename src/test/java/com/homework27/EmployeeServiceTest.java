package com.homework27;

import com.homework27.exception.EmployeeAlreadyAddedException;
import com.homework27.exception.EmployeeNotFoundException;
import com.homework27.exception.invalidInputExcetnion;
import com.homework27.model.Employee;
import com.homework27.service.EmployeeService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceTest {
    private final EmployeeService out = new EmployeeService();

        @Test
        void testAddEmployee() {
            Employee employee = out.add("Ivan", "Ivanov", 1, 100000);
            assertEquals("Ivan", employee.getFirstName());
            assertEquals("Ivanov", employee.getLastName());
            assertEquals(100000, employee.getSalary());
            assertEquals(1, employee.getDepartment());
        }

        @Test
        void testFindEmployee() {
            Employee employee1 = out.add("Ivan", "Ivanov", 1, 100000);
            Employee employee2 = out.find("Ivan", "Ivanov");
            assertEquals(employee1, employee2);
        }
        @Test
        public void testEmployeeNotFoundException() {
            assertThrows(EmployeeNotFoundException.class,
                    () -> out.remove("Egor", "Egorov"));
        }

        @Test
        public void testEmployeeAlreadyAddedException() {
            out.add("Ivan", "Ivanov", 1, 100000);
            assertThrows(EmployeeAlreadyAddedException.class,
                    () -> out.add("Ivan", "Ivanov", 1, 100000));
        }
        @Test
        public void testInvalidInputException(){
            assertThrows(invalidInputExcetnion.class,
                    () -> out.add("Ivan123", "Ivanov", 1, 100000));
        }
    @Test
    void testRemoveEmployee() {
        Employee employee = out.add("Ivan", "Ivanov", 1, 100000);

        Employee removedEmployee = out.remove("Ivan", "Ivanov");

        assertEquals("Ivan", removedEmployee.getFirstName());
        assertEquals("Ivanov", removedEmployee.getLastName());
        assertEquals(100000, removedEmployee.getSalary());
        assertEquals(1, removedEmployee.getDepartment());

        assertThrows(EmployeeNotFoundException.class, () -> out.find("Ivan", "Ivanov"));
    }
}



