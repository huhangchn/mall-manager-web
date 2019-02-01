package com.github.huhangchn.result;

public class ResultFactory {
    /**
     * 成功时候的调用,无data
     */
    public static Result success() {
        return success(null);
    }

    /**
     * 成功时候的调用
     */
    public static <T> Result success(T data) {
        return new Result<>(CodeMsg.SUCCESS, data);
    }

    /**
     * 失败时候的调用
     */
    public static Result error(CodeMsg codeMsg) {
        return new Result(codeMsg);
    }

    /**
     * 失败时候的调用，传参数
     */
    public static Result error(CodeMsg codeMsg, Object... args) {
        return new Result(codeMsg.format(args));
    }
}
