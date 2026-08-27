package com.musyan.controller;

import com.musyan.dto.DtoEmployee;

public interface RestEmployeeController {

    public DtoEmployee findEmployeeById(Long id);
}
