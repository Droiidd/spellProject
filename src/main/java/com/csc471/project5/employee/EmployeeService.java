package com.csc471.project5.employee;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository repo;
    List<Employee> getAllEmployees() {
        return repo.findAll();
    }

    Object getEmployee(long id) {
        return repo.getEmployeeById(id);
    }

    void deleteEmployee(long id) {
        repo.deleteEmployeeById(id);
    }

    void saveEmployee(Employee employee) {
        repo.saveEmployee(employee);
    }

    void updateEmployee(Employee employee) {
        repo.updateEmployee(employee);
    }

}
