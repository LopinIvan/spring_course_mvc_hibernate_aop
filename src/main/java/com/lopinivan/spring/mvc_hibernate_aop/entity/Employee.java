package com.lopinivan.spring.mvc_hibernate_aop.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.OptimisticLocking;

//123
//employees clas
//employees
@Entity
//@OptimisticLocking(type = OptimisticLockType.ALL)
//@DynamicUpdate
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private int id;

    @Column(name = "emp_name")
    private String firstName;

    @Column(name = "emp_surname")
    private String lastName;

    @Column(name = "emp_department")
    private String department;

    @Column(name = "emp_salary")
    private int salary;

//    Оптимистическая блокировка @OptimisticLocking(type = OptimisticLockType.VERSION)
//    @Version
//    @Column(name = "emp_version")
//    private int emp_version;

    // Связь один-к-одному с EmpDetails
    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    private EmpDetails empDetails;

    public Employee() {
    }

    public Employee(String firstName, int salary, String department, String lastName) {
        this.firstName = firstName;
        this.salary = salary;
        this.department = department;
        this.lastName = lastName;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public EmpDetails getEmpDetails() {
        return empDetails;
    }

//    public int getEmp_version() {
//        return emp_version;
//    }
//
//    public void setEmp_version(int emp_version) {
//        this.emp_version = emp_version;
//    }

    public void setEmpDetails(EmpDetails empDetails) {
        this.empDetails = empDetails;
        if (empDetails != null) {
            empDetails.setEmployee(this);
        }
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}
