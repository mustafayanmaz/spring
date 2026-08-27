package com.musyan.service;

import com.musyan.dto.DtoDepartment;
import com.musyan.dto.DtoEmployee;
import com.musyan.model.Employee;
import org.springframework.stereotype.Service;


public interface IEmployeeService {

    public DtoEmployee findEmployeeById(Long id);
}
