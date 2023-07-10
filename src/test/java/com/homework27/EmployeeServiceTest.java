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
            Employee employee = out.add("Ivan", "Ivanov", 100_000, 1);
            assertEquals("Ivan", employee.getFirstName());
            assertEquals("Ivanov", employee.getLastName());
            assertEquals(1, employee.getSalary());
            assertEquals(100000, employee.getDepartment());
        }

        @Test
        void testFindEmployee() {
            Employee employee1 = out.add("Ivan", "Ivanov", 100_000, 1);
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
            out.add("Ivan", "Ivanov", 100_000, 1);
            assertThrows(EmployeeAlreadyAddedException.class,
                    () -> out.add("Ivan", "Ivanov", 100_000, 1));
        }
        @Test
        public void testInvalidInputException(){
            assertThrows(invalidInputExcetnion.class,
                    () -> out.add("Ivan123", "Ivanov", 100_000, 1));
        }
    }



