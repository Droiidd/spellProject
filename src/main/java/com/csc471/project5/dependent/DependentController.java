package com.csc471.project5.dependent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dependents")
public class DependentController {

    @Autowired
    private DependentService service;

    @GetMapping("/all")
    public String getAllDependents(Model model) {
        model.addAttribute("dependentList", service.getAllDependents());
        return "dependents/list-dependents";
    }
}
