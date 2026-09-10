package com.musyan.controller.impl;

import com.musyan.controller.IRestAuthController;
import com.musyan.dto.DtoUser;
import com.musyan.jwt.AuthRequest;
import com.musyan.service.IAuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestAuthControllerImpl implements IRestAuthController {

    @Autowired
    private IAuthService authService;


    @PostMapping("/register")
    @Override
    public DtoUser register(@Valid @RequestBody AuthRequest request) {

        return authService.register(request);
    }
}
