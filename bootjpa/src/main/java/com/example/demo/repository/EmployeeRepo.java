package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Employee;
import javax.transaction.Transactional;

public interface EmployeeRepo extends CrudRepository<Employee,Integer>
{
    @Transactional
    public void deleteById(int eid);
}
