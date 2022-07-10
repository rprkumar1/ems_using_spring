package com.mycompany.ems.controller;


import com.mycompany.ems.FieldErrorMessage;
import com.mycompany.ems.model.Employee;
import com.mycompany.ems.service.EmployeeService;
import com.mycompany.ems.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.ValidationException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;
    LoginService loginService;


    @GetMapping("/ems")
    Iterable<Employee> getAllEmployee(){
        return employeeService.findAll();
    }

    @GetMapping("/ems/emp/{id}")
    Optional<Employee> getEmployeeById(@PathVariable Integer id){
        return employeeService.findById(id);
    }

    @GetMapping("/wrong")
    Employee somethingIsWrong() {
        throw new ValidationException("The URL doesn't Exist");
    }

    @PostMapping("/ems")
    Employee addEmployee(@Valid @RequestBody Employee emp){

//
        employeeService.save(emp);
//        Login login = new Login(emp.getEmpName().toLowerCase(),"pass","employee");
//        login.setEmployee(emp);
//        System.out.println(login.getUsername()+login.getPassword()+login.getRole());
//        loginService.save(login);
//        System.out.println(emp.getEmpID());
        return emp;
    }

    @PutMapping("/ems")
    ResponseEntity<Employee> update(@RequestBody Employee emp) {
        if(employeeService.findById(emp.getEmpID()).isPresent())
            return new ResponseEntity(employeeService.save(emp), HttpStatus.OK);
        else
            return new ResponseEntity(emp, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/ems/emp/{id}")
    Integer deleteEmployee(@PathVariable Integer id){
        employeeService.deleteById(id);
        return id;
    }



    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class )
    List<FieldErrorMessage> exceptionHandler(MethodArgumentNotValidException e ) {
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        List<FieldErrorMessage> fieldErrorMessages =fieldErrors.stream().map(fieldError ->
                        new FieldErrorMessage(fieldError.getField(), fieldError.getDefaultMessage()))
                .collect(Collectors.toList());
        return fieldErrorMessages;
    }


}
