package com.zaurtregulov.spring.mvc_hibernate_aop.dao;

import com.zaurtregulov.spring.mvc_hibernate_aop.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public EmployeeDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Employee> getAllEmployees() {

        Session session = sessionFactory.getCurrentSession();
        List<Employee> allEmployees = session.createQuery("from Employee order by id"
                , Employee.class).getResultList();

        return allEmployees;
    }

    @Override
    public void saveNewEmployee(Employee employee) {

        Session session = sessionFactory.getCurrentSession();

        session.merge(employee);

    }

    @Override
    public Employee getEmployeeById(int id) {

        Session session = sessionFactory.getCurrentSession();
        Employee employee = session.get(Employee.class, id);

        return employee;
    }
}
