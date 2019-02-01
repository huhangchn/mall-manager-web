package com.github.huhangchn.result;

public class Result<T> {

    private int code;
    private String msg;
    private T data;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    Result(CodeMsg codeMsg) {
        this(codeMsg, null);
    }

    Result(CodeMsg codeMsg, T data) {
        if (codeMsg != null) {
            this.code = codeMsg.getCode();
            this.msg = codeMsg.getMsg();
        }
        this.data = data;
    }
}
