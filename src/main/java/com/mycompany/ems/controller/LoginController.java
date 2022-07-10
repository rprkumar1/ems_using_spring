package com.mycompany.ems.controller;

import com.mycompany.ems.model.Login;
import com.mycompany.ems.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class LoginController {

    @Autowired
    LoginService loginService;

    @GetMapping("/ems/login")
    Iterable<Login> getAllTimesheet(){
        return loginService.findAll();
    }


    @PostMapping("/ems/login")
    Login addTimesheet(@RequestBody Login login){
        return loginService.save(login);
    }

    @PutMapping("/ems/login")
    ResponseEntity<Login> updateTimesheet(@RequestBody Login login){
        if(loginService.findById(login.getLoginID()).isPresent())
            return new ResponseEntity(loginService.save(login), HttpStatus.OK);
        else
            return new ResponseEntity(login, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/ems/login/{id}")
    Integer deleteTimesheet(@PathVariable Integer id){
        loginService.deleteById(id);
        return id;
    }
}
