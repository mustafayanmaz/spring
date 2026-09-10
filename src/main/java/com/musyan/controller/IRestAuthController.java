package com.musyan.controller;

import com.musyan.dto.DtoUser;
import com.musyan.jwt.AuthRequest;

public interface IRestAuthController {

    public DtoUser register(AuthRequest request);

}
