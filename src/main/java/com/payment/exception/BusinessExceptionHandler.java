package com.payment.exception;

import com.payment.message.MessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class BusinessExceptionHandler{

    private final MessageService messageService;

    protected BusinessExceptionHandler(MessageService messageService){
        this.messageService = messageService;
    }

    @ExceptionHandler({ApiException.class })
    protected ResponseEntity<ApiErrorResponse> handleApiException(ApiException ex) {
        return new ResponseEntity<>(new ApiErrorResponse(ex.getStatus(), messageService.getMessage(ex.getMessage(), null), Instant.now()), ex.getStatus());
    }
}

