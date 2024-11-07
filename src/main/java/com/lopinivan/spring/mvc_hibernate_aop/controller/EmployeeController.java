package com.lopinivan.spring.mvc_hibernate_aop.controller;

import com.lopinivan.spring.mvc_hibernate_aop.entity.EmpDetails;
import com.lopinivan.spring.mvc_hibernate_aop.entity.Employee;
import com.lopinivan.spring.mvc_hibernate_aop.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping("/")
    public String showAllEmployees(Model model) {

        List<Employee> allEmployees = employeeService.getAllEmployees();
        model.addAttribute("allEmps", allEmployees);

        return "all-employees-view";
    }

    @RequestMapping("/addEmployee")
    public String addEmployee(Model model) {

        Employee employee = new Employee();
        model.addAttribute("employee", employee);

        return "add-employee-view";
    }

    @RequestMapping("saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {

        EmpDetails empDetails = employee.getEmpDetails();
        if (empDetails != null) {
            empDetails.setEmployee(employee);   // Установим обратную связь с сотрудником
        }

        employeeService.saveEmployee(employee);

        return "redirect:/";
    }

    @RequestMapping("/updateEmployee")
    public String updateEmployee(@RequestParam("empId") int id, Model model) {

        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);

        return "add-employee-view";

    }

    @RequestMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("empId") int id) {

        employeeService.deleteEmployee(id);

        return "redirect:/";
    }
}

//    public void deleteEmployee(int id) {
//        // Получаем сотрудника по ID
//        Employee employee = employeeService.getEmployeeById(id);
//
//        if (employee != null) {
//            // Получаем детали сотрудника
//            EmpDetails empDetails = employee.getEmpDetails();
//
//            // Очищаем обратную связь, если детали существуют
//            if (empDetails != null) {
//                empDetails.setEmployee(null); // Удаляем обратную связь
//            }
//
//            // Удаляем сотрудника
//            employeeService.deleteEmployee(employee); // Удаление приводит к каскадному удалению деталей
//        }
