package kz.summer.intership.controller;


import kz.summer.intership.model.EmployeeModelRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @GetMapping("/healthcheck")
    public String healthCheck() {
        return "It's  Work";
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


}
