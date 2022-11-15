package org.zgg.springboot_web_02.service;


import org.zgg.springboot_web_02.bean.Account;

public interface AccountService {

    Account getAcctByname(String username);
}
