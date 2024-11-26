package com.payment.message;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class MessageService {
    private final MessageSource messageSource;
    protected MessageService(MessageSource messageSource){
        this.messageSource = messageSource;
    }
    public String getMessage(String code, Object[] args) {
        return messageSource.getMessage(code, args, new Locale("tr","TR"));
    }
}
