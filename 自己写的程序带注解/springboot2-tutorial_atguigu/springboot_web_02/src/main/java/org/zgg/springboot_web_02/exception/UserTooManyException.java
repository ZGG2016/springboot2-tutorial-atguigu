package org.zgg.springboot_web_02.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// 定制错误处理逻辑3: @ResponseStatus+自定义异常
@ResponseStatus(value= HttpStatus.FORBIDDEN,reason = "用户数量太多")
public class UserTooManyException extends RuntimeException {

    public UserTooManyException(){
    }

    public UserTooManyException(String message){
        super(message);
    }
}
