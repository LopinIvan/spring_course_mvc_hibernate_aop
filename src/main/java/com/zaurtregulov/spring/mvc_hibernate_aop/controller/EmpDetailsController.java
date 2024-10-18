package com.zaurtregulov.spring.mvc_hibernate_aop.controller;

import com.zaurtregulov.spring.mvc_hibernate_aop.entity.EmpDetails;
import com.zaurtregulov.spring.mvc_hibernate_aop.service.EmpDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmpDetailsController {

    private final EmpDetailsService empDetailsService;

    @Autowired
    public EmpDetailsController(EmpDetailsService empDetailsService) {
        this.empDetailsService = empDetailsService;
    }

    @RequestMapping("/details")
    public String showEmpDetails(Model model) {

        EmpDetails empDetails = empDetailsService.getEmpDetails(1);
        model.addAttribute("empDetails", empDetails);

        return "emp-details-view";
    }
}
