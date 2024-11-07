package com.lopinivan.spring.mvc_hibernate_aop.service;

import com.lopinivan.spring.mvc_hibernate_aop.dao.EmpDetailsDAO;
import com.lopinivan.spring.mvc_hibernate_aop.entity.EmpDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmpDetailsServiceImpl implements EmpDetailsService {

    private final EmpDetailsDAO empDetailsDAO;

    @Autowired
    public EmpDetailsServiceImpl(EmpDetailsDAO empDetailsDAO) {
        this.empDetailsDAO = empDetailsDAO;
    }

    @Override
    @Transactional
    public EmpDetails getEmpDetails(int id) {
        return empDetailsDAO.getEmpDetails(id);
    }
}
