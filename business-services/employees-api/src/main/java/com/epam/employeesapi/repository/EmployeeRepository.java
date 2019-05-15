package com.epam.employeesapi.repository;

import com.epam.commons.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE Employee e SET e.workspaceId = :workspaceId WHERE e.id = :id")
    void update(String id, String workspaceId);
}
