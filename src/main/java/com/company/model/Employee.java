package com.company.model;

public class Employee {

    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private String phone;
    private Department department;
    private double salary;
    private EmployeeStatus status;
    private Address address;

    public Employee() {
    }

    public Employee(int id,
                    String firstName,
                    String lastName,
                    int age,
                    String email,
                    String phone,
                    Department department,
                    double salary,
                    EmployeeStatus status,
                    Address address) {

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.department = department;
        this.salary = salary;
        this.status = status;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public EmployeeStatus getStatus() {
        return status;
    }

    public void setStatus(EmployeeStatus status) {
        this.status = status;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {

        return "Employee {" +
                "\n  ID = " + id +
                "\n  Name = " + firstName + " " + lastName +
                "\n  Age = " + age +
                "\n  Email = " + email +
                "\n  Phone = " + phone +
                "\n  Department = " + department +
                "\n  Salary = ₹" + salary +
                "\n  Status = " + status +
                "\n  Address = " + address +
                "\n}";
    }
}
