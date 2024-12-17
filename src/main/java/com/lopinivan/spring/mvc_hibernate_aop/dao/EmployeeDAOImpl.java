package com.lopinivan.spring.mvc_hibernate_aop.dao;

import com.lopinivan.spring.mvc_hibernate_aop.entity.Employee;
import jakarta.persistence.LockModeType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

//repository
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

        session.doWork(connection -> System.out.println(connection.getTransactionIsolation()));

        List<Employee> resultList = session.createQuery("SELECT e FROM Employee " +
                        "e JOIN FETCH e.empDetails ORDER BY e.id"
                , Employee.class).getResultList();

        return resultList;
    }

    @Override
    public void saveEmployee(Employee employee) {

        Session session = sessionFactory.getCurrentSession();

        session.merge(employee);

    }

    @Override
    public Employee getEmployeeById(int id) {

        Session session = sessionFactory.getCurrentSession();

//        Оптимистическая блокировка @OptimisticLocking(type = OptimisticLockType.VERSION)
//        return session.find(Employee.class, id, LockModeType.OPTIMISTIC);

        return session.find(Employee.class, id);
    }

    @Override
    public void deleteEmployee(int id) {

        Session session = sessionFactory.getCurrentSession();

        Employee employee = session.get(Employee.class, id);

        session.remove(employee);

    }
}
