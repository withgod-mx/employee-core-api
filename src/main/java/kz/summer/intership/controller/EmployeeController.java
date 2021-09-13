package kz.summer.intership.controller;


import kz.summer.intership.model.EmployeeDTO;
import kz.summer.intership.model.EmployeeModelRequest;
import kz.summer.intership.model.EmployeeResponse;
import kz.summer.intership.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    Environment env;

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/healthcheck")
    public String healthCheck() {

        return "It's  Working port: " + env.getProperty("local.server.port");
    }

    @PostMapping
    public ResponseEntity<EmployeeResponse> createEmployee(@Valid @RequestBody EmployeeModelRequest employeeDetail) {

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        EmployeeDTO employeeDTO = modelMapper.map(employeeDetail, EmployeeDTO.class);
        employeeDTO.setEmployeeId(UUID.randomUUID().toString());

        EmployeeResponse employeeResponse = employeeService.createAndUpdateEmployee(employeeDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(employeeResponse);
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<EmployeeResponse> updateEmployee(@Valid @RequestBody EmployeeModelRequest employeeDetail,
                                                           @PathVariable String employeeId) {

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        EmployeeDTO employeeDTO = modelMapper.map(employeeDetail, EmployeeDTO.class);
        employeeDTO.setEmployeeId(employeeId);

        EmployeeResponse employeeResponse = employeeService.createAndUpdateEmployee(employeeDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(employeeResponse);

    }

    @GetMapping("/company/{companyId}")
    public List<EmployeeResponse> getEmployeeListByCompanyId(@PathVariable String companyId) {
        List<EmployeeResponse> employeeResponseList = employeeService.getEmployeeListByCompanyId(companyId);

        return employeeResponseList;

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


/**
 * RequestModel
 * DTO
 * Entity
 * Response
 */
 