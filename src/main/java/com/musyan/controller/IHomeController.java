package com.musyan.controller;

import com.musyan.dto.DtoHome;

public interface IHomeController {

    public DtoHome findHomeById(Long id);
}
