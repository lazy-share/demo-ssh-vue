package com.lazy.demo.sshvue.server.api.Interceptor;

import com.lazy.demo.sshvue.server.api.dto.ResponseDto;
import com.lazy.demo.sshvue.server.api.except.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 统一异常处理器
 *
 * @author laizhiyuan
 * @since 2020/2/5.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    public ResponseDto handleException(Exception exception) {
        if (exception instanceof BusinessException) {
            BusinessException e = (BusinessException) exception;
            logger.error("业务异常", e);
            return new ResponseDto(e.getCode(), e.getMsg(), null);
        }
        logger.error("系统异常", exception);
        return ResponseDto.except();
    }
}
