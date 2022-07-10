package com.mycompany.ems;

import com.mycompany.ems.model.Employee;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

public class SystemTest {

    @Test
    public void testCreateReadDelete() {

//        RestTemplate restTemplate = new RestTemplate();
//
//        String url = "http://localhost:8080/ems";
//
//        Employee emp = new Employee("Austin",9876543,"HR","john@g.com","Texas");
//        ResponseEntity<Employee> entity
//                = restTemplate.postForEntity(url, emp, Employee.class);
//
//        Employee[] employees = restTemplate.getForObject(url, Employee[].class);
//        Assertions.assertThat(employees).extracting(Employee::getEmpName).containsOnly(
//                "Austin");
//
//        restTemplate.delete(url + "/emp/" + entity.getBody().getEmpID());
//        Assertions.assertThat(restTemplate.getForObject(url,
//                Employee[].class)).isEmpty();
    }

    @org.junit.Test
    public void testErrorHandlingReturnsBadRequest() {

//        RestTemplate restTemplate = new RestTemplate();
//
//        String url = "http://localhost:8080/wrong";
//
//        try {
//            restTemplate.getForEntity(url, String.class);
//        } catch (HttpClientErrorException e) {
//            Assert.assertEquals(HttpStatus.BAD_REQUEST, e.getStatusCode());
//        }
    }
}
