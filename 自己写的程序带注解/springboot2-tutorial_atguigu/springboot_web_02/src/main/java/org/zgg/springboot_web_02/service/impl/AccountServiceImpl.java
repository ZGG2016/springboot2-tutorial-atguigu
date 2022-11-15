package org.zgg.springboot_web_02.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zgg.springboot_web_02.bean.Account;
import org.zgg.springboot_web_02.mapper.AccountMapper;
import org.zgg.springboot_web_02.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountMapper accountMapper;

    @Override
    public Account getAcctByname(String username) {
        return accountMapper.getAcct(username);
    }
}
