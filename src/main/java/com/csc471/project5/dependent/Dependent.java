package com.csc471.project5.dependent;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "dependent")
@NoArgsConstructor
//@AllArgsConstructor
@Getter
@Setter
public class Dependent{

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ssn;
    private String name;
    private String relation;

    public Dependent(long ssn, String name, String relation) {
        this.ssn =ssn;
        this.name = name;
        this.relation = relation;
    }


}
