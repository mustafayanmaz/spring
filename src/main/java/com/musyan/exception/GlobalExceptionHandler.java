package com.musyan.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.*;

@ControllerAdvice
public class GlobalExceptionHandler {

    private List<String> addMapValue(List<String> list, String newValue){
        list.add(newValue);
        return list;
    }
    //Spring validatondan fırlatılan hataları alıp yönetmek ve repsonse dönmek için
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {

        Map<String , List<String>> errorsMap = new HashMap<>();

        for (ObjectError objectError : ex.getBindingResult().getAllErrors()){

            String fieldName = ((FieldError)objectError).getField();
            if(errorsMap.containsKey(fieldName)){
                errorsMap.put(fieldName, addMapValue(errorsMap.get(fieldName), objectError.getDefaultMessage()));


            }else {
                errorsMap.put(fieldName,addMapValue(new ArrayList<>(), objectError.getDefaultMessage()));
            }
        }

        return ResponseEntity.badRequest().body(createApiError(errorsMap));



    }

    //HEM MAP HEM STRİNG VErebiliyoruz generic method sayesinde
    private <T> ApiError<T> createApiError(T errors){

        ApiError<T> apiError = new ApiError<T>();
        apiError.setId(UUID.randomUUID().toString());
        apiError.setErrorTime(new Date());
        apiError.setErrors(errors);
        return apiError;
    }

}
