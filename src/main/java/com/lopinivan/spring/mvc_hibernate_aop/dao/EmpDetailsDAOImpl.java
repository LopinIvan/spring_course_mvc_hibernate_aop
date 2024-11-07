package com.lopinivan.spring.mvc_hibernate_aop.dao;

import com.lopinivan.spring.mvc_hibernate_aop.entity.EmpDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmpDetailsDAOImpl implements EmpDetailsDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public EmpDetailsDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public EmpDetails getEmpDetails(int id) {

        Session session = sessionFactory.getCurrentSession();
        EmpDetails empDetails = session.get(EmpDetails.class, id);

        return empDetails;
    }
}
