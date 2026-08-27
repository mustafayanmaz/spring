package com.musyan.handler;

import lombok.Data;

@Data
public class ApiError<E> {

    public int status;

    private Exception<E> exception;

}
