package kz.summer.intership.repository;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Long> {


    List<EmployeeEntity> findByCompanyId(String companyId);


}
