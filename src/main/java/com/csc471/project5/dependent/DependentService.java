package com.csc471.project5.dependent;

import com.csc471.project5.employee.Employee;
import com.csc471.project5.employee.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DependentService {
    @Autowired
    DependentRepository repo;
    List<Dependent> getAllDependents() {
        return repo.findAll();
    }

}