package com.company.service;

import com.company.model.Department;
import com.company.model.Employee;
import com.company.model.EmployeeStatus;
import com.company.repository.EmployeeRepository;
import com.company.validation.ValidationUtil;

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

        if (!ValidationUtil.isValidAge(employee.getAge())) {
            System.out.println("Invalid employee age.");
            return false;
        }

        if (!ValidationUtil.isValidEmail(employee.getEmail())) {
            System.out.println("Invalid email address.");
            return false;
        }

        if (!ValidationUtil.isValidPhone(employee.getPhone())) {
            System.out.println("Invalid phone number.");
            return false;
        }

        if (!ValidationUtil.isValidSalary(employee.getSalary())) {
            System.out.println("Invalid salary.");
            return false;
        }

        repository.save(employee);
        return true;
    }

    /**
     * Get Employee By ID
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
     * Update Employee
     */
    public boolean updateEmployee(Employee employee) {

        if (!repository.existsById(employee.getId())) {
            System.out.println("Employee not found.");
            return false;
        }

        if (!ValidationUtil.isValidAge(employee.getAge())) {
            System.out.println("Invalid employee age.");
            return false;
        }

        if (!ValidationUtil.isValidEmail(employee.getEmail())) {
            System.out.println("Invalid email address.");
            return false;
        }

        if (!ValidationUtil.isValidPhone(employee.getPhone())) {
            System.out.println("Invalid phone number.");
            return false;
        }

        if (!ValidationUtil.isValidSalary(employee.getSalary())) {
            System.out.println("Invalid salary.");
            return false;
        }

        repository.update(employee);
        return true;
    }

    /**
     * Delete Employee
     */
    public boolean deleteEmployee(int id) {
        return repository.delete(id);
    }

    /**
     * Get Employee Count
     */
    public int getEmployeeCount() {
        return repository.count();
    }

    /**
     * Search Employees By Department
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
     * Search Employees By Status
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
     * Sort Employees By Name
     */
    public List<Employee> sortByName() {

        List<Employee> employees = new ArrayList<>(repository.findAll());

        employees.sort(
                Comparator.comparing(Employee::getFirstName)
                          .thenComparing(Employee::getLastName));

        return employees;
    }

    /**
     * Sort Employees By Salary
     */
    public List<Employee> sortBySalary() {

        List<Employee> employees = new ArrayList<>(repository.findAll());

        employees.sort(
                Comparator.comparingDouble(Employee::getSalary));

        return employees;
    }

    /**
     * Get Highest Salary Employee
     */
    public Employee getHighestSalaryEmployee() {

        return repository.findAll()
                .stream()
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElse(null);
    }

    /**
     * Get Lowest Salary Employee
     */
    public Employee getLowestSalaryEmployee() {

        return repository.findAll()
                .stream()
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElse(null);
    }

    /**
     * Check Employee Exists
     */
    public boolean employeeExists(int id) {
        return repository.existsById(id);
    }
}
