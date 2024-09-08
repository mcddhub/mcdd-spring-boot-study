package com.mcddhub.demo03.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.HandlerMethod;

import java.time.ZonedDateTime;

/**
 * GlobalExceptionHandler
 *
 * @version 1.0.0
 * @author: coder-mcdd
 * @date: 2024/9/8 21:01
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(value = CustomerEmailUnavailableException.class)
    public ApiErrorResponse handleCustomerEmailUnavailableException(CustomerEmailUnavailableException ex,
                                                                    HttpServletRequest request,
                                                                    HandlerMethod method) {

        return new ApiErrorResponse(
                HttpStatus.CONFLICT, ex.getMessage(),
                request.getRequestURI(),
                method.getMethod().getName(),
                ZonedDateTime.now());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = CustomerNotFoundException.class)
    public ApiErrorResponse handleCustomerNotFoundException(CustomerNotFoundException ex,
                                                            HttpServletRequest request,
                                                            HandlerMethod method) {

        return new ApiErrorResponse(
                HttpStatus.NOT_FOUND, ex.getMessage(),
                request.getRequestURI(),
                method.getMethod().getName(),
                ZonedDateTime.now());
    }


}
