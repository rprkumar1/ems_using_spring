package com.mycompany.ems.controller;

import com.mycompany.ems.model.Employee;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ValidationException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IntegrationTest {
    @Autowired
    EmployeeController employeeController;




    @Test
    public void testCreateReadDelete() {
        Employee emp = new Employee("Austin",9876543,"HR","john@g.com","Texas");

        Employee empResult = employeeController.addEmployee(emp);

        Iterable<Employee> employees = employeeController.getAllEmployee();
        Assertions.assertThat(employees).first().hasFieldOrPropertyWithValue("empName", "Austin");

        employeeController.deleteEmployee(empResult.getEmpID());
        Assertions.assertThat(employeeController.getAllEmployee()).isEmpty();

    }

    @Test(expected = ValidationException.class)
    public void errorHandlingValidationExceptionThrown() {
        employeeController.somethingIsWrong();

    }

}
