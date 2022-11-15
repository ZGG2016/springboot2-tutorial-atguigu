package org.zgg.springboot_web_02.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.zgg.springboot_web_02.bean.Account;

//@Mapper
public interface AccountMapper {

    public Account getAcct(String username);
}
