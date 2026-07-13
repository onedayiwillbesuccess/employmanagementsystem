package com.company;

import com.company.model.Address;
import com.company.model.Department;
import com.company.model.Employee;
import com.company.model.EmployeeStatus;
import com.company.repository.EmployeeRepository;
import com.company.service.EmployeeService;
import com.company.util.ConsolePrinter;
import com.company.util.InputUtil;

import java.util.List;

public class App {

    private static final EmployeeRepository repository = new EmployeeRepository();
    private static final EmployeeService service = new EmployeeService(repository);

    public static void main(String[] args) {

        while (true) {

            ConsolePrinter.printHeader("EMPLOYEE MANAGEMENT SYSTEM");

            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. View By Department");
            System.out.println("7. View By Status");
            System.out.println("8. Sort By Name");
            System.out.println("9. Sort By Salary");
            System.out.println("10. Highest Salary Employee");
            System.out.println("11. Lowest Salary Employee");
            System.out.println("12. Employee Count");
            System.out.println("13. Exit");

            int choice = InputUtil.readInt("\nEnter your choice : ");

            switch (choice) {

                case 1:
                    addEmployee();
                    break;

                case 2:
                    viewEmployees();
                    break;

                case 3:
                    searchEmployee();
                    break;

                case 4:
                    updateEmployee();
                    break;

                case 5:
                    deleteEmployee();
                    break;

                case 6:
                    viewByDepartment();
                    break;

                case 7:
                    viewByStatus();
                    break;

                case 8:
                    sortByName();
                    break;

                case 9:
                    sortBySalary();
                    break;

                case 10:
                    highestSalary();
                    break;

                case 11:
                    lowestSalary();
                    break;

                case 12:
                    employeeCount();
                    break;

                case 13:
                    System.out.println("Thank you...");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice");
            }

        }

    }
    private static void addEmployee() {

        ConsolePrinter.printHeader("ADD EMPLOYEE");

        int id = InputUtil.readInt("Employee ID : ");
        String firstName = InputUtil.readString("First Name : ");
        String lastName = InputUtil.readString("Last Name : ");
        int age = InputUtil.readInt("Age : ");
        String email = InputUtil.readString("Email : ");
        String phone = InputUtil.readString("Phone : ");

        System.out.println("\nDepartments");
        System.out.println("1. HR");
        System.out.println("2. IT");
        System.out.println("3. FINANCE");
        System.out.println("4. SALES");
        System.out.println("5. MARKETING");
        System.out.println("6. ADMIN");

        int deptChoice = InputUtil.readInt("Department : ");

        Department department;

        switch (deptChoice) {
            case 1:
                department = Department.HR;
                break;
            case 2:
                department = Department.IT;
                break;
            case 3:
                department = Department.FINANCE;
                break;
            case 4:
                department = Department.SALES;
                break;
            case 5:
                department = Department.MARKETING;
                break;
            case 6:
                department = Department.ADMIN;
                break;
            default:
                department = Department.IT;
        }

        double salary = InputUtil.readDouble("Salary : ");

        String street = InputUtil.readString("Street : ");
        String city = InputUtil.readString("City : ");
        String state = InputUtil.readString("State : ");
        String country = InputUtil.readString("Country : ");
        String zip = InputUtil.readString("Zip Code : ");

        Address address = new Address(
                street,
                city,
                state,
                country,
                zip
        );

        Employee employee = new Employee(
                id,
                firstName,
                lastName,
                age,
                email,
                phone,
                department,
                salary,
                EmployeeStatus.ACTIVE,
                address
        );

        if (service.addEmployee(employee)) {
            ConsolePrinter.success("Employee Added Successfully.");
        } else {
            ConsolePrinter.error("Failed to Add Employee.");
        }
    }

    private static void viewEmployees() {

        ConsolePrinter.printHeader("EMPLOYEE LIST");

        List<Employee> employees = service.getAllEmployees();

        if (employees.isEmpty()) {
            ConsolePrinter.info("No Employees Found.");
            return;
        }

        for (Employee employee : employees) {
            System.out.println(employee);
            System.out.println("-------------------------------------");
        }
    }

    private static void searchEmployee() {

        ConsolePrinter.printHeader("SEARCH EMPLOYEE");

        int id = InputUtil.readInt("Enter Employee ID : ");

        Employee employee = service.getEmployee(id);

        if (employee == null) {
            ConsolePrinter.error("Employee Not Found.");
        } else {
            System.out.println(employee);
        }
    }

