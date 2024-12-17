package com.lopinivan.spring.mvc_hibernate_aop.test;

import com.lopinivan.spring.mvc_hibernate_aop.entity.Employee;
import com.lopinivan.spring.mvc_hibernate_aop.service.EmployeeService;
import jakarta.persistence.LockModeType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Transactional
public class testOptimisticAndPessimisticBlocking {

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context = new ClassPathXmlApplicationContext("WEB-INF/applicationContext.xml");
        EmployeeService employeeService = context.getBean(EmployeeService.class);

        try (SessionFactory sessionFactory = context.getBean(SessionFactory.class);
             Session session1 = sessionFactory.openSession();
             Session session2 = sessionFactory.openSession();) {

            session1.beginTransaction();
            session2.beginTransaction();

            Map<String, Object> timeOut = Map.of("jakarta.persistence.lock.timeout", 5000);

            System.out.println("Установка таймаут для сессии 1");
            session1.createNativeQuery("SET lock_timeout = '5s';").executeUpdate();
            System.out.println("Установка таймаут для сессии 2");
            session2.createNativeQuery("SET lock_timeout = '5s';").executeUpdate();

            System.out.println("Сессия 1 делает запрос");
            Employee employee = session1.find(Employee.class, 1, LockModeType.PESSIMISTIC_WRITE, timeOut);
//            Employee employee = session1
//                    .createQuery("from Employee e where e.id = :id", Employee.class)
//                    .setParameter("id", 1)
//                    .setLockMode(LockModeType.PESSIMISTIC_WRITE)
//                    .setHint("jakarta.persistence.lock.timeout", 5000)
//                    .getSingleResult();

            System.out.println("Сессия 1 вносит изменения");
            employee.setSalary(employee.getSalary() + 500);


            System.out.println("Сессия 2 делает запрос");
            Employee employee1 = session2.find(Employee.class, 1);

            System.out.println("Сессия 2 вносит изменения");
            employee1.setSalary(employee1.getSalary() + 1000);

            session2.getTransaction().commit();
            System.out.println("Сессия 2 закрыта");
            session1.getTransaction().commit();
            System.out.println("Сессия 1 закрыта");

        }
    }
}
