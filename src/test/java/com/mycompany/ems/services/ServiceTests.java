package com.mycompany.ems.services;


import com.mycompany.ems.model.Employee;
import com.mycompany.ems.service.EmployeeService;
import com.mycompany.ems.service.TimesheetService;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ServiceTests {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    TimesheetService timesheetService;

    @Test
    public void testCreateReadDeleteForEmployee() {

        Employee emp = new Employee("Austin", 9876543, "HR", "john@g.com", "Texas");
        employeeService.save(emp);

        Iterable<Employee> employees = employeeService.findAll();
        Assertions.assertThat(employees).extracting(Employee::getEmpName).containsOnly("Austin");

        employeeService.deleteAll();
        Assertions.assertThat(employeeService.findAll()).isEmpty();
    }

}