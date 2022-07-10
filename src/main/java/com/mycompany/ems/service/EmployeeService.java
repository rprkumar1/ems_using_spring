package com.mycompany.ems.service;

import com.mycompany.ems.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeService extends CrudRepository<Employee,Integer> {

}
