package com.company.service;

import com.company.model.Department;
import com.company.model.Employee;
import com.company.model.EmployeeStatus;
import com.company.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    /**
     * Add Employee
     */
    public boolean addEmployee(Employee employee) {

        if (repository.existsById(employee.getId())) {
            System.out.println("Employee ID already exists.");
            return false;
        }

        if (employee.getAge() < 18) {
            System.out.println("Employee age must be at least 18.");
            return false;
        }

        if (employee.getSalary() <= 0) {
            System.out.println("Salary must be greater than zero.");
            return false;
        }

        repository.save(employee);
        return true;
    }

    /**
     * Get Employee by ID
     */
    public Employee getEmployee(int id) {
        return repository.findById(id);
    }

    /**
     * Get All Employees
     */
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    /**
     * Delete Employee
     */
    public boolean deleteEmployee(int id) {
        return repository.delete(id);
    }

    /**
     * Update Employee
     */
    public boolean updateEmployee(Employee employee) {

        if (!repository.existsById(employee.getId())) {
            return false;
        }

        repository.update(employee);
        return true;
    }

    /**
     * Total Employees
     */
    public int getEmployeeCount() {
        return repository.count();
    }

    /**
     * Search By Department
     */
    public List<Employee> getEmployeesByDepartment(Department department) {

        List<Employee> result = new ArrayList<>();

        for (Employee employee : repository.findAll()) {

            if (employee.getDepartment() == department) {
                result.add(employee);
            }

        }

        return result;
    }

    /**
     * Search By Status
     */
    public List<Employee> getEmployeesByStatus(EmployeeStatus status) {

        List<Employee> result = new ArrayList<>();

        for (Employee employee : repository.findAll()) {

            if (employee.getStatus() == status) {
                result.add(employee);
            }

        }

        return result;
    }

    /**
     * Sort By Name
     */
    public List<Employee> sortByName() {

        List<Employee> employees = new ArrayList<>(repository.findAll());

        employees.sort(
                Comparator.comparing(Employee::getFirstName)
                          .thenComparing(Employee::getLastName));

        return employees;
    }

    /**
     * Sort By Salary
     */
    public List<Employee> sortBySalary() {

        List<Employee> employees = new ArrayList<>(repository.findAll());

        employees.sort(
                Comparator.comparingDouble(Employee::getSalary));

        return employees;
    }

    /**
     * Highest Salary Employee
     */
    public Employee getHighestSalaryEmployee() {

        return repository.findAll()
                .stream()
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElse(null);
    }

    /**
     * Lowest Salary Employee
     */
    public Employee getLowestSalaryEmployee() {

        return repository.findAll()
                .stream()
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElse(null);
    }
}
