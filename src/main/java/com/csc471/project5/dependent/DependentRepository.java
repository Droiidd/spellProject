package com.csc471.project5.dependent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DependentRepository {
    @Autowired
    NamedParameterJdbcTemplate template;

    List<Dependent> findAll() {
        String query = "select ssn,name,relation from dependent";
        return template.query(query,
                (result, rowNum)
                        -> new Dependent(result.getLong("ssn"),
                        result.getString("name"), result.getString(
                        "relation")));
    }

//    public Employee getEmployeeById(long ssn) {
//        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue(
//                "ssn", ssn);
//        String query = "select * from employee where ssn=:ssn ";
//        return template.queryForObject(query, namedParameters,
//                BeanPropertyRowMapper.newInstance(Employee.class));
//    }

//    public int saveEmployee(Employee employee) {
//        Map<String, Object> paramMap = new HashMap<>();
//        paramMap.put("ssn", employee.getSsn());
//        paramMap.put("f_name", employee.getF_name());
//        paramMap.put("m_init", employee.getM_init());
//        paramMap.put("l_name", employee.getL_name());
//        paramMap.put("address", employee.getAddress());
//        String query = "INSERT INTO employee(ssn, f_name,m_init,l_name,address) VALUES(:ssn, :f_name, :m_init,:l_name,:address)";
//        return template.update(query, paramMap);
//    }
//
//    void deleteEmployeeById(long ssn) {
//
//        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue(
//                "ssn", ssn);
//        String query = "delete from employee where ssn=:ssn";
//        template.update(query, namedParameters);
//    }
//
//    void updateEmployee(Employee employee) {
//        Map<String, Object> paramMap = new HashMap<>();
//        paramMap.put("ssn", employee.getSsn());
//        paramMap.put("f_name", employee.getF_name());
//        paramMap.put("m_init", employee.getM_init());
//        paramMap.put("l_name", employee.getL_name());
//        paramMap.put("address", employee.getAddress());
//
//        String query = "update employee set f_name=:f_name, m_init=:m_init,l_name=:l_name, address=:address where ssn=:ssn ";
//        template.update(query, paramMap);
//    }
}