    private static void updateEmployee() {

        ConsolePrinter.printHeader("UPDATE EMPLOYEE");

        int id = InputUtil.readInt("Employee ID : ");

        Employee existing = service.getEmployee(id);

        if (existing == null) {
            ConsolePrinter.error("Employee Not Found.");
            return;
        }

        String firstName = InputUtil.readString("First Name : ");
        String lastName = InputUtil.readString("Last Name : ");
        int age = InputUtil.readInt("Age : ");
        String email = InputUtil.readString("Email : ");
        String phone = InputUtil.readString("Phone : ");

        System.out.println("\nDepartments");
        System.out.println("1.HR");
        System.out.println("2.IT");
        System.out.println("3.FINANCE");
        System.out.println("4.SALES");
        System.out.println("5.MARKETING");
        System.out.println("6.ADMIN");

        int deptChoice = InputUtil.readInt("Department : ");

        Department department;

        switch (deptChoice) {
            case 1:
                department = Department.HR;
                break;
            case 2:
                department = Department.IT;
                break;
            case 3:
                department = Department.FINANCE;
                break;
            case 4:
                department = Department.SALES;
                break;
            case 5:
                department = Department.MARKETING;
                break;
            case 6:
                department = Department.ADMIN;
                break;
            default:
                department = Department.IT;
        }

        double salary = InputUtil.readDouble("Salary : ");

        String street = InputUtil.readString("Street : ");
        String city = InputUtil.readString("City : ");
        String state = InputUtil.readString("State : ");
        String country = InputUtil.readString("Country : ");
        String zip = InputUtil.readString("Zip Code : ");

        Address address = new Address(
                street,
                city,
                state,
                country,
                zip
        );

        Employee employee = new Employee(
                id,
                firstName,
                lastName,
                age,
                email,
                phone,
                department,
                salary,
                existing.getStatus(),
                address
        );

        if (service.updateEmployee(employee)) {
            ConsolePrinter.success("Employee Updated Successfully.");
        } else {
            ConsolePrinter.error("Employee Update Failed.");
        }
    }

    private static void deleteEmployee() {

        ConsolePrinter.printHeader("DELETE EMPLOYEE");

        int id = InputUtil.readInt("Employee ID : ");

        if (service.deleteEmployee(id)) {
            ConsolePrinter.success("Employee Deleted Successfully.");
        } else {
            ConsolePrinter.error("Employee Not Found.");
        }
    }
      private static void viewByDepartment() {

        ConsolePrinter.printHeader("EMPLOYEES BY DEPARTMENT");

        System.out.println("1. HR");
        System.out.println("2. IT");
        System.out.println("3. FINANCE");
        System.out.println("4. SALES");
        System.out.println("5. MARKETING");
        System.out.println("6. ADMIN");

        int choice = InputUtil.readInt("Choose Department : ");

        Department department;

        switch (choice) {
            case 1:
                department = Department.HR;
                break;
            case 2:
                department = Department.IT;
                break;
            case 3:
                department = Department.FINANCE;
                break;
            case 4:
                department = Department.SALES;
                break;
            case 5:
                department = Department.MARKETING;
                break;
            case 6:
                department = Department.ADMIN;
                break;
            default:
                ConsolePrinter.error("Invalid Department");
                return;
        }

        List<Employee> employees = service.getEmployeesByDepartment(department);

        if (employees.isEmpty()) {
            ConsolePrinter.info("No Employees Found");
            return;
        }

        employees.forEach(System.out::println);
    }

    private static void viewByStatus() {

        ConsolePrinter.printHeader("EMPLOYEES BY STATUS");

        System.out.println("1. ACTIVE");
        System.out.println("2. INACTIVE");

        int choice = InputUtil.readInt("Choose Status : ");

        EmployeeStatus status;

        switch (choice) {
            case 1:
                status = EmployeeStatus.ACTIVE;
                break;
            case 2:
                status = EmployeeStatus.INACTIVE;
                break;
            default:
                ConsolePrinter.error("Invalid Status");
                return;
        }

        List<Employee> employees = service.getEmployeesByStatus(status);

        if (employees.isEmpty()) {
            ConsolePrinter.info("No Employees Found");
            return;
        }

        employees.forEach(System.out::println);
    }

    private static void sortByName() {

        ConsolePrinter.printHeader("EMPLOYEES SORTED BY NAME");

        List<Employee> employees = service.sortByName();

        if (employees.isEmpty()) {
            ConsolePrinter.info("No Employees Found");
            return;
        }

        employees.forEach(System.out::println);
    }

    private static void sortBySalary() {

        ConsolePrinter.printHeader("EMPLOYEES SORTED BY SALARY");

        List<Employee> employees = service.sortBySalary();

        if (employees.isEmpty()) {
            ConsolePrinter.info("No Employees Found");
            return;
        }

        employees.forEach(System.out::println);
    }

    private static void highestSalary() {

        ConsolePrinter.printHeader("HIGHEST SALARY EMPLOYEE");

        Employee employee = service.getHighestSalaryEmployee();

        if (employee == null) {
            ConsolePrinter.info("No Employees Found");
            return;
        }

        System.out.println(employee);
    }

    private static void lowestSalary() {

        ConsolePrinter.printHeader("LOWEST SALARY EMPLOYEE");

        Employee employee = service.getLowestSalaryEmployee();

        if (employee == null) {
            ConsolePrinter.info("No Employees Found");
            return;
        }

        System.out.println(employee);
    }

    private static void employeeCount() {

        ConsolePrinter.printHeader("EMPLOYEE COUNT");

        System.out.println("Total Employees : " + service.getEmployeeCount());
    }

}
    // ==========================================================
    // CRUD METHODS
    // ==========================================================
