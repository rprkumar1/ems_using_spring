package com.mycompany.ems.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;


@Data
@NoArgsConstructor
@Entity
public class Timesheet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int timeID;
    private int empID;

    private String empName;
    private double timeTotalHours;
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date timeDate;
    private String timeTask;
    private String timeDescription;

    @ManyToOne
    @JoinColumn(name = "empID", insertable = false, updatable = false)
    private Employee employee;


    public Timesheet( int empID,String empName, double timeTotalHours, Date timeDate, String timeTask, String timeDescription) {
        this.empName = empName;
        this.timeTotalHours = timeTotalHours;
        this.timeDate = timeDate;
        this.timeTask = timeTask;
        this.timeDescription = timeDescription;
    }


}
