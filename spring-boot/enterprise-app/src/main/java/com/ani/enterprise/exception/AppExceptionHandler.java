package com.ani.enterprise.exception;

import com.ani.enterprise.dto.AppRes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExceptionHandler  {

    @ExceptionHandler(value = {InvalidCountryException.class})
    public ResponseEntity<AppRes> notFoundHandler(Exception ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(
                        new AppRes("fail", ex.getMessage())
                );
    }
}
