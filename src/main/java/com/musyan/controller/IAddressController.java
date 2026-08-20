package com.musyan.controller;

import com.musyan.dto.DtoAddress;

public interface IAddressController {
    public DtoAddress findAddressById(Long id);
}
