package com.hackathon.Util;

public class ResponseResult {
    public Object data;
    public String message;

    private ResponseResult(Object data, String message) {
        this.data = data;
        this.message = message;
    }
    private ResponseResult(String errorMessage) {
        this.data = null;
        this.message = errorMessage;
    }

    public static ResponseResult success(Object data, String message) {
        ResponseResult responseResult = new ResponseResult(data,message);
        return responseResult;
    }

    public static ResponseResult fail(String errorMessage) {
        ResponseResult responseResult = new ResponseResult(errorMessage);
        return responseResult;
    }
}
