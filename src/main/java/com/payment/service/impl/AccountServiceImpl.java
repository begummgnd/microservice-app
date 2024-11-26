package com.payment.service.impl;

import com.payment.constant.MessageConstants;
import com.payment.dto.AccountDto;
import com.payment.exception.ApiException;
import com.payment.repository.AccountRepository;
import com.payment.service.AccountService;
import com.payment.service.mapper.AccountMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class AccountServiceImpl implements AccountService {

    private final AccountRepository repository;
    private final AccountMapper mapper;

    protected AccountServiceImpl(AccountRepository repository, AccountMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public AccountDto createAccount(AccountDto dto) {
        return null;
    }

    @Override
    public List<AccountDto> getAllAccountsByCustomerNumber() {
        throw new ApiException(MessageConstants.RENTACAR_DATA_NOT_FOUND, HttpStatus.NOT_FOUND);
    }
}
