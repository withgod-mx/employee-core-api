package kz.summer.intership.service;

import kz.summer.intership.model.EmployeeDTO;
import kz.summer.intership.model.EmployeeResponse;
import kz.summer.intership.repository.EmployeeEntity;
import kz.summer.intership.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;


    @Override
    public EmployeeResponse createAndUpdateEmployee(EmployeeDTO employeeDTO) {

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        EmployeeEntity employeeEntity = modelMapper.map(employeeDTO, EmployeeEntity.class);

        employeeEntity = employeeRepository.save(employeeEntity);

        //EmployeeEntity employeeEntity = modelMapper.map(employeeDTO, EmployeeEntity.class);


        EmployeeResponse employeeResponse = modelMapper.map(employeeEntity, EmployeeResponse.class);


        return employeeResponse;
    }

    @Override
    public List<EmployeeResponse> getEmployeeListByCompanyId(String companyId) {

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        List<EmployeeResponse> employeeResponse = employeeRepository.findByCompanyId(companyId).stream()
                .map(employee -> modelMapper.map(employee, EmployeeResponse.class)).collect(Collectors.toList());

        return employeeResponse;
    }
}
