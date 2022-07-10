package com.mycompany.ems;

import com.mycompany.ems.controller.EmployeeController;
import com.mycompany.ems.controller.LoginController;
import com.mycompany.ems.controller.TimesheetController;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class EmsApplicationTests {

	@Autowired
	EmployeeController employeeController;

	@Test
	void contextLoadsEmployee() {
		Assert.assertNotNull(employeeController);
	}

	@Autowired
	TimesheetController timesheetController;

	@Test
	void contextLoadsTimesheet() {
		Assert.assertNotNull(timesheetController);
	}

	@Autowired
	LoginController loginController;

	@Test
	void contextLoadsLogin() {
		Assert.assertNotNull(loginController);
	}

}
