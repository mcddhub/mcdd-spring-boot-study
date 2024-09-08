package com.mcddhub.demo03.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

/**
 * ApiErrorResponse
 *
 * @version 1.0.0
 * @author: coder-mcdd
 * @date: 2024/9/8 21:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiErrorResponse {
    private HttpStatus httpStatus;
    private String message;
    private String path;
    private String api;
    private ZonedDateTime timestamp;

}
