package com.zaurtregulov.spring.mvc_hibernate_aop.controller;

import com.zaurtregulov.spring.mvc_hibernate_aop.entity.EmpDetails;
import com.zaurtregulov.spring.mvc_hibernate_aop.service.EmpDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmpDetailsController {

    private final EmpDetailsService empDetailsService;

    @Autowired
    public EmpDetailsController(EmpDetailsService empDetailsService) {
        this.empDetailsService = empDetailsService;
    }

    @RequestMapping("/details")
    public String showEmpDetails(@RequestParam("empId") int id, Model model) {

        EmpDetails empDetails = empDetailsService.getEmpDetails(id);
        model.addAttribute("empDetails", empDetails);

        return "details-employee-view";
    }

}
