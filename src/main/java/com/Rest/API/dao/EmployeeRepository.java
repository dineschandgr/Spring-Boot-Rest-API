package com.Rest.API.dao;

import com.Rest.API.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(
            value =
                    "select e.* "
                            + "from employee e inner join address a "
                            + "on e.id = a.employee_id "
                            + "where e.age > :age",
            nativeQuery = true)
    List<Employee> findEmployeeWithAddress(@Param("age") int age);
}
