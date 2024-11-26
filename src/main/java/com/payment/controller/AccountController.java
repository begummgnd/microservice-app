package com.payment.controller;

import com.payment.constant.ApiConstants;
import com.payment.constant.MessageConstants;
import com.payment.dto.AccountDto;
import com.payment.dto.SearchDto;
import com.payment.service.AccountService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping(ApiConstants.ACCOUNT)
public class AccountController {

    private final AccountService service;

    protected AccountController(AccountService service){
        this.service = service;
    }

    @PostMapping
    ResponseEntity<AccountDto> createAccount(@Valid @RequestBody AccountDto dto){
        return new ResponseEntity<>(service.createAccount(dto), HttpStatus.CREATED);
    }

    @GetMapping
    ResponseEntity<List<AccountDto>> getAllAccountsByCustomerNumber(@Valid SearchDto dto){
        return new ResponseEntity<>(service.getAllAccountsByCustomerNumber(), HttpStatus.OK);
    }
}
