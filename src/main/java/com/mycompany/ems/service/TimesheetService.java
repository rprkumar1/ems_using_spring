package com.mycompany.ems.service;

import com.mycompany.ems.model.Timesheet;
import org.springframework.data.repository.CrudRepository;


public interface TimesheetService extends CrudRepository<Timesheet,Integer> {
}
