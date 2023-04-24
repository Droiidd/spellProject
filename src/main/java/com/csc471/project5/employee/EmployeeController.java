package com.csc471.project5.employee;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping("/all")
    public String getAllEmployees(Model model) {
        model.addAttribute("employeeList", service.getAllEmployees());
        return "employees/list-employees";
    }

    @GetMapping("/ssn={ssn}")
    public String getEmployee(@PathVariable long ssn, Model model) {
        model.addAttribute("employee", service.getEmployee(ssn));
        return "employees/employee-detail";
    }

    @GetMapping("/delete/ssn={ssn}")
    public String deleteEmployee(@PathVariable long ssn, Model model) {
        service.deleteEmployee(ssn);
        return "redirect:/employees/all";
    }

    @PostMapping("/create")
    public String createEmployee(Employee employee) {
        service.saveEmployee(employee);
        return "redirect:/employees/all";
    }

    @PostMapping("/update")
    public String updateEmployee(Employee employee) {
        service.updateEmployee(employee);
        return "redirect:/employees/all";
    }

    @GetMapping("/new-employee")
    public String newEmployeeForm(Model model) {
        return "employees/new-employee";
    }

    @GetMapping("/update/ssn={ssn}")
    public String updateEmployeeForm(@PathVariable long ssn, Model model) {
        model.addAttribute("employee", service.getEmployee(ssn));
        return "employees/update-employee";
    }
}
