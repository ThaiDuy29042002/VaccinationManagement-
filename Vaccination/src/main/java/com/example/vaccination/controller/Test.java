package com.example.vaccination.controller;

import com.example.vaccination.model.entity.Employee;
import com.example.vaccination.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class Test {
    @Autowired
    EmployeeService employeeService;

    @GetMapping(value = "/hi")
    public String home(Model model) throws ParseException {
        List<Employee> employees = employeeService.findAll();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = formatter.parse("2002-04-07");
        //employeeService.save(new Employee("EM001","here",date,"cuong@gmail.com","Cuong",true,"avatar.png","12345","0352312321","admin","admin","tp1"));
        employeeService.save(new Employee("EM002","here",date,"cuongne@gmail.com","Kuong",true,"avatar.png","12345","0352312321","admin","admin1","tp1"));
        Employee emp = employeeService.findByEmployeeID("EM002");

        model.addAttribute("empList", employees);
        return "testUI";
    }
}
