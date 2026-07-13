package com.company.repository;

import com.company.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {

    private final List<Employee> employees = new ArrayList<>();

    /**
     * Save Employee
     */
    public void save(Employee employee) {
        employees.add(employee);
    }

    /**
     * Find Employee By ID
     */
    public Employee findById(int id) {

        for (Employee employee : employees) {

            if (employee.getId() == id) {
                return employee;
            }

        }

        return null;
    }

    /**
     * Return All Employees
     */
    public List<Employee> findAll() {
        return employees;
    }

    /**
     * Delete Employee
     */
    public boolean delete(int id) {

        Employee employee = findById(id);

        if (employee != null) {
            employees.remove(employee);
            return true;
        }

        return false;
    }

    /**
     * Check Employee Exists
     */
    public boolean existsById(int id) {

        return findById(id) != null;

    }

    /**
     * Update Employee
     */
    public boolean update(Employee updatedEmployee) {

        for (int i = 0; i < employees.size(); i++) {

            if (employees.get(i).getId() == updatedEmployee.getId()) {

                employees.set(i, updatedEmployee);

                return true;

            }

        }

        return false;

    }

    /**
     * Total Employees
     */
    public int count() {

        return employees.size();

    }

}
