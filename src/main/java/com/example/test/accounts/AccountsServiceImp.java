package com.example.test.accounts;

import org.springframework.stereotype.Service;

@Service
public class AccountsServiceImp implements AccountsService {
    @Override
    public Boolean createConfirmEmailURL() {
        
        return Boolean.TRUE;
    }
}
