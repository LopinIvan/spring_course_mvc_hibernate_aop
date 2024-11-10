package com.lopinivan.spring.mvc_hibernate_aop.entity;

import jakarta.persistence.*;

//123
//emp_details
@Entity
@Table(name = "emp_details")
public class EmpDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_details_id")
    private int id;

    @Column(name = "emp_details_email")
    private String email;

    @Column(name = "emp_details_phone_number")
    private String phoneNumber;

    @Column(name = "emp_details_password")
    private String password;

    @Column(name = "emp_details_rating")
    private int rating;

    // Связь один-к-одному с Employee (внешний ключ emp_id в таблице employee)
    @OneToOne
    @JoinColumn(name = "emp_id")
    private Employee employee;

    public EmpDetails() {
    }

    public EmpDetails(String email, String phoneNumber, String password, int rating) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "EmpDetails{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                ", rating=" + rating +
                '}';
    }
}
