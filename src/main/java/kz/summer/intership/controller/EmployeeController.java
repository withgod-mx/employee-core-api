package kz.summer.intership.controller;


import kz.summer.intership.model.EmployeeModelRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    Environment env;

    @GetMapping("/healthcheck")
    public String healthCheck() {



        return "It's  Working port: " + env.getProperty("local.server.port");
    }

    @PostMapping
    public ResponseEntity<EmployeeModelRequest> createEmployee(@Valid @RequestBody EmployeeModelRequest employeeDetail) {

        return new ResponseEntity<EmployeeModelRequest>(employeeDetail, HttpStatus.OK);
    }

    @PutMapping
    public String updateEmployee(@Valid @RequestBody EmployeeModelRequest employeeDetail) {
        return  null;
    }

    @GetMapping("/all")
    public String getEmployeeList() {
        return "";
    }

    @GetMapping("/{employeeId}")
    public String getEmployeeById(@PathVariable String employeeId) {
        return employeeId;
    }

}
 