package kz.summer.intership.service;

import kz.summer.intership.model.EmployeeDTO;
import kz.summer.intership.model.EmployeeResponse;

public interface EmployeeService {

    public EmployeeResponse createAndUpdateEmployee(EmployeeDTO employeeDTO);
}
