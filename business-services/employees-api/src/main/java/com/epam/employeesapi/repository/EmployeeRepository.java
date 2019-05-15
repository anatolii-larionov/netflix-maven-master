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
    @Query(value = "UPDATE Employee e SET e.workspaceId = ?2 WHERE e.id = ?1")
    void update(String id, String workspaceId);
}
