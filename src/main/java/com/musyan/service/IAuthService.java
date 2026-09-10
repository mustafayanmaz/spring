package com.musyan.service;

import com.musyan.dto.DtoUser;
import com.musyan.jwt.AuthRequest;

public interface IAuthService {
    public DtoUser register(AuthRequest request);
}
