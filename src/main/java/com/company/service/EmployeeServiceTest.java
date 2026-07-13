package com.company.service;

import com.company.model.Address;
import com.company.model.Department;
import com.company.model.Employee;
import com.company.model.EmployeeStatus;
import com.company.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceTest {

    private EmployeeService service;

    @BeforeEach
    void setup() {

        EmployeeRepository repository = new EmployeeRepository();

        service = new EmployeeService(repository);

        service.addEmployee(
                new Employee(
                        101,
                        "John",
                        "Doe",
                        28,
                        "john@gmail.com",
                        "9876543210",
                        Department.IT,
                        50000,
                        EmployeeStatus.ACTIVE,
                        new Address(
                                "Street 1",
                                "Hyderabad",
                                "Telangana",
                                "India",
                                "500001"
                        )
                )
        );

    }

    @Test
    void testAddEmployee() {

        Employee employee = new Employee(
                102,
                "David",
                "Smith",
                30,
                "david@gmail.com",
                "9999999999",
                Department.HR,
                60000,
                EmployeeStatus.ACTIVE,
                new Address(
                        "Road 2",
                        "Bangalore",
                        "Karnataka",
                        "India",
                        "560001"
                )
        );

        assertTrue(service.addEmployee(employee));

    }

    @Test
    void testDuplicateEmployee() {

        Employee employee = new Employee(
                101,
                "Duplicate",
                "User",
                25,
                "dup@gmail.com",
                "9999999998",
                Department.IT,
                50000,
                EmployeeStatus.ACTIVE,
                new Address(
                        "Street",
                        "City",
                        "State",
                        "India",
                        "111111"
                )
        );

        assertFalse(service.addEmployee(employee));

    }

    @Test
    void testFindEmployee() {

        Employee employee = service.getEmployee(101);

        assertNotNull(employee);

        assertEquals("John", employee.getFirstName());

    }

    @Test
    void testDeleteEmployee() {

        assertTrue(service.deleteEmployee(101));

    }

    @Test
    void testEmployeeCount() {

        assertEquals(1, service.getEmployeeCount());

    }

    @Test
    void testDepartmentSearch() {

        List<Employee> list =
                service.getEmployeesByDepartment(Department.IT);

        assertEquals(1, list.size());

    }

    @Test
    void testStatusSearch() {

        List<Employee> list =
                service.getEmployeesByStatus(EmployeeStatus.ACTIVE);

        assertEquals(1, list.size());

    }

    @Test
    void testHighestSalary() {

        Employee employee = service.getHighestSalaryEmployee();

        assertNotNull(employee);

    }

    @Test
    void testLowestSalary() {

        Employee employee = service.getLowestSalaryEmployee();

        assertNotNull(employee);

    }

    @Test
    void testSortByName() {

        List<Employee> list = service.sortByName();

        assertFalse(list.isEmpty());

    }

    @Test
    void testSortBySalary() {

        List<Employee> list = service.sortBySalary();

        assertFalse(list.isEmpty());

    }

}
