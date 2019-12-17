package com.example.demo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, String>, EmployeeRepositoryCustom {
    // magic
    Employee findByFirstName(String firstName);
    List<Employee> findByLastName(String lastName);

    // native JSON query string
    @Query("select e from Employee e where e.firstName=:firstName")
    Employee findByFirstNameNative(@Param("firstName") String firstName);
}
