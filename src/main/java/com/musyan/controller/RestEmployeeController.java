package com.musyan.controller;

import com.musyan.dto.DtoEmployee;
import com.musyan.model.RootEntity;

public interface RestEmployeeController {

    public RootEntity<DtoEmployee> findEmployeeById(Long id);
}
