package com.payment.exception;

import com.payment.constant.MessageConstants;
import com.payment.message.MessageService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private final MessageService messageService;
    protected GlobalExceptionHandler(MessageService messageService){
        this.messageService=messageService;
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            Object[] args = new String[]{error.getField()};
            errors.put(error.getField(), messageService.getMessage(error.getDefaultMessage(), args)); // Custom error messages
        }
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
