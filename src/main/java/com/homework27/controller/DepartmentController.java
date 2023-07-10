package com.homework27.controller;

import com.homework27.model.Employee;
import com.homework27.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public double getEmployeeMaxSalary(@RequestParam("departmentId") int department) {
        return departmentService.getEmployeeMaxSalary(department);
    }
    @GetMapping("/min-salary")
    public double getEmployeeMinSalary(@RequestParam("departmentId") int department) {
        return departmentService.getEmployeeMinSalary(department);
    }
    @GetMapping("/sum")
    public double getEmployeeSalarySum(@RequestParam("departmentId") int department) {
        return departmentService.getEmployeeSalarySum(department);
    }
    @GetMapping(value ="/all", params = "departamentId")
    public List<Employee> getAll(@RequestParam("departmentId")int department) {
        return departmentService.getAll(department);
    }
    @GetMapping("/all")
    private Map<Integer, List<Employee>> getAll() {
        return departmentService.getAll();
    }


//по домашнему заданию с тестами

    @GetMapping("/{id}/employees")
    public List<Employee> getEmployeesByDepartmentId(@PathVariable("id") int departmentId) {
        return departmentService.getAll(departmentId);
    }

    @GetMapping("/{id}/salary/sum")
    public double getSalarySumByDepartmentId(@PathVariable("id") int departmentId) {
        return departmentService.getEmployeeSalarySum(departmentId);
    }

    @GetMapping("/{id}/salary/max")
    public double getMaxSalaryByDepartmentId(@PathVariable("id") int departmentId) {
        return departmentService.getEmployeeMaxSalary(departmentId);
    }

    @GetMapping("/{id}/salary/min")
    public double getMinSalaryByDepartmentId(@PathVariable("id") int departmentId) {
        return departmentService.getEmployeeMinSalary(departmentId);
    }

    @GetMapping("/employees")
    public Map<Integer, List<Employee>> getAllEmployeesByDepartment() {
        return departmentService.getAll();
    }


}
