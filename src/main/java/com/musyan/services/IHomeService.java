package com.musyan.services;

import com.musyan.dto.DtoHome;

public interface IHomeService {

    public DtoHome findHomeById(Long id);
}
