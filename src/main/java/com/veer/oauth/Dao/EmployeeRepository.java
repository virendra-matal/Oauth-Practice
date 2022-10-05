package com.veer.oauth.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.veer.oauth.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	Employee findByUsername(String username);
}
