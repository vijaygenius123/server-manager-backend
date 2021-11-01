package com.vijaygenius123.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {
    protected LocalDateTime timeStamp;
    protected Integer statusCode;
    protected HttpStatus httpStatus;
    protected String message;
    protected String reason;
    protected String developerMessage;
    protected Map<?,?> data;

}
