package com.github.huhangchn.core;

import com.github.huhangchn.configurer.MvcConfigurer;
import com.github.huhangchn.result.Result;

/**
 * 服务（业务）异常如“ 账号或密码错误 ”，该异常只做INFO级别的日志记录
 *
 * @see MvcConfigurer#configureHandlerExceptionResolvers
 */
public class ServiceException extends RuntimeException {
    private Result result;

    public ServiceException(Result result) {
        super(result.getMsg());
        this.result = result;
    }

    public Result getResult() {
        return result;
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
