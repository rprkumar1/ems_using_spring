package com.mycompany.ems.controller;

import com.mycompany.ems.model.Timesheet;
import com.mycompany.ems.service.TimesheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class TimesheetController {

    @Autowired
    TimesheetService timesheetService;

    @GetMapping("/ems/timesheet")
    Iterable<Timesheet> getAllTimesheet(){
        return timesheetService.findAll();
    }

    @GetMapping("/ems/timesheet/{id}")
    Optional<Timesheet> getTimesheetById(@PathVariable Integer id){
        return timesheetService.findById(id);
    }

    @PostMapping("/ems/timesheet")
    Timesheet addTimesheet(@RequestBody Timesheet timesheet){
        return timesheetService.save(timesheet);
    }

    @PutMapping("/ems/timesheet")
    ResponseEntity<Timesheet> updateTimesheet(@RequestBody Timesheet timesheet){
        if(timesheetService.findById(timesheet.getTimeID()).isPresent())
            return new ResponseEntity(timesheetService.save(timesheet), HttpStatus.OK);
        else
            return new ResponseEntity(timesheet, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/ems/timesheet/{id}")
    Integer deleteTimesheet(@PathVariable Integer id){
        timesheetService.deleteById(id);
        return id;
    }
}