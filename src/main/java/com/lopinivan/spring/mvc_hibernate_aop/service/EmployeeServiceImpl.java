package com.lopinivan.spring.mvc_hibernate_aop.service;

import com.lopinivan.spring.mvc_hibernate_aop.dao.EmployeeDAO;
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
            existingEmployee.update(employee);
        } else {
            employeeDAO.saveEmployee(employee);
        }
    }

// В этом случае
// Объект employee не является управляемым (detached),
// если он был создан или обновлён за пределами текущей транзакции.
// Если объект имеет версию, но она устарела
// (например, с момента загрузки объекта в другом запросе он был обновлён в базе),
// то Hibernate обнаружит несоответствие версии и выбросит OptimisticLockException.

//    @Override
//    @Transactional
//    public void saveEmployee(Employee employee) {
//        employeeDAO.saveEmployee(employee);
//    }

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
