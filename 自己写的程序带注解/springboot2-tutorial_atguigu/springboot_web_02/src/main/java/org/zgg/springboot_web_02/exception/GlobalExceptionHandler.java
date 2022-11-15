package org.zgg.springboot_web_02.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 处理整个web controller的异常:
 * 定制错误处理逻辑2: @ControllerAdvice+@ExceptionHandler处理全局异常
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ArithmeticException.class, NullPointerException.class})
    public String handleArithException(Exception e){

        log.info("异常是：{}",e);

        return "login";
    }
}
