package com.csc471.project5.employee;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employee")
@NoArgsConstructor
//@AllArgsConstructor
@Getter
@Setter
public class Employee {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ssn;
    private String f_name;
    private String m_init;
    private String l_name;
    private String address;
    public Employee(long ssn, String f_name, String m_init, String l_name, String address) {
        this.ssn =ssn;
        this.f_name = f_name;
        this.m_init = m_init;
        this.l_name = l_name;
        this.address = address;
    }
    
    
}
