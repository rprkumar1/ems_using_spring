package com.mycompany.ems.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empID;

    @NotBlank
    private String empName;

    private long empContact;

    @NotBlank
    String empDepartment;
    @NotBlank
    String empEmail;
    @NotBlank
    String empAddress;

    @OneToOne(orphanRemoval = true)
    private Login login;

    @OneToMany(mappedBy = "employee", orphanRemoval = true)
    private List<Timesheet> timesheets = new ArrayList<>();

    public Employee(String empName, long empContact, String empDepartment, String empEmail, String empAddress) {
        this.empName = empName;
        this.empContact = empContact;
        this.empDepartment = empDepartment;
        this.empEmail = empEmail;
        this.empAddress = empAddress;
    }

}
