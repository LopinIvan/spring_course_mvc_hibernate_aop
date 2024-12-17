package com.lopinivan.spring.mvc_hibernate_aop.service;

import com.lopinivan.spring.mvc_hibernate_aop.dao.EmployeeDAO;
import com.lopinivan.spring.mvc_hibernate_aop.entity.EmpDetails;
import com.lopinivan.spring.mvc_hibernate_aop.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @Override
    @Transactional
    public void saveEmployee(Employee employee) {
        if (employee.getId() != 0) {
            Employee existingEmployee = employeeDAO.getEmployeeById(employee.getId());

            existingEmployee.setFirstName(employee.getFirstName());
            existingEmployee.setLastName(employee.getLastName());
            existingEmployee.setDepartment(employee.getDepartment());
            existingEmployee.setSalary(employee.getSalary());

            EmpDetails existingDetails = existingEmployee.getEmpDetails();
            EmpDetails newDetails = employee.getEmpDetails();

            existingDetails.setEmail(newDetails.getEmail());
            existingDetails.setPhoneNumber(newDetails.getPhoneNumber());
            existingDetails.setPassword(newDetails.getPassword());
            existingDetails.setRating(newDetails.getRating());
        } else {
            employeeDAO.saveEmployee(employee);
        }
    }

    @Override
    @Transactional
    public Employee getEmployeeById(int id) {

        return employeeDAO.getEmployeeById(id);
    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {
        employeeDAO.deleteEmployee(id);
    }
}
