package kz.summer.intership.service;

import kz.summer.intership.model.EmployeeDTO;
import kz.summer.intership.model.EmployeeResponse;

import java.util.List;

public interface EmployeeService {

    public EmployeeResponse createAndUpdateEmployee(EmployeeDTO employeeDTO);

    public List<EmployeeResponse> getEmployeeListByCompanyId(String companyId);
}
