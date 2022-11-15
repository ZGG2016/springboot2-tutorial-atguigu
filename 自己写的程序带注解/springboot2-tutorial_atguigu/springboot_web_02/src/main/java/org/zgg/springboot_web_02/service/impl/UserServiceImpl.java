package org.zgg.springboot_web_02.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.zgg.springboot_web_02.bean.User;
import org.zgg.springboot_web_02.mapper.UserMapper;
import org.zgg.springboot_web_02.service.UserService;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
